plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.touchlab.kmmbridge) apply false
}

subprojects {

    group = findProperty("GROUP") as String? ?: "com.diegoferreiracaetano.dlearn"
    version = findProperty("VERSION_NAME") as String? ?: "0.0.1"

    apply(plugin = "io.gitlab.arturbosch.detekt")

    configure<io.gitlab.arturbosch.detekt.extensions.DetektExtension> {
        config.setFrom("${rootDir}/config/detekt/detekt.yml")
        buildUponDefaultConfig = true
        allRules = false
        source.setFrom("src")
    }

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        jvmTarget = "21"
        exclude("**/build/**")

        reports {
            html.required.set(true)
            xml.required.set(true)
            txt.required.set(false)
        }
    }

    tasks.register("detektAll") {
        group = "verification"
        description = "Runs Detekt on all subprojects"

        dependsOn(
            rootProject.subprojects.flatMap { sub ->
                sub.tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().toList()
            }
        )
    }
}
