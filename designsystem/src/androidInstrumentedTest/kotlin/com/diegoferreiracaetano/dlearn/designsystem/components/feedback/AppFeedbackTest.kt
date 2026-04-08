package com.diegoferreiracaetano.dlearn.designsystem.components.feedback

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppFeedbackTest {

    @Test
    fun shouldDisplayFullScreenFeedbackAndHandleAllClicks() = runComposeUiTest {
        val title = "Feedback Title"
        val description = "Feedback Description"
        val primaryText = "Primary Action"
        val secondaryText = "Secondary Action"

        var primaryClicked = false
        var secondaryClicked = false
        var closeClicked = false

        setContent {
            AppFeedback(
                fullScreen = true,
                title = title,
                description = description,
                imageSource = null,
                primaryText = primaryText,
                onPrimary = { primaryClicked = true },
                secondaryText = secondaryText,
                onSecondary = { secondaryClicked = true },
                onClose = { closeClicked = true }
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(description).assertIsDisplayed()

        onNodeWithTag(AppFeedbackTags.PRIMARY_BUTTON).assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        onNodeWithTag(AppFeedbackTags.SECONDARY_BUTTON).assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")

        onNodeWithContentDescription("Fechar").assertIsDisplayed().performClick()
        assertTrue(closeClicked, "Close button was not clicked")
    }

    @Test
    fun shouldDisplayContentOnlyFeedbackAndHandleClicks() = runComposeUiTest {
        val title = "Content Title"
        val description = "Content Description"
        val primaryText = "Primary Action"
        val secondaryText = "Secondary Action"

        var primaryClicked = false
        var secondaryClicked = false

        setContent {
            AppFeedback(
                fullScreen = false,
                title = title,
                description = description,
                imageSource = null,
                primaryText = primaryText,
                onPrimary = { primaryClicked = true },
                secondaryText = secondaryText,
                onSecondary = { secondaryClicked = true }
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(description).assertIsDisplayed()

        onNodeWithTag(AppFeedbackTags.PRIMARY_BUTTON).assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        onNodeWithTag(AppFeedbackTags.SECONDARY_BUTTON).assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")
    }

    @Test
    fun shouldNotShowButtonsWhenCallbacksAreNull() = runComposeUiTest {
        setContent {
            AppFeedback(
                title = "Title",
                description = "Description",
                imageSource = null
            )
        }

        onNodeWithTag(AppFeedbackTags.PRIMARY_BUTTON).assertDoesNotExist()
        onNodeWithTag(AppFeedbackTags.SECONDARY_BUTTON).assertDoesNotExist()
    }

    @Test
    fun shouldRespectCustomTestTags() = runComposeUiTest {
        val customPrimaryTag = "my_screen_primary_btn"
        val customSecondaryTag = "my_screen_secondary_btn"

        setContent {
            AppFeedback(
                title = "Title",
                description = "Description",
                imageSource = null,
                primaryText = "Primary",
                onPrimary = {},
                secondaryText = "Secondary",
                onSecondary = {},
                primaryTestTag = customPrimaryTag,
                secondaryTestTag = customSecondaryTag,
            )
        }

        onNodeWithTag(customPrimaryTag).assertIsDisplayed()
        onNodeWithTag(customSecondaryTag).assertIsDisplayed()
    }
}
