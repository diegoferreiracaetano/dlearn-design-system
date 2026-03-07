package com.diegoferreiracaetano.dlearn.designsystem.components.button

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppButtonTest {

    @Test
    fun shouldDisplayCorrectTextWhenRendered() = runComposeUiTest {
        val text = "Click me"

        setContent {
            AppButton(
                text = text,
                onClick = {}
            )
        }

        onNodeWithText(text).assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnClickWhenButtonIsClicked() = runComposeUiTest {
        var clicked = false
        val text = "Click me"

        setContent {
            AppButton(
                text = text,
                onClick = { clicked = true }
            )
        }

        onNodeWithText(text).performClick()

        assertTrue(clicked, "The onClick callback should have been triggered")
    }

    @Test
    fun shouldBeDisabledWhenEnabledPropertyIsFalse() = runComposeUiTest {
        val text = "Disabled"

        setContent {
            AppButton(
                text = text,
                onClick = {},
                enabled = false
            )
        }

        onNodeWithText(text).assertIsNotEnabled()
    }
}
