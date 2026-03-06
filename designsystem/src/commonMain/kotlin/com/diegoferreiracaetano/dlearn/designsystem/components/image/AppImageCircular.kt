package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.placeholder
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A circular image component that clips an image into a circle.
 * Supports both local resources and remote URLs.
 *
 * @param modifier The [Modifier] to be applied to the image.
 * @param imageURL Optional URL of the image to load.
 * @param imageResource Optional [DrawableResource] to display.
 * @param contentDescription Optional accessibility description.
 */
@Composable
fun AppImageCircular(
    modifier: Modifier = Modifier,
    imageURL: String? = null,
    imageResource: DrawableResource? = null,
    contentDescription: String? = null,
) {
    val painter = when {
        imageResource != null -> painterResource(imageResource)
        !imageURL.isNullOrEmpty() -> rememberImagePainter(imageURL)
        else -> painterResource(Res.drawable.profile)
    }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(1f)
            .clip(CircleShape)
    )
}

@Preview
@Composable
fun AppImageCircularPreview() {
    DLearnTheme {
        AppImageCircular(
            imageResource = Res.drawable.profile
        )
    }
}
