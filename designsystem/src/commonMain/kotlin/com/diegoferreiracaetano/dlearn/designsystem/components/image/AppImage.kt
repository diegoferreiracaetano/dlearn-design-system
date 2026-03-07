package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.placeholder
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val DefaultImageSize = 120.dp

/**
 * A flexible image component that can load images from a [AppImageSource].
 *
 * @param modifier The [Modifier] to be applied to the image.
 * @param source The source of the image (URL or Resource).
 * @param contentDescription Optional accessibility description for the image.
 */
@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    source: AppImageSource? = null,
    contentDescription: String? = null,
) {
    val painter = when (source) {
        is AppImageSource.Resource -> painterResource(source.resource)
        is AppImageSource.Url -> rememberImagePainter(source.url)
        null -> painterResource(Res.drawable.placeholder)
    }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier.size(DefaultImageSize)
    )
}

@Preview
@Composable
fun AppImagePreview() {
    AppImage()
}
