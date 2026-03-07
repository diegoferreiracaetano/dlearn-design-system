package com.diegoferreiracaetano.dlearn.designsystem.components.image

import org.jetbrains.compose.resources.DrawableResource

/**
 * A sealed class representing the source of an image.
 * It can be either a remote URL or a local [DrawableResource].
 */
sealed class AppImageSource {
    data class Url(val url: String) : AppImageSource()
    data class Resource(val resource: DrawableResource) : AppImageSource()
}

/**
 * Extension to convert a String (URL) to [AppImageSource.Url].
 */
fun String.toAppImageSource(): AppImageSource = AppImageSource.Url(this)

/**
 * Extension to convert a [DrawableResource] to [AppImageSource.Resource].
 */
fun DrawableResource.toAppImageSource(): AppImageSource = AppImageSource.Resource(this)
