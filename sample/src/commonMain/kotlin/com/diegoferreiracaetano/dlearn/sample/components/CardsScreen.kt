package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.BannerCard
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.BannerCarousel
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.Carousel
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.CarouselItem
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.FullScreenBanner
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.FullScreenVideo
import dlearn.sample.generated.resources.Res
import dlearn.sample.generated.resources.banner1
import dlearn.sample.generated.resources.banner2
import dlearn.sample.generated.resources.banner3
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val RATING_1 = 4.5f
private const val RATING_2 = 4.8f
private const val RATING_3 = 4.2f

@Preview
@Composable
fun CardsScreen() {
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
    val dummyImage = listOf(
        Res.drawable.banner1,
        Res.drawable.banner2,
        Res.drawable.banner3
    )
    val dummyRatings = listOf(RATING_1, RATING_2, RATING_3)

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ComponentScaffold(
                title = "FullScreenBanner",
                description = "A full screen banner with video.",
                codeSnippet = "FullScreenBanner(pageCount = 3) { FullScreenVideo(...) }"
            ) {
                FullScreenBanner(
                    pageCount = dummyTitles.size,
                ) { pageIndex ->
                    FullScreenVideo(
                        title = dummyTitles[pageIndex],
                        subtitle = dummySubtitles[pageIndex],
                        imageResource = dummyImage[pageIndex],
                        onItemClick = { },
                        onWatchClick = { },
                        onAddToListClick = { }
                    )
                }
            }
        }
        item {
            ComponentScaffold(
                title = "BannerCarousel",
                description = "A carousel of banners.",
                codeSnippet = "BannerCarousel(title = \"Recomendados\", pageCount = 3) { BannerCard(...) }"
            ) {
                BannerCarousel(
                    title = "Recomendados",
                    pageCount = dummyTitles.size,
                ) { pageIndex ->
                    BannerCard(
                        title = dummyTitles[pageIndex],
                        subtitle = dummySubtitles[pageIndex],
                        imageResource = dummyImage[pageIndex],
                        onClick = { }
                    )
                }
            }
        }
        item {
            ComponentScaffold(
                title = "Carousel",
                description = "A carousel of movie video cards.",
                codeSnippet = "Carousel(title = \"New Releases\", itemCount = 3) { MovieVideoCard(...) }"
            ) {
                val carouselItems = dummyTitles.mapIndexed { index, value ->
                    CarouselItem(
                        title = value,
                        subtitle = dummySubtitles[index],
                        imageResource = dummyImage[index],
                        rating = dummyRatings[index],
                        onClick = {}
                    )
                }

                Carousel(
                    title = "New Releases",
                    items = carouselItems,
                )
            }
        }
    }
}
