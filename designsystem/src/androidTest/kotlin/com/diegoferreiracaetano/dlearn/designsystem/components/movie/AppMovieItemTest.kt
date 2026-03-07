package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppMovieItemTest {

    private val sampleMovie = MovieItem(
        id = "1",
        title = "Spider-Man No Way Home",
        imageSource = AppImageSource.Resource(Res.drawable.banner),
        rating = 4.5,
        year = "2021",
        duration = "148 Minutes",
        contentRating = "PG-13",
        genre = "Action",
        type = "Movie",
        isPremium = true,
        primaryInfo = "New",
        secondaryInfo = "Trending"
    )

    @Test
    fun shouldDisplayMovieMetadataInHorizontalLayout() = runComposeUiTest {
        setContent {
            AppMovieItem(
                movie = sampleMovie,
                onClick = {},
                type = MovieItemType.HORIZONTAL
            )
        }

        onNodeWithText(sampleMovie.title).assertExists()
        onNodeWithText(sampleMovie.rating.toString()).assertExists()
        onNodeWithText(sampleMovie.year).assertExists()
        onNodeWithText(sampleMovie.duration).assertExists()
        onNodeWithText(sampleMovie.contentRating).assertExists()
        onNodeWithText("${sampleMovie.genre}  |  ${sampleMovie.type}").assertExists()
        onNodeWithText(sampleMovie.primaryInfo!!).assertExists()
        onNodeWithText(sampleMovie.secondaryInfo!!).assertExists()
    }

    @Test
    fun shouldDisplayMovieMetadataInVerticalLayout() = runComposeUiTest {
        setContent {
            AppMovieItem(
                movie = sampleMovie,
                onClick = {},
                type = MovieItemType.VERTICAL
            )
        }

        onNodeWithText(sampleMovie.title).assertExists()
        onNodeWithText(sampleMovie.rating.toString()).assertExists()
        onNodeWithText("${sampleMovie.genre}  •  ${sampleMovie.year}").assertExists()
        onNodeWithText(sampleMovie.primaryInfo!!).assertExists()
        onNodeWithText(sampleMovie.secondaryInfo!!).assertExists()
    }

    @Test
    fun shouldDisplayPremiumTagWhenMovieIsPremium() = runComposeUiTest {
        setContent {
            AppMovieItem(
                movie = sampleMovie.copy(isPremium = true),
                onClick = {},
                type = MovieItemType.HORIZONTAL
            )
        }

        // Note: In real app, we should use stringResource, but in test we check for the text value.
        // Assuming "Premium" is the text for label_premium in the default locale.
        onNodeWithText("Premium").assertExists()
    }

    @Test
    fun shouldDisplayFreeTagWhenMovieIsNotPremium() = runComposeUiTest {
        setContent {
            AppMovieItem(
                movie = sampleMovie.copy(isPremium = false),
                onClick = {},
                type = MovieItemType.HORIZONTAL
            )
        }

        onNodeWithText("Free").assertExists()
    }

    @Test
    fun shouldTriggerOnClick() = runComposeUiTest {
        var clicked = false
        setContent {
            AppMovieItem(
                movie = sampleMovie,
                onClick = { clicked = true }
            )
        }

        onNodeWithText(sampleMovie.title).performClick()
        assertTrue(clicked)
    }
}
