package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * A sealed class representing the source of an image.
 * It can be either a remote URL or a local [DrawableResource].
 */
sealed class AppImageSource {
    data class Url(val url: String) : AppImageSource()
    data class Resource(val resource: DrawableResource) : AppImageSource()
    data class Vector(val imageVector: ImageVector) : AppImageSource()
}

/**
 * Extension to convert a String (URL) to [AppImageSource.Url].
 */
fun String.toAppImageSource(): AppImageSource = AppImageSource.Url(this)

/**
 * Extension to convert a [DrawableResource] to [AppImageSource.Resource].
 */
fun DrawableResource.toAppImageSource(): AppImageSource = AppImageSource.Resource(this)

@Composable
fun AppImageSource.toPainter() = when (this) {
    is AppImageSource.Resource -> painterResource(resource)
    is AppImageSource.Url -> rememberImagePainter(url)
    is AppImageSource.Vector -> rememberVectorPainter(imageVector)
}
