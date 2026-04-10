package com.diegoferreiracaetano.dlearn.designsystem.components.loading

import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasProgressBarRangeInfo
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppLoadingTest {

    @Test
    fun shouldDisplayLoadingWhenRendered() = runComposeUiTest {
        setContent {
            DLearnTheme {
                AppLoading()
            }
        }

        onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate)).assertIsDisplayed()
    }
}
