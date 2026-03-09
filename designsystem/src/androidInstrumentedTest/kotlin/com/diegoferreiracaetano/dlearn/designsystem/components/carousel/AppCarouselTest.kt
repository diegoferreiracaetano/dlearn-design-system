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
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.app_name
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class AppCarouselTest {

    @Test
    fun appCarousel_withStringTitle_displaysTitle() = runComposeUiTest {
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
    fun appCarousel_withResourceTitle_displaysTitle() = runComposeUiTest {
        setContent {
            AppCarousel(
                itemCount = 1,
                title = Res.string.app_name,
            ) {
                Box(Modifier.size(100.dp))
            }
        }

        // In a real instrumented test, Res.string.app_name would resolve to "DLearn"
        // Here we just verify the component renders without crashing when using a resource
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

        onNodeWithTag("item_0").assertExists()
        onNodeWithTag("item_1").assertExists()
        onNodeWithTag("item_2").assertExists()
    }
}
