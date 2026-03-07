package com.diegoferreiracaetano.dlearn.designsystem.components.loading

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppLoadingTest {

    @Test
    fun shouldDisplayLoadingWhenRendered() = runComposeUiTest {
        val testTag = "AppLoading"
        setContent {
            AppLoading(modifier = Modifier.testTag(testTag))
        }

        onNodeWithTag(testTag).assertIsDisplayed()
    }
}
