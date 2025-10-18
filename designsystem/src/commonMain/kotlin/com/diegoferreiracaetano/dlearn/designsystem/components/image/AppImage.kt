package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val DefaultImageSize = 120.dp

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    imageURL: String? = null,
    imageResource: DrawableResource? = null,
    contentDescription: String? = null,
) {
    val painter = when {
        imageResource != null -> painterResource(imageResource)
        !imageURL.isNullOrEmpty() -> rememberImagePainter(imageURL)
        else -> painterResource(Res.drawable.banner)
    }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier.size(DefaultImageSize)
    )
}
