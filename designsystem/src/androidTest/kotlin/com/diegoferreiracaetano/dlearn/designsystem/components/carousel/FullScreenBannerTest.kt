package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.material3.Text
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class FullScreenBannerTest {

    @Test
    fun shouldDisplayFullScreenBannerWhenRendered() = runComposeUiTest {
        setContent {
            FullScreenBanner(
                pageCount = 1,
                pageContent = { index ->
                    Text("Banner Page $index")
                }
            )
        }

        onNodeWithText("Banner Page 0").assertIsDisplayed()
    }

    @Test
    fun shouldDisplayFullScreenVideoAndHandleClicks() = runComposeUiTest {
        var watchClicked = false
        var addClicked = false
        val title = "Video Title"
        
        setContent {
            FullScreenVideo(
                title = title,
                subtitle = "Subtitle",
                onItemClick = {},
                onWatchClick = { watchClicked = true },
                onAddToListClick = { addClicked = true }
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        
        // Use strings from strings.xml
        onNodeWithText("Assistir", ignoreCase = true).performClick()
        assertTrue(watchClicked, "Watch click should be triggered")

        onNodeWithText("Minha lista", ignoreCase = true).performClick()
        assertTrue(addClicked, "Add to List click should be triggered")
    }
}
