package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class FullScreenVideoTest {

    @Test
    fun shouldDisplayTitleAndSubtitleWhenRendered() = runComposeUiTest {
        val title = "Awesome Video"
        val subtitle = "Android Development"
        
        setContent {
            FullScreenVideo(
                title = title,
                subtitle = subtitle,
                onItemClick = {},
                onWatchClick = {},
                onAddToListClick = {}
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(subtitle).assertIsDisplayed()
    }

    @Test
    fun shouldTriggerCallbacksWhenButtonsAreClicked() = runComposeUiTest {
        var watchClicked = false
        var addToListClicked = false
        
        setContent {
            FullScreenVideo(
                title = "Video",
                subtitle = "Sub",
                onItemClick = {},
                onWatchClick = { watchClicked = true },
                onAddToListClick = { addToListClicked = true }
            )
        }

        // Use partial match or hardcoded strings if resources are not accessible in test environment easily
        onNodeWithText("Assistir", ignoreCase = true).performClick()
        onNodeWithText("Minha lista", ignoreCase = true).performClick()

        assertTrue(watchClicked, "Watch callback should be triggered")
        assertTrue(addToListClicked, "Add to list callback should be triggered")
    }
}
