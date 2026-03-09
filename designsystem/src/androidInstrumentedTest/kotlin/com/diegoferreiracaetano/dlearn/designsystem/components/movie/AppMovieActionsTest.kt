package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test

class AppMovieActionsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appMovieActions_displaysAllButtons() {
        composeTestRule.setContent {
            DLearnTheme {
                AppMovieActions(
                    onPlayClick = {},
                    onDownloadClick = {},
                    onShareClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(AppMovieActionsTags.PLAY_BUTTON).assertIsDisplayed()
        composeTestRule.onNodeWithTag(AppMovieActionsTags.DOWNLOAD_BUTTON).assertIsDisplayed()
        composeTestRule.onNodeWithTag(AppMovieActionsTags.SHARE_BUTTON).assertIsDisplayed()
    }

    @Test
    fun appMovieActions_callsOnPlayClick() {
        var clicked = false
        composeTestRule.setContent {
            DLearnTheme {
                AppMovieActions(
                    onPlayClick = { clicked = true },
                    onDownloadClick = {},
                    onShareClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(AppMovieActionsTags.PLAY_BUTTON).performClick()
        assert(clicked)
    }

    @Test
    fun appMovieActions_callsOnDownloadClick() {
        var clicked = false
        composeTestRule.setContent {
            DLearnTheme {
                AppMovieActions(
                    onPlayClick = {},
                    onDownloadClick = { clicked = true },
                    onShareClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(AppMovieActionsTags.DOWNLOAD_BUTTON).performClick()
        assert(clicked)
    }

    @Test
    fun appMovieActions_callsOnShareClick() {
        var clicked = false
        composeTestRule.setContent {
            DLearnTheme {
                AppMovieActions(
                    onPlayClick = {},
                    onDownloadClick = {},
                    onShareClick = { clicked = true }
                )
            }
        }

        composeTestRule.onNodeWithTag(AppMovieActionsTags.SHARE_BUTTON).performClick()
        assert(clicked)
    }
}
