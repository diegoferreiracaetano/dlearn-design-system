package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val BANNER_RATIO = 16f / 9f

/**
 * A specialized carousel for banners.
 *
 * @param modifier The [Modifier] to be applied to the carousel container.
 * @param title The title of the carousel section.
 * @param itemCount The number of items in the carousel.
 * @param itemContent The composable content for each banner page.
 */
@Composable
fun AppBannerCarousel(
    modifier: Modifier = Modifier,
    title: String,
    itemCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    AppCarousel(
        modifier = modifier,
        title = title,
        itemCount = itemCount,
        isPager = true,
        itemContent = itemContent,
    )
}

/**
 * A card component designed to be used within a banner carousel.
 */
@Composable
fun BannerCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageSource: AppImageSource? = null,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .aspectRatio(BANNER_RATIO)
            .fillMaxSize()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AppImage(
                source = imageSource,
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.scrim.copy(alpha = 0.7f),
                            ),
                            startY = 300f,
                        ),
                    ),
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp),
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = subtitle,
                    color = Color.White.copy(alpha = 0.8f),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBannerCarouselPreview() {
    val dummyTitles = listOf("Compose Intro", "State Management")
    DLearnTheme {
        AppBannerCarousel(
            title = "Recommended",
            itemCount = dummyTitles.size,
        ) { index ->
            BannerCard(
                title = dummyTitles[index],
                subtitle = "Subtitle $index",
                imageSource = AppImageSource.Resource(Res.drawable.banner),
                onClick = {},
            )
        }
    }
}
