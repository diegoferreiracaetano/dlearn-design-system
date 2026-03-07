package com.diegoferreiracaetano.dlearn.designsystem.components.textfield

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppOtpVerificationTest {

    @Test
    fun shouldDisplayOtpPromptWhenRendered() = runComposeUiTest {
        setContent {
            DLearnTheme {
                AppOtpVerification(
                    otpText = "",
                    onOtpTextChange = { _, _ -> },
                    onResendClick = {}
                )
            }
        }

        // Using substring = true because of trailing space in strings.xml "Não recebeu o código? "
        onNodeWithText("Não recebeu o código?", substring = true, ignoreCase = true).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayErrorTextWhenIsErrorIsTrue() = runComposeUiTest {
        val errorText = "Invalid code"
        setContent {
            DLearnTheme {
                AppOtpVerification(
                    otpText = "123",
                    isError = true,
                    errorText = errorText,
                    onOtpTextChange = { _, _ -> },
                    onResendClick = {}
                )
            }
        }

        onNodeWithText(errorText).assertIsDisplayed()
    }
}
