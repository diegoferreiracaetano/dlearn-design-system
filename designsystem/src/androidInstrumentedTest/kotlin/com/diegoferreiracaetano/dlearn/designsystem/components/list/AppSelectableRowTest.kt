package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppSelectableRowTest {

    @Test
    fun shouldDisplayLabel() = runComposeUiTest {
        val labelText = "English (UK)"

        setContent {
            AppSelectableRow(
                label = labelText,
                isSelected = false,
                onClick = {}
            )
        }

        onNodeWithText(labelText).assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnClick() = runComposeUiTest {
        var clicked = false
        val labelText = "Selectable Item"

        setContent {
            AppSelectableRow(
                label = labelText,
                isSelected = false,
                onClick = { clicked = true }
            )
        }

        onNodeWithText(labelText).performClick()
        assert(clicked)
    }

    // Note: To test the icon appearance, we typically use content description
    // or tag. Since we didn't add a specific tag or description to the Check Icon,
    // we focus on label presence and clickability for now.
}
