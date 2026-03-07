package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.unit.dp
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class AppCarouselTest {

    @Test
    fun appCarousel_withTitle_displaysTitle() = runComposeUiTest {
        val title = "Carousel Title"
        setContent {
            AppCarousel(
                itemCount = 1,
                title = title,
            ) {
                Box(Modifier.size(100.dp))
            }
        }

        onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun appCarousel_withItems_displaysItems() = runComposeUiTest {
        setContent {
            AppCarousel(
                itemCount = 3,
                isPager = false,
            ) { index ->
                Box(
                    Modifier
                        .size(50.dp)
                        .testTag("item_$index"),
                )
            }
        }

        // Use assertExists for items in horizontal lists to avoid visibility issues in tests
        onNodeWithTag("item_0").assertExists()
        onNodeWithTag("item_1").assertExists()
        onNodeWithTag("item_2").assertExists()
    }
}
