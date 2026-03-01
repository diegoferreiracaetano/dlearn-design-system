package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class ContinueWatchingCarouselTest {

    @Test
    fun shouldDisplayTitleAndCardsWhenRendered() = runComposeUiTest {
        val title = "Continue Watching"
        val cardTitle = "Video 1"
        
        setContent {
            ContinueWatchingCarousel(
                title = title,
                itemCount = 1
            ) {
                ContinueWatchingCard(
                    title = cardTitle,
                    imageUrl = "",
                    onClick = {}
                )
            }
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(cardTitle).assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnClickWhenCardIsClicked() = runComposeUiTest {
        var clicked = false
        val cardTitle = "Clickable Card"
        
        setContent {
            ContinueWatchingCarousel(
                title = "Carousel",
                itemCount = 1
            ) {
                ContinueWatchingCard(
                    title = cardTitle,
                    imageUrl = "",
                    onClick = { clicked = true }
                )
            }
        }

        onNodeWithText(cardTitle).performClick()

        assertTrue(clicked, "The onClick callback should have been triggered")
    }
}
