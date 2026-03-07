package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.material3.Text
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class PageCarouselTest {

    @Test
    fun shouldDisplayContentOfFirstPageInitially() = runComposeUiTest {
        val page1Info = "Welcome to DLearn"
        
        setContent {
            PageCarousel(
                pageCount = 2,
                onFinish = {},
                imageContent = { Text("Image $it") },
                infoContent = { index ->
                    Text(if (index == 0) page1Info else "Page 2")
                }
            )
        }

        onNodeWithText(page1Info).assertIsDisplayed()
        onNodeWithText("Image 0").assertIsDisplayed()
    }

    @Test
    fun shouldNavigateToNextPageWhenButtonIsClicked() = runComposeUiTest {
        val page2Info = "Learn Android Development"
        
        setContent {
            PageCarousel(
                pageCount = 2,
                onFinish = {},
                imageContent = { Text("Image $it") },
                infoContent = { index ->
                    Text(if (index == 0) "Page 1" else page2Info)
                }
            )
        }

        onNodeWithText("Page 1").assertIsDisplayed()
        
        onNodeWithTag(PAGE_CAROUSEL_NEXT_BUTTON_TAG).performClick()

        waitForIdle()

        onNodeWithText(page2Info).assertIsDisplayed()
        onNodeWithText("Image 1").assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnFinishWhenClickingButtonOnLastPage() = runComposeUiTest {
        var finished = false
        
        setContent {
            PageCarousel(
                pageCount = 1,
                onFinish = { finished = true },
                imageContent = { Text("Image $it") },
                infoContent = { Text("Last Page") }
            )
        }

        onNodeWithTag(PAGE_CAROUSEL_NEXT_BUTTON_TAG).performClick()

        assertTrue(finished)
    }
}
