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
    jacoco
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)

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
    }
}

android {
    namespace = "com.diegoferreiracaetano.dlearn.designsystem"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.kotlin.test)
    debugImplementation(libs.ui.test.manifest)
    debugImplementation(compose.uiTooling)
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

val jacocoVersion = extensions.getByType<VersionCatalogsExtension>().named("libs")
    .findVersion("jacoco").get().requiredVersion

configure<JacocoPluginExtension> {
    toolVersion = jacocoVersion
}

// Configuração do Kover
kover {
    reports {
        total {
            xml { onCheck = true }
            html { onCheck = true }
        }
        verify {
            rule {
                minBound(1) // 1% para começar
            }
        }
    }
}

// Injeção de dados binários externos no Kover
dependencies.add("kover", fileTree(layout.buildDirectory.dir("outputs/code_coverage/debugAndroidTest/connected")) { include("**/*.ec") })
dependencies.add("kover", fileTree(layout.buildDirectory.dir("outputs/unit_test_code_coverage/debugUnitTest")) { include("**/*.exec") })

// Task JaCoCo Unificada para Android
tasks.register<JacocoReport>("jacocoAndroidTestReport") {
    group = "Reporting"
    description = "Gera relatório de cobertura JaCoCo unificado para Android (Unit + Instrumented)"

    dependsOn("testDebugUnitTest", "connectedDebugAndroidTest")

    reports {
        xml.required.set(true)
        html.required.set(true)
    }

    val excludes = listOf(
        "**/R.class", "**/R$*.class", "**/BuildConfig.*", "**/Manifest*.*",
        "**/*Test*.*", "android/databinding/**/*.class", "**/BR.*",
        "**/Dagger*.*", "**/*_MembersInjector.class", "**/*_Factory.class"
    )

    val kotlinClasses = fileTree(layout.buildDirectory.dir("tmp/kotlin-classes/debug")) { exclude(excludes) }
    val javaClasses = fileTree(layout.buildDirectory.dir("intermediates/javac/debug")) { exclude(excludes) }

    classDirectories.setFrom(files(kotlinClasses, javaClasses))
    sourceDirectories.setFrom(files(
        "$projectDir/src/main/java",
        "$projectDir/src/androidMain/kotlin",
        "$projectDir/src/commonMain/kotlin"
    ))

    executionData.setFrom(fileTree(layout.buildDirectory) {
        include(
            "outputs/unit_test_code_coverage/debugUnitTest/testDebugUnitTest.exec",
            "outputs/code_coverage/debugAndroidTest/connected/*/coverage.ec"
        )
    })
}

// Task de Verificação (CI)
tasks.register<JacocoCoverageVerification>("jacocoAndroidTestVerify") {
    group = "Verification"
    description = "Verifica limites de cobertura JaCoCo para Android"
    dependsOn("jacocoAndroidTestReport")

    violationRules {
        rule {
            limit {
                minimum = "0.01".toBigDecimal()
            }
        }
    }

    val kotlinClasses = fileTree(layout.buildDirectory.dir("tmp/kotlin-classes/debug"))
    classDirectories.setFrom(files(kotlinClasses))
    executionData.setFrom(fileTree(layout.buildDirectory) {
        include(
            "outputs/unit_test_code_coverage/debugUnitTest/testDebugUnitTest.exec",
            "outputs/code_coverage/debugAndroidTest/connected/*/coverage.ec"
        )
    })
}

