package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test

class AppMovieDetailHeaderTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val providers = listOf(
        WatchProvider("Mercado Play", "https://icon.url".toAppImageSource(), "Free"),
        WatchProvider("Netflix", "https://icon.url".toAppImageSource(), "Subscription")
    )

    @Test
    fun appMovieDetailHeader_displaysTitleAndMetadata() {
        val sampleMovie = MovieItem(
            id = "1",
            title = "Riverdale",
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            year = "2021",
            duration = "148 Minutes",
            genre = "Action",
            rating = 4.5
        )

        composeTestRule.setContent {
            DLearnTheme {
                AppMovieDetailHeader(
                    movie = sampleMovie,
                    providers = providers,
                    onProviderClick = {}
                )
            }
        }

        composeTestRule.onNodeWithText(sampleMovie.year).assertIsDisplayed()
        composeTestRule.onNodeWithText(sampleMovie.duration).assertIsDisplayed()
        composeTestRule.onNodeWithText(sampleMovie.genre).assertIsDisplayed()
        composeTestRule.onNodeWithText(sampleMovie.rating.toString()).assertIsDisplayed()
    }

    @Test
    fun appMovieDetailHeader_onPlayClick_showsYoutubePlayer() {
        val sampleMovie = MovieItem(
            id = "1",
            title = "Riverdale",
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            youtubeVideoId = "dQw4w9WgXcQ"
        )

        composeTestRule.setContent {
            DLearnTheme {
                AppMovieDetailHeader(
                    movie = sampleMovie,
                    providers = providers,
                    onProviderClick = {}
                )
            }
        }

        // Click play button
        composeTestRule.onNodeWithTag(AppMovieActionsTags.PLAY_BUTTON).performClick()
    }
}
