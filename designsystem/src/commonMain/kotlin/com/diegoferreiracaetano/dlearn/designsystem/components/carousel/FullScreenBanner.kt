package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
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
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_add_to_list
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_watch
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val RATIO = 6f / 9f

/**
 * A full-screen banner component for displaying featured content (e.g., videos, courses).
 * It includes an image, title, subtitle, and action buttons.
 *
 * @param modifier The [Modifier] to be applied to the banner card.
 * @param title The title of the featured content.
 * @param subtitle The subtitle or description of the featured content.
 * @param imageSource The source of the banner image (URL or Resource).
 * @param onItemClick Action when the banner itself is clicked.
 * @param onWatchClick Action when the watch button is clicked.
 * @param onAddToListClick Action when the add to list button is clicked.
 */
@Composable
fun FullScreenVideo(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageSource: AppImageSource? = null,
    onItemClick: () -> Unit,
    onWatchClick: () -> Unit,
    onAddToListClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(RATIO)
            .clickable(onClick = onItemClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AppImage(
                source = imageSource,
                contentDescription = title,
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.scrim.copy(alpha = 0.85f)
                            ),
                            startY = 500f
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    AppButton(
                        modifier = Modifier.weight(1f),
                        onClick = onWatchClick,
                        text = stringResource(Res.string.action_watch)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                    AppButton(
                        modifier = Modifier.weight(1f),
                        onClick = onAddToListClick,
                        text = stringResource(Res.string.action_add_to_list),
                        type = ButtonType.SECONDARY
                    )
                }

                Spacer(modifier = Modifier.padding(bottom = 8.dp))
            }
        }
    }
}

/**
 * A horizontal pager component that displays multiple full-screen banners.
 *
 * @param modifier The [Modifier] to be applied to the pager container.
 * @param pageCount The number of pages in the banner.
 * @param pageContent The content for each page, indexed by position.
 */
@Composable
fun FullScreenBanner(
    modifier: Modifier = Modifier,
    pageCount: Int,
    pageContent: @Composable (pageIndex: Int) -> Unit
) {
    AppCarousel(
        itemCount = pageCount,
        modifier = modifier,
        itemContent = pageContent
    )
}

@Preview
@Composable
fun FullScreenVideoPreview() {
    DLearnTheme {
        FullScreenVideo(
            title = "Introduction to Jetpack Compose",
            subtitle = "Jetpack Compose",
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            onItemClick = { println("Clicked") },
            onWatchClick = { println("Watch Clicked") },
            onAddToListClick = { println("Add to List Clicked") }
        )
    }
}

@Preview
@Composable
fun FullScreenBannerPreview() {
    val dummyTitles = listOf(
        "Introduction to Jetpack Compose",
        "State Management in Compose",
        "Dagger Hilt for Dependency Injection"
    )
    val dummySubtitles = listOf(
        "Jetpack Compose",
        "Jetpack Compose",
        "Android"
    )
    val dummyImageSources = listOf(
        AppImageSource.Resource(Res.drawable.banner),
        AppImageSource.Resource(Res.drawable.banner),
        AppImageSource.Resource(Res.drawable.banner)
    )

    DLearnTheme {
        FullScreenBanner(
            pageCount = dummyTitles.size,
        ) { pageIndex ->
            FullScreenVideo(
                title = dummyTitles[pageIndex],
                subtitle = dummySubtitles[pageIndex],
                imageSource = dummyImageSources[pageIndex],
                onItemClick = { println("Clicked ${dummyTitles[pageIndex]}") },
                onWatchClick = { println("Watch ${dummyTitles[pageIndex]}") },
                onAddToListClick = { println("Add to List ${dummyTitles[pageIndex]}") }
            )
        }
    }
}
