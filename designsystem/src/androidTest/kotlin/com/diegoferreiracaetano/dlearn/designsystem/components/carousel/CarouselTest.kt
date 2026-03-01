package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class CarouselTest {

    @Test
    fun shouldDisplayTitleAndItemsWhenRendered() = runComposeUiTest {
        val title = "Featured"
        val items = listOf(
            CarouselItem(title = "Item 1", subtitle = "Subtitle 1"),
            CarouselItem(title = "Item 2", subtitle = "Subtitle 2")
        )
        
        setContent {
            Carousel(title = title, items = items)
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText("Item 1").assertIsDisplayed()
        onNodeWithText("Item 2").assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnClickWhenItemIsClicked() = runComposeUiTest {
        var clicked = false
        val items = listOf(
            CarouselItem(title = "Clickable Item", onClick = { clicked = true })
        )
        
        setContent {
            Carousel(title = "Carousel", items = items)
        }

        onNodeWithText("Clickable Item").performClick()

        assertTrue(clicked, "The onClick callback should have been triggered")
    }
}
