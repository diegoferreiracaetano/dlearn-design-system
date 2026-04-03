import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.mavenPublish)
    alias(libs.plugins.detekt)
    alias(libs.plugins.touchlab.kmmbridge)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kover)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)
        unitTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            freeCompilerArgs.add("-Xexpect-actual-classes")
        }
        publishLibraryVariants("release")
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries {
            framework {
                baseName = "DesignSystem"
                isStatic = false
                freeCompilerArgs += listOf(
                    "-Xbinary=bundleId=com.diegoferreiracaetano.dlearn.designsystem",
                    "-Xexpect-actual-classes"
                )
            }
        }
        iosTarget.compilerOptions {
            freeCompilerArgs.add("-Xexpect-actual-classes")
        }
    }
    
    js {
        browser()
        binaries.executable()
        compilerOptions {
            freeCompilerArgs.add("-Xexpect-actual-classes")
        }
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
        compilerOptions {
            freeCompilerArgs.add("-Xexpect-actual-classes")
        }
    }
    
    sourceSets {
        all {
            languageSettings {
                optIn("kotlin.experimental.ExperimentalObjCName")
            }
        }
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.youtube.player.core)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.materialIconsExtended)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.image.loader)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
        }
        
        androidUnitTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.robolectric)
        }

        // Adicionando as dependências para os testes instrumentados
        val androidInstrumentedTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.androidx.ui.test.junit4)
            }
        }
    }
}

android {
    namespace = "com.diegoferreiracaetano.dlearn.designsystem"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/versions/9/OSGI-INF/MANIFEST.MF"
        }
    }
    buildTypes {
        debug {
            enableAndroidTestCoverage = true
            enableUnitTestCoverage = true
        }
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    // Estas dependências do Android são necessárias para o Runner e Manifest de testes
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)
    debugImplementation(compose.uiTooling)
}

kover {
    reports {
        filters {
            excludes {
                classes(
                    "*.ComposableSingletons*",
                    "*PreviewKt*",
                    "*.BuildConfig",
                    "*Resource*",
                    "*.Res",
                    "*.Res$*",
                    "**_androidKt",
                    "**_iosKt"
                )
                annotatedBy("androidx.compose.ui.tooling.preview.Preview")
            }
        }

        variant("debug") {
            verify {
                rule {
                    minBound(80)
                }
            }
        }

        total {
            verify {
                rule {
                    minBound(80)
                }
            }
        }
    }
}

kmmbridge {
    gitHubReleaseArtifacts()
    spm(
        swiftToolVersion = "5.8",
        useCustomPackageFile = true
    ) {
        iOS { v("14") }
    }
}

addGithubPackagesRepository()
