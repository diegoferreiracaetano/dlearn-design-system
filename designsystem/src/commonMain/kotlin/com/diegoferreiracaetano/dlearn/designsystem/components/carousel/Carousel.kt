package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.AppMovieItem
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItem
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItemType
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A horizontal carousel component that displays a list of [MovieItem].
 * It supports both a standard list style and a "Top 10" ranked style via [MovieItem.rank].
 *
 * @param modifier The [Modifier] to be applied to the carousel container.
 * @param title The title of the carousel section.
 * @param items The list of [MovieItem] to be displayed.
 * @param onMovieClick Callback triggered when a movie item is clicked.
 */
@Composable
fun Carousel(
    modifier: Modifier = Modifier,
    title: String,
    items: List<MovieItem>,
    onMovieClick: (MovieItem) -> Unit = {}
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(items) { item ->
                AppMovieItem(
                    movie = item,
                    type = MovieItemType.VERTICAL,
                    onClick = { onMovieClick(item) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarouselDefaultPreview() {
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
            primaryInfo = "Novidade"
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
        MovieItem(
            id = "3",
            title = "Dagger Hilt Deep Dive",
            year = "2022",
            duration = "120 min",
            contentRating = "12+",
            genre = "Technical",
            type = "Tutorial",
            isPremium = true,
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            rating = 4.2,
            primaryInfo = "Novo episódio",
            secondaryInfo = "Assista já"
        ),
    )

    DLearnTheme {
        Carousel(
            title = "New Releases",
            items = dummyItems,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CarouselTop10Preview() {
    val dummyItems = listOf(
        MovieItem(
            id = "1",
            rank = 1,
            title = "Spider-Man No Way Home",
            year = "2021",
            duration = "148 min",
            contentRating = "PG-13",
            genre = "Action",
            type = "Movie",
            isPremium = true,
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            rating = 4.5,
            primaryInfo = "Novidade"
        ),
        MovieItem(
            id = "2",
            rank = 2,
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
        MovieItem(
            id = "3",
            rank = 3,
            title = "Dagger Hilt Deep Dive",
            year = "2022",
            duration = "120 min",
            contentRating = "12+",
            genre = "Technical",
            type = "Tutorial",
            isPremium = true,
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            rating = 4.2,
            primaryInfo = "Novo episódio",
            secondaryInfo = "Assista já"
        ),
    )

    DLearnTheme {
        Carousel(
            title = "Top 10 in Brazil",
            items = dummyItems,
        )
    }
}
