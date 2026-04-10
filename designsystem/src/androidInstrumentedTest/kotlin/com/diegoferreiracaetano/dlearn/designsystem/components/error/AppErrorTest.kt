package com.diegoferreiracaetano.dlearn.designsystem.components.error

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
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
                errorData = GenericError(),
                primaryText = Res.string.action_retry,
                secondaryText = Res.string.action_close,
                onPrimary = { primaryClicked = true },
                onSecondary = { secondaryClicked = true }
            )
        }

        onNodeWithText("Erro Inesperado").assertIsDisplayed()
        onNodeWithText("Ocorreu um erro inesperado. Por favor, tente novamente.").assertIsDisplayed()

        onNodeWithText("Tentar novamente", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

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
                errorData = GenericError(),
                fullScreen = true,
                primaryText = Res.string.action_retry,
                secondaryText = Res.string.action_close,
                onPrimary = { primaryClicked = true },
                onSecondary = { secondaryClicked = true },
                onClose = { closeClicked = true }
            )
        }

        onNodeWithText("Erro Inesperado").assertIsDisplayed()
        onNodeWithText("Ocorreu um erro inesperado. Por favor, tente novamente.").assertIsDisplayed()

        onNodeWithText("Tentar novamente", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(primaryClicked, "Primary button was not clicked")

        onNodeWithText("Fechar", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(secondaryClicked, "Secondary button was not clicked")

        onNodeWithContentDescription("Fechar", ignoreCase = true).assertIsDisplayed().performClick()
        assertTrue(closeClicked, "Close button was not clicked")
    }
}
