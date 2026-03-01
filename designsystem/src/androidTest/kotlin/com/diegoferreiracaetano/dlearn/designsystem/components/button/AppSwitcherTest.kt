package com.diegoferreiracaetano.dlearn.designsystem.components.button

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppSwitcherTest {

    @Test
    fun shouldBeOnWhenIsCheckedPropertyIsTrue() = runComposeUiTest {
        val testTag = "AppSwitcher"
        setContent {
            AppSwitcher(
                modifier = Modifier.testTag(testTag),
                isChecked = true,
                onCheckedChange = {}
            )
        }

        onNodeWithTag(testTag).assertIsOn()
    }

    @Test
    fun shouldBeOffWhenIsCheckedPropertyIsFalse() = runComposeUiTest {
        val testTag = "AppSwitcher"
        setContent {
            AppSwitcher(
                modifier = Modifier.testTag(testTag),
                isChecked = false,
                onCheckedChange = {}
            )
        }

        onNodeWithTag(testTag).assertIsOff()
    }

    @Test
    fun shouldTriggerOnCheckedChangeWhenClicked() = runComposeUiTest {
        val testTag = "AppSwitcher"
        var capturedValue = false
        setContent {
            AppSwitcher(
                modifier = Modifier.testTag(testTag),
                isChecked = false,
                onCheckedChange = { capturedValue = it }
            )
        }

        onNodeWithTag(testTag).performClick()

        assertTrue(capturedValue, "The onCheckedChange callback should have been triggered with true")
    }

    @Test
    fun shouldBeDisabledWhenEnabledPropertyIsFalse() = runComposeUiTest {
        val testTag = "AppSwitcher"
        setContent {
            AppSwitcher(
                modifier = Modifier.testTag(testTag),
                isChecked = true,
                onCheckedChange = {},
                enabled = false
            )
        }

        onNodeWithTag(testTag).assertIsNotEnabled()
    }
}
