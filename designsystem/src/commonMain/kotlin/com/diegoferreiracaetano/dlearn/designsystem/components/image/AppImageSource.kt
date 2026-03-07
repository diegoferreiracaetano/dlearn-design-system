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
