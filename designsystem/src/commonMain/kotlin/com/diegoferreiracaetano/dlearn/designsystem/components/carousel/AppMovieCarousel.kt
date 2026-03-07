package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.AppMovieItem
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItem
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItemType
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A specialized carousel for displaying [MovieItem]s.
 *
 * @param modifier The [Modifier] to be applied to the carousel container.
 * @param title The title of the carousel section.
 * @param items The list of [MovieItem] to be displayed.
 * @param onMovieClick Callback triggered when a movie item is clicked.
 */
@Composable
fun AppMovieCarousel(
    modifier: Modifier = Modifier,
    title: String,
    items: List<MovieItem>,
    onMovieClick: (MovieItem) -> Unit = {},
) {
    AppCarousel(
        modifier = modifier,
        title = title,
        itemCount = items.size,
        isPager = false,
    ) { index ->
        val item = items[index]
        AppMovieItem(
            movie = item,
            type = MovieItemType.VERTICAL,
            onClick = { onMovieClick(item) },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppMovieCarouselPreview() {
    val dummyItems = listOf(
        MovieItem(
            id = "1",
            title = "Spider-Man No Way Home",
            year = "2021",
            duration = "148 min",
            contentRating = "PG-13",
            genre = "Action",
            type = "Movie",
            isPremium = true,
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            rating = 4.5,
            primaryInfo = "Novidade",
        ),
        MovieItem(
            id = "2",
            title = "Introduction to Compose",
            year = "2023",
            duration = "45 min",
            contentRating = "All",
            genre = "Education",
            type = "Course",
            isPremium = false,
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            rating = 4.8,
        ),
    )

    DLearnTheme {
        AppMovieCarousel(
            title = "New Releases",
            items = dummyItems,
        )
    }
}
