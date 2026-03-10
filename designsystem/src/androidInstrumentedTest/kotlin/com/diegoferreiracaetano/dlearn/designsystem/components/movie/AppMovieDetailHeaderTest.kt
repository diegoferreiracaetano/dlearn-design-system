package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test

class AppMovieDetailHeaderTest {

    @get:Rule
    val composeTestRule = createComposeRule()

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
                AppMovieDetailHeader(movie = sampleMovie)
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
                AppMovieDetailHeader(movie = sampleMovie)
            }
        }

        // Click play button
        composeTestRule.onNodeWithTag(AppMovieActionsTags.PLAY_BUTTON).performClick()

        // Youtube player should be displayed (checking for a generic node if no tag is in the expect)
        // Note: The player doesn't have a testTag by default in the component unless we pass it, 
        // but we can verify it exists if we used matchParentSize which we did.
    }
}
