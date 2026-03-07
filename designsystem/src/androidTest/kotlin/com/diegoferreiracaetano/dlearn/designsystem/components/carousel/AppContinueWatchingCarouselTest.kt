package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class AppContinueWatchingCarouselTest {

    @Test
    fun appContinueWatchingCarousel_displaysTitleAndItemContent() = runComposeUiTest {
        val title = "Continue Watching"
        val items = listOf("Episode 1", "Episode 2")

        setContent {
            AppContinueWatchingCarousel(
                title = title,
                itemCount = items.size,
            ) { index ->
                ContinueWatchingCard(
                    title = items[index],
                    onClick = {},
                )
            }
        }

        onNodeWithText(title).assertIsDisplayed()
        
        // Use assertExists() because items in a horizontal carousel might be partially or fully off-screen
        // depending on the screen size, which would cause assertIsDisplayed() to fail.
        onNodeWithText("Episode 1").assertExists()
        onNodeWithText("Episode 2").assertExists()
    }
}
