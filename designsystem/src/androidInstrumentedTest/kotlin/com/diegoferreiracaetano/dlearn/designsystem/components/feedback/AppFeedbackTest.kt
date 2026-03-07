package com.diegoferreiracaetano.dlearn.designsystem.components.feedback

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppFeedbackTest {

    @Test
    fun shouldDisplayTitleAndDescription() = runComposeUiTest {
        val title = "Feedback Title"
        val description = "Feedback Description"

        setContent {
            AppFeedback(
                title = title,
                description = description,
                imageSource = null
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(description).assertIsDisplayed()
    }

    @Test
    fun shouldCallOnPrimaryWhenClicked() = runComposeUiTest {
        var clicked = false
        val primaryText = "Primary Action"

        setContent {
            AppFeedback(
                title = "Title",
                description = "Description",
                imageSource = null,
                primaryText = primaryText,
                onPrimary = { clicked = true }
            )
        }

        onNodeWithText(primaryText).performClick()
        assertTrue(clicked)
    }

    @Test
    fun shouldCallOnSecondaryWhenClicked() = runComposeUiTest {
        var clicked = false
        val secondaryText = "Secondary Action"

        setContent {
            AppFeedback(
                title = "Title",
                description = "Description",
                imageSource = null,
                secondaryText = secondaryText,
                onSecondary = { clicked = true }
            )
        }

        onNodeWithText(secondaryText).performClick()
        assertTrue(clicked)
    }
}
