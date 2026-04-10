package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.banner.AppBanner
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.AppBannerCarousel
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.AppMovieCarousel
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.BannerCard
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.FullScreenBanner
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.FullScreenVideo
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItem
import com.diegoferreiracaetano.dlearn.sample.generated.resources.Res
import com.diegoferreiracaetano.dlearn.sample.generated.resources.banner1
import com.diegoferreiracaetano.dlearn.sample.generated.resources.banner2
import com.diegoferreiracaetano.dlearn.sample.generated.resources.banner3
import org.jetbrains.compose.ui.tooling.preview.Preview

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

    val movieItems = dummyTitles.mapIndexed { index, title ->
        MovieItem(
            id = index.toString(),
            title = title,
            year = "2024",
            duration = "1h 30min",
            contentRating = "12+",
            genre = dummySubtitles[index],
            type = "Movie",
            imageSource = AppImageSource.Resource(dummyImage[index]),
            rating = 4.5,
        )
    }

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            ComponentScaffold(
                title = "AppBanner",
                description = "Um banner informativo ou de destaque com ícone opcional.",
                codeSnippet = "AppBanner(title = \"Premium\", description = \"...\", icon = Icons.Default.WorkspacePremium)"
            ) {
                AppBanner(
                    title = "Premium Member",
                    description = "New movies are coming for you, Download Now!",
                    icon = Icons.Default.WorkspacePremium
                )
            }
        }

        item {
            ComponentScaffold(
                title = "FullScreenBanner",
                description = "Um banner em tela cheia com vídeo ou imagem de destaque.",
                codeSnippet = "FullScreenBanner(pageCount = 3) { index -> FullScreenVideo(...) }"
            ) {
                FullScreenBanner(
                    pageCount = dummyTitles.size,
                ) { pageIndex ->
                    FullScreenVideo(
                        title = dummyTitles[pageIndex],
                        subtitle = dummySubtitles[pageIndex],
                        imageSource = AppImageSource.Resource(dummyImage[pageIndex]),
                        onItemClick = { },
                        onWatchClick = { },
                        onAddToListClick = { }
                    )
                }
            }
        }

        item {
            ComponentScaffold(
                title = "AppBannerCarousel",
                description = "Um carrossel de banners para recomendações usando BannerCard.",
                codeSnippet = "AppBannerCarousel(title = \"Recomendados\", itemCount = 3) { index -> BannerCard(...) }"
            ) {
                AppBannerCarousel(
                    title = "Recomendados",
                    itemCount = dummyTitles.size,
                    itemContent = { pageIndex ->
                        BannerCard(
                            title = dummyTitles[pageIndex],
                            subtitle = dummySubtitles[pageIndex],
                            imageSource = AppImageSource.Resource(dummyImage[pageIndex]),
                            onClick = { }
                        )
                    }
                )
            }
        }

        item {
            ComponentScaffold(
                title = "AppMovieCarousel",
                description = "Carrossel especializado para filmes com MovieItem.",
                codeSnippet = "AppMovieCarousel(title = \"New Releases\", items = movieItems) "
            ) {
                AppMovieCarousel(
                    title = "New Releases",
                    items = movieItems,
                    onMovieClick = { }
                )
            }
        }
    }
}
