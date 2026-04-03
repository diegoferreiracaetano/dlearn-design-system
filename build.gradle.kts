plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.touchlab.kmmbridge) apply false
    alias(libs.plugins.kover) apply false
}

// Importa apenas o Detekt (Lint gratuito)
apply(from = "gradle/detekt.gradle")

subprojects {
    group = findProperty("GROUP") as String? ?: "com.diegoferreiracaetano.dlearn"
    version = findProperty("VERSION_NAME") as String? ?: "0.0.1"
}
