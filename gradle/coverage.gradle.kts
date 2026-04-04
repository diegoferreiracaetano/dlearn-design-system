// gradle/coverage.gradle.kts

val jacocoVersion = extensions.getByType<VersionCatalogsExtension>().named("libs")
    .findVersion("jacoco").get().requiredVersion

configure<JacocoPluginExtension> {
    toolVersion = jacocoVersion
}

// Configuração do Kover
configure<org.jetbrains.kotlinx.kover.gradle.plugin.dsl.KoverProjectExtension> {
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
