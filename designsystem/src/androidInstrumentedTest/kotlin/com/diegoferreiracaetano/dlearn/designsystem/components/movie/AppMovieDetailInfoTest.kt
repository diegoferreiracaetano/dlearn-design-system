package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test

class AppMovieDetailInfoTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appMovieDetailInfo_displaysAllMetadata() {
        val year = "2021"
        val duration = "148 Minutes"
        val genre = "Action"
        val rating = 4.5

        composeTestRule.setContent {
            DLearnTheme {
                AppMovieDetailInfo(
                    year = year,
                    duration = duration,
                    genre = genre,
                    rating = rating
                )
            }
        }

        composeTestRule.onNodeWithText(year).assertIsDisplayed()
        composeTestRule.onNodeWithText(duration).assertIsDisplayed()
        composeTestRule.onNodeWithText(genre).assertIsDisplayed()
        composeTestRule.onNodeWithText(rating.toString()).assertIsDisplayed()
    }
}
