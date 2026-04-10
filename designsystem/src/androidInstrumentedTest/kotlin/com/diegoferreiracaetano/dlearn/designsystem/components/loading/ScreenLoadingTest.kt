package com.diegoferreiracaetano.dlearn.designsystem.components.loading

import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasProgressBarRangeInfo
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class ScreenLoadingTest {

    @Test
    fun shouldDisplayAppLoadingWhenRendered() = runComposeUiTest {
        // ScreenLoading was removed/renamed to AppLoading in this refactor
        setContent {
            AppLoading()
        }

        onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate)).assertIsDisplayed()
    }
}
