package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_placeholder
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A circular image component that clips an image into a circle.
 * Supports both local resources and remote URLs via [AppImageSource].
 *
 * @param modifier The [Modifier] to be applied to the image.
 * @param source The source of the image (URL or Resource).
 * @param contentDescription Optional accessibility description.
 */
@Composable
fun AppImageCircular(
    modifier: Modifier = Modifier,
    source: AppImageSource? = null,
    contentDescription: String? = null,
) {
    val painter = when (source) {
        is AppImageSource.Resource -> painterResource(source.resource)
        is AppImageSource.Url -> rememberImagePainter(source.url)
        is AppImageSource.Vector -> rememberVectorPainter(source.imageVector)
        null -> painterResource(Res.drawable.profile_placeholder)
    }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(1f)
            .clip(CircleShape),
    )
}

@Preview
@Composable
fun AppImageCircularPreview() {
    DLearnTheme {
        AppImageCircular(
            source = null
        )
    }
}
