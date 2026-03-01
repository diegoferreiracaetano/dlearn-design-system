package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class PageIndicatorTest {

    @Test
    fun shouldDisplayPageIndicatorWhenRendered() = runComposeUiTest {
        val testTag = "PageIndicator"
        setContent {
            PageIndicator(
                totalPages = 3,
                currentPage = 0,
                modifier = Modifier.testTag(testTag)
            )
        }

        onNodeWithTag(testTag).assertIsDisplayed()
    }
}
