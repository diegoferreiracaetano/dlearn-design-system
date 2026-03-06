package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppDialogTest {

    @Test
    fun shouldDisplayTitleAndDescription() = runComposeUiTest {
        val title = "Test Title"
        val description = "Test Description"

        setContent {
            AppDialog(
                onDismissRequest = {},
                title = title,
                description = description,
                confirmButtonText = "Confirm",
                onConfirmClick = {}
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(description).assertIsDisplayed()
    }

    @Test
    fun shouldTriggerConfirmClick() = runComposeUiTest {
        var confirmed = false
        val confirmText = "Confirm"

        setContent {
            AppDialog(
                onDismissRequest = {},
                confirmButtonText = confirmText,
                onConfirmClick = { confirmed = true }
            )
        }

        onNodeWithText(confirmText).performClick()

        assertTrue(confirmed, "The onConfirmClick callback should have been triggered")
    }

    @Test
    fun shouldTriggerDismissClick() = runComposeUiTest {
        var dismissed = false
        val dismissText = "Dismiss"

        setContent {
            AppDialog(
                onDismissRequest = {},
                confirmButtonText = "Confirm",
                onConfirmClick = {},
                dismissButtonText = dismissText,
                onDismissClick = { dismissed = true }
            )
        }

        onNodeWithText(dismissText).performClick()

        assertTrue(dismissed, "The onDismissClick callback should have been triggered")
    }
}
