package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
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

        setContent {
            AppDialog(
                onDismissRequest = {},
                confirmButtonText = "Confirm",
                onConfirmClick = { confirmed = true }
            )
        }

        onNodeWithTag(AppDialogTags.CONFIRM_BUTTON).assertIsDisplayed().performClick()

        assertTrue(confirmed, "The onConfirmClick callback should have been triggered")
    }

    @Test
    fun shouldTriggerDismissClick() = runComposeUiTest {
        var dismissed = false

        setContent {
            AppDialog(
                onDismissRequest = {},
                confirmButtonText = "Confirm",
                onConfirmClick = {},
                dismissButtonText = "Dismiss",
                onDismissClick = { dismissed = true }
            )
        }

        onNodeWithTag(AppDialogTags.DISMISS_BUTTON).assertIsDisplayed().performClick()

        assertTrue(dismissed, "The onDismissClick callback should have been triggered")
    }

    @Test
    fun shouldDisplayBothButtonsWhenDismissProvided() = runComposeUiTest {
        setContent {
            AppDialog(
                onDismissRequest = {},
                confirmButtonText = "Confirm",
                onConfirmClick = {},
                dismissButtonText = "Dismiss",
                onDismissClick = {}
            )
        }

        onNodeWithTag(AppDialogTags.CONFIRM_BUTTON).assertIsDisplayed()
        onNodeWithTag(AppDialogTags.DISMISS_BUTTON).assertIsDisplayed()
    }

    @Test
    fun shouldRespectCustomTestTags() = runComposeUiTest {
        val customConfirmTag = "my_dialog_confirm"
        val customDismissTag = "my_dialog_dismiss"

        setContent {
            AppDialog(
                onDismissRequest = {},
                confirmButtonText = "Confirm",
                onConfirmClick = {},
                dismissButtonText = "Dismiss",
                onDismissClick = {},
                confirmTestTag = customConfirmTag,
                dismissTestTag = customDismissTag,
            )
        }

        onNodeWithTag(customConfirmTag).assertIsDisplayed()
        onNodeWithTag(customDismissTag).assertIsDisplayed()
    }
}
