package com.diegoferreiracaetano.dlearn.designsystem.components.button

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class AppSelectionTest {

    @Test
    fun shouldDisplaySelectedOptionLabelWhenRendered() = runComposeUiTest {
        val options = listOf(
            AppSelectionOption("Option 1", 1, Color.Red),
            AppSelectionOption("Option 2", 2, Color.Blue)
        )
        setContent {
            AppSelection(
                expanded = false,
                selectedOption = options[0],
                options = options,
                onExpandedChange = {},
                onOptionSelected = {}
            )
        }

        onNodeWithText("Option 1").assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnOptionSelectedWhenAnOptionIsClicked() = runComposeUiTest {
        val options = listOf(
            AppSelectionOption("Option 1", 1, Color.Red),
            AppSelectionOption("Option 2", 2, Color.Blue)
        )
        var selected: AppSelectionOption? = null
        
        setContent {
            AppSelection(
                expanded = true, // Force expanded to show options
                selectedOption = options[0],
                options = options,
                onExpandedChange = {},
                onOptionSelected = { selected = it }
            )
        }

        onNodeWithText("Option 2").performClick()

        assertEquals(options[1], selected)
    }
}
