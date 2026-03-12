package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test

class AppMovieActionsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val providers = listOf(
        WatchProvider("Mercado Play", "https://icon.url".toAppImageSource(), "Free"),
        WatchProvider("Netflix", "https://icon.url".toAppImageSource(), "Subscription")
    )

    @Test
    fun appMovieActions_displaysPlayButton() {
        composeTestRule.setContent {
            DLearnTheme {
                AppMovieActions(
                    onPlayClick = {},
                    onAddToListClick = {},
                    onFavoriteClick = {},
                    providers = providers,
                    onProviderClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(AppMovieActionsTags.PLAY_BUTTON).assertIsDisplayed()
    }

    @Test
    fun appMovieActions_callsOnPlayClick() {
        var clicked = false
        composeTestRule.setContent {
            DLearnTheme {
                AppMovieActions(
                    onPlayClick = { clicked = true },
                    onAddToListClick = {},
                    onFavoriteClick = {},
                    providers = providers,
                    onProviderClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(AppMovieActionsTags.PLAY_BUTTON).performClick()
        assert(clicked)
    }

    @Test
    fun appMovieActions_expandsProvidersAndCallsClick() {
        var clickedProvider: WatchProvider? = null
        composeTestRule.setContent {
            DLearnTheme {
                AppMovieActions(
                    onPlayClick = {},
                    onAddToListClick = {},
                    onFavoriteClick = {},
                    providers = providers,
                    onProviderClick = { clickedProvider = it }
                )
            }
        }

        // Initially collapsed, should see "Onde assistir"
        composeTestRule.onNodeWithText("Onde assistir").assertIsDisplayed()
        
        // Click to expand
        composeTestRule.onNodeWithText("Onde assistir").performClick()
        
        // Now should see provider names
        composeTestRule.onNodeWithText("Netflix").assertIsDisplayed()
        
        // Click on a provider item
        composeTestRule.onNodeWithText("Netflix").performClick()
        
        assert(clickedProvider?.name == "Netflix")
    }
}
