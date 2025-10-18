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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_add_to_list
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_watch
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner1
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner2
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner3
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val RATIO = 12f / 16f

@Composable
fun FullScreenVideo(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageResource: DrawableResource? = null,
    imageUrl: String? = null,
    onItemClick: () -> Unit,
    onWatchClick: () -> Unit,
    onAddToListClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(RATIO)
            .clickable(onClick = onItemClick),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
    ) {
        Box(
            modifier = modifier.fillMaxWidth()
        ) {
            AppImage(
                imageURL = imageUrl,
                imageResource = imageResource,
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
                                Color.Unspecified.copy(alpha = 0.85f)
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

@Composable
fun FullScreenBanner(
    modifier: Modifier = Modifier,
    pageCount: Int,
    pageContent: @Composable (pageIndex: Int) -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { pageCount }
    )

    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState
        ) { pageIndex ->
            pageContent(pageIndex)
        }

        if (pageCount > 1) {
            PageIndicator(
                pageCount,
                currentPage = pagerState.currentPage,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview
@Composable
fun FullScreenVideoPreview() {
    DLearnTheme {
        FullScreenVideo(
            title = "Introduction to Jetpack Compose",
            subtitle = "Jetpack Compose",
            imageResource = Res.drawable.banner1,
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
    val dummyImageUrls = listOf(
        Res.drawable.banner1,
        Res.drawable.banner2,
        Res.drawable.banner3
    )

    DLearnTheme {
        FullScreenBanner(
            pageCount = dummyTitles.size,
        ) { pageIndex ->
            FullScreenVideo(
                title = dummyTitles[pageIndex],
                subtitle = dummySubtitles[pageIndex],
                imageResource = dummyImageUrls[pageIndex],
                onItemClick = { println("Clicked ${dummyTitles[pageIndex]}") },
                onWatchClick = { println("Watch ${dummyTitles[pageIndex]}") },
                onAddToListClick = { println("Add to List ${dummyTitles[pageIndex]}") }
            )
        }
    }
}
