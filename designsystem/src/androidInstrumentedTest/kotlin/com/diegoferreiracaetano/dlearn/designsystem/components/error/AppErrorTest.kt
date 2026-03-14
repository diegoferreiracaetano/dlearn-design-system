package com.diegoferreiracaetano.dlearn.designsystem.components.error

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppErrorTest {

    @Test
    fun shouldDisplayGenericErrorContentAndHandleClicks() = runComposeUiTest {
        var primaryClicked = false
        var secondaryClicked = false

        setContent {
            AppErrorContent(
                throwable = Throwable("Unknown Error"),
                primaryText = "Retry",
                secondaryText = "Cancel",
                onPrimary = { primaryClicked = true },
                onSecondary = { secondaryClicked = true }
            )
        }
        
        // Assert texts from GenericError
        onNodeWithText("Erro Inesperado").assertIsDisplayed()
        onNodeWithText("Ocorreu um erro inesperado. Por favor, tente novamente.").assertIsDisplayed()
        
        // Primary button
        onNodeWithText("Retry").assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        // Secondary button
        onNodeWithText("Cancel").assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")
    }

    @Test
    fun shouldDisplayGenericErrorAndHandleAllClicks() = runComposeUiTest {
        var primaryClicked = false
        var secondaryClicked = false
        var closeClicked = false

        setContent {
            AppError(
                throwable = Throwable("Unknown Error"),
                primaryText = "Retry Action",
                secondaryText = "Cancel Action",
                onPrimary = { primaryClicked = true },
                onSecondary = { secondaryClicked = true },
                onClose = { closeClicked = true }
            )
        }
        
        // Assert texts from GenericError
        onNodeWithText("Erro Inesperado").assertIsDisplayed()
        onNodeWithText("Ocorreu um erro inesperado. Por favor, tente novamente.").assertIsDisplayed()
        
        // Primary button
        onNodeWithText("Retry Action").assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        // Secondary button
        onNodeWithText("Cancel Action").assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")

        // Close button (TopBar)
        onNodeWithContentDescription("Fechar").assertIsDisplayed().performClick()
        assertTrue(closeClicked, "Close button was not clicked")
    }
}
