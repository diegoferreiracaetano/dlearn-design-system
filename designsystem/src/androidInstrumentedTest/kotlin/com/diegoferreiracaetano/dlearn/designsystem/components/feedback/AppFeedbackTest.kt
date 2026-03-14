package com.diegoferreiracaetano.dlearn.designsystem.components.feedback

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppFeedbackTest {

    @Test
    fun shouldDisplayAllElementsAndHandleClicks() = runComposeUiTest {
        val title = "Feedback Title"
        val description = "Feedback Description"
        val primaryText = "Primary Action"
        val secondaryText = "Secondary Action"
        
        var primaryClicked = false
        var secondaryClicked = false
        var closeClicked = false

        setContent {
            AppFeedback(
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

        // Verify title and description
        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(description).assertIsDisplayed()

        // Verify and click primary button
        onNodeWithText(primaryText).assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        // Verify and click secondary button
        onNodeWithText(secondaryText).assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")

        // Verify and click close button (close icon has string resource action_close)
        // action_close translates to "Fechar" natively. Let's try finding the icon by its text if it has one or rely on the contentDescription.
        onNodeWithContentDescription("Fechar").assertIsDisplayed().performClick()
        assertTrue(closeClicked, "Close button was not clicked")
    }

    @Test
    fun shouldDisplayAllElementsAndHandleClicksInContent() = runComposeUiTest {
        val title = "Content Title"
        val description = "Content Description"
        val primaryText = "Primary Action"
        val secondaryText = "Secondary Action"
        
        var primaryClicked = false
        var secondaryClicked = false

        setContent {
            AppFeedbackContent(
                title = title,
                description = description,
                imageSource = null,
                primaryText = primaryText,
                onPrimary = { primaryClicked = true },
                secondaryText = secondaryText,
                onSecondary = { secondaryClicked = true }
            )
        }

        // Verify title and description
        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(description).assertIsDisplayed()

        // Verify and click primary button
        onNodeWithText(primaryText).assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        // Verify and click secondary button
        onNodeWithText(secondaryText).assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")
    }
}
