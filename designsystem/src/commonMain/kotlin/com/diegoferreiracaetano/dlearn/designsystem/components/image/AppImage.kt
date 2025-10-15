package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppImage(
    imageURL: String? = null,
    imageResource: DrawableResource? = null,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
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
        modifier = modifier.size(120.dp)
    )
}