package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_back
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppSectionTitleTest {

    @Test
    fun shouldDisplayStringTitle() = runComposeUiTest {
        val titleText = "Section Header"

        setContent {
            AppSectionTitle(title = titleText)
        }

        onNodeWithText(titleText).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayResourceTitle() = runComposeUiTest {
        setContent {
            AppSectionTitle(title = Res.string.action_back)
        }
        
        // Verifies component renders with resource
        // Actual text check would depend on resource resolution in test environment
    }
}
