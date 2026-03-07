package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.icons.AppIcons
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppShareDialogTest {

    @Test
    fun shouldDisplayTitleAndCustomOptions() = runComposeUiTest {
        val title = "Custom Share"
        val options = listOf(
            ShareOption(
                id = "custom_id",
                imageVector = AppIcons.Facebook,
                contentDescription = "Custom Description"
            )
        )

        setContent {
            AppShareDialog(
                onDismissRequest = {},
                options = options,
                onOptionClick = {},
                title = title
            )
        }

        onNodeWithText(title).assertExists()
        onNodeWithContentDescription("Custom Description").assertExists()
    }

    @Test
    fun shouldTriggerOnOptionClickInGenericDialog() = runComposeUiTest {
        var clickedOption: ShareOption? = null
        val options = listOf(
            ShareOption(
                id = "test_id",
                imageVector = AppIcons.Facebook,
                contentDescription = "Test Option"
            )
        )

        setContent {
            AppShareDialog(
                onDismissRequest = {},
                options = options,
                onOptionClick = { clickedOption = it }
            )
        }

        onNodeWithContentDescription("Test Option").performClick()
        assertEquals("test_id", clickedOption?.id)
    }

    @Test
    fun shouldDisplaySocialOptionsInSocialDialog() = runComposeUiTest {
        setContent {
            AppSocialShareDialog(
                onDismissRequest = {},
                shareText = "https://test.com"
            )
        }

        onNodeWithText(AppShareDialogDefaults.DefaultTitle).assertExists()
        onNodeWithContentDescription("Facebook").assertExists()
        onNodeWithContentDescription("Instagram").assertExists()
        onNodeWithContentDescription("Messenger").assertExists()
        onNodeWithContentDescription("Telegram").assertExists()
    }

    @Test
    fun shouldTriggerOnDismissRequest() = runComposeUiTest {
        var dismissCalled = false

        setContent {
            AppShareDialog(
                onDismissRequest = { dismissCalled = true },
                options = emptyList(),
                onOptionClick = {}
            )
        }

        onNodeWithContentDescription(AppShareDialogDefaults.CloseContentDescription).performClick()
        assertTrue(dismissCalled)
    }
}
