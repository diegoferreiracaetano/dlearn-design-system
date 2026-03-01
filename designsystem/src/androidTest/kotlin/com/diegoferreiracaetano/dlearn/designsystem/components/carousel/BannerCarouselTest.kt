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
class BannerCarouselTest {

    @Test
    fun shouldDisplayTitleAndActivePageWhenRendered() = runComposeUiTest {
        val title = "Featured Banners"
        setContent {
            BannerCarousel(
                title = title,
                pageCount = 2,
                pageContent = { index ->
                    Text("Page $index")
                }
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText("Page 0").assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnClickWhenBannerCardIsClicked() = runComposeUiTest {
        var clicked = false
        val cardTitle = "Banner Card"
        
        setContent {
            BannerCard(
                title = cardTitle,
                subtitle = "Subtitle",
                onClick = { clicked = true }
            )
        }

        onNodeWithText(cardTitle).performClick()

        assertTrue(clicked, "The onClick callback should have been triggered")
    }
}
