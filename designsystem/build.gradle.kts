import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.detekt)
    alias(libs.plugins.touchlab.kmmbridge)
    `maven-publish`
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
//        publishLibraryVariants("release") // Publicar apenas a variante release
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries {
            framework {
        //        baseName = "DesignSystem"
                isStatic = true
          //      freeCompilerArgs += listOf("-Xbinary=bundleId=com.diegoferreiracaetano.dlearn.designsystem")
            }
        }
    }
    
    js {
        browser()
        binaries.executable()
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
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
        }
    }
}

android {
    namespace = "com.diegoferreiracaetano.dlearn.designsystem"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
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
    debugImplementation(compose.uiTooling)
}



kmmbridge {
    gitHubReleaseArtifacts()
    spm(swiftToolVersion = "5.8") {
        iOS { v("14") }
    }
}

//publishing {
//    publications.withType<MavenPublication>().configureEach {
//        // Adiciona um sufixo ao artifactId para diferenciar as publicações de cada plataforma,
//        // exceto para a publicação principal que contém apenas os metadados.
//        if (name != "kotlinMultiplatform") {
//            artifactId = "designsystem-$name"
//        } else {
//            artifactId = "designsystem"
//        }
//
//        groupId = project.group.toString()
//        version = project.version.toString()
//
//        pom {
//            name.set("DesignSystem")
//            description.set("Design System multiplataforma para Android e iOS")
//            url.set("https://github.com/diegoferreiracaetano/dlearn-design-system")
//            licenses {
//                license {
//                    name.set("MIT License")
//                    url.set("https://opensource.org/licenses/MIT")
//                }
//            }
//            developers {
//                developer {
//                    id.set("diegoferreiracaetano")
//                    name.set("Diego Ferreira Caetano")
//                }
//            }
//            scm {
//                url.set("https://github.com/diegoferreiracaetano/dlearn-design-system")
//            }
//        }
//    }
//
//    repositories {
//        maven {
//            name = "GitHubPackages"
//            url = uri("https://maven.pkg.github.com/diegoferreiracaetano/dlearn-design-system")
//            credentials {
//                username = System.getenv("GITHUB_ACTOR") ?: project.findProperty("gpr.user") as String?
//                password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("gpr.key") as String?
//            }
//        }
//    }
//}
//
//
//tasks.matching { it.name.startsWith("publishIos") || it.name.contentEquals("Js") }.configureEach {
//    enabled = false
//}
//
//
//publishing {
//    repositories {
//        maven {
//            name = "GitHubPackages"
//            url = uri("https://maven.pkg.github.com/diegoferreiracaetano/dlearn-design-system")
//            credentials {
//                username = System.getenv("GITHUB_ACTOR") ?: project.findProperty("gpr.user") as String?
//                password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("gpr.key") as String?
//            }
//        }
//    }
//}
//
