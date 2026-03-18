package com.diegoferreiracaetano.dlearn.designsystem.components.error

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_close
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_retry
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class AppErrorTest {

    @Test
    fun shouldDisplayGenericErrorContentAndHandleClicks() = runComposeUiTest {
        var primaryClicked = false
        var secondaryClicked = false

        setContent {
            AppError(
                throwable = Throwable("Unknown Error"),
                primaryText = Res.string.action_retry,
                secondaryText = Res.string.action_close,
                onPrimary = { primaryClicked = true },
                onSecondary = { secondaryClicked = true }
            )
        }
        
        // Assert texts from GenericError (Actual strings from strings.xml)
        onNodeWithText("Erro Inesperado").assertIsDisplayed()
        onNodeWithText("Ocorreu um erro inesperado. Por favor, tente novamente.").assertIsDisplayed()
        
        // Primary button ("Tentar novamente")
        onNodeWithText("Tentar novamente", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        // Secondary button ("Fechar")
        onNodeWithText("Fechar", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")
    }

    @Test
    fun shouldDisplayGenericErrorFullScreenAndHandleAllClicks() = runComposeUiTest {
        var primaryClicked = false
        var secondaryClicked = false
        var closeClicked = false

        setContent {
            AppError(
                fullScreen = true,
                throwable = Throwable("Unknown Error"),
                primaryText = Res.string.action_retry,
                secondaryText = Res.string.action_close,
                onPrimary = { primaryClicked = true },
                onSecondary = { secondaryClicked = true },
                onClose = { closeClicked = true }
            )
        }
        
        // Assert texts from GenericError
        onNodeWithText("Erro Inesperado").assertIsDisplayed()
        onNodeWithText("Ocorreu um erro inesperado. Por favor, tente novamente.").assertIsDisplayed()
        
        // Primary button
        onNodeWithText("Tentar novamente", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        // Secondary button
        onNodeWithText("Fechar", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")

        // Close button (TopBar)
        onNodeWithContentDescription("Fechar", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(closeClicked, "Close button was not clicked")
    }
}
