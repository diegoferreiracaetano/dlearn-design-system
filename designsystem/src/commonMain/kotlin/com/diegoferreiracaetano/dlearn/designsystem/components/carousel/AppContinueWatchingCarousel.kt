package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val CONTINUE_WATCHING_RATIO = 16f / 9f

/**
 * A specialized carousel for "Continue Watching" items.
 *
 * @param modifier The [Modifier] to be applied to the carousel container.
 * @param title The title of the carousel section.
 * @param itemCount The number of items in the carousel.
 * @param itemContent The composable content for each item.
 */
@Composable
fun AppContinueWatchingCarousel(
    modifier: Modifier = Modifier,
    title: String,
    itemCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    AppCarousel(
        modifier = modifier,
        title = title,
        itemCount = itemCount,
        isPager = false,
        spacing = 12.dp,
        itemContent = itemContent,
    )
}

/**
 * A card component designed for the "Continue Watching" carousel.
 */
@Composable
fun ContinueWatchingCard(
    modifier: Modifier = Modifier,
    title: String,
    imageSource: AppImageSource? = null,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier.clickable(onClick = onClick),
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(CONTINUE_WATCHING_RATIO)
                .clip(MaterialTheme.shapes.small),
        ) {
            AppImage(
                source = imageSource,
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.scrim.copy(alpha = 0.8f),
                            ),
                        ),
                    ),
            )

            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center),
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppContinueWatchingPreview() {
    DLearnTheme {
        AppContinueWatchingCarousel(
            title = "Continue Watching",
            itemCount = 2,
        ) { index ->
            ContinueWatchingCard(
                modifier = Modifier.width(300.dp),
                title = "Item $index",
                imageSource = AppImageSource.Resource(Res.drawable.banner),
                onClick = {},
            )
        }
    }
}
