package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItem
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class AppMovieCarouselTest {

    @Test
    fun appMovieCarousel_displaysTitleAndMovieTitles() = runComposeUiTest {
        val title = "Trending"
        val movies = listOf(
            MovieItem(
                id = "1",
                title = "Movie One",
                imageSource = AppImageSource.Url(""),
                rating = 4.5,
                year = "2021",
                duration = "120 min",
                contentRating = "PG-13",
                genre = "Action",
                type = "Movie",
                isPremium = false,
            ),
            MovieItem(
                id = "2",
                title = "Movie Two",
                imageSource = AppImageSource.Url(""),
                rating = 4.8,
                year = "2023",
                duration = "45 min",
                contentRating = "All",
                genre = "Education",
                type = "Course",
                isPremium = true,
            ),
        )

        setContent {
            AppMovieCarousel(
                title = title,
                items = movies,
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText("Movie One").assertExists()
        onNodeWithText("Movie Two").assertExists()
    }
}
