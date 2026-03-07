package com.diegoferreiracaetano.dlearn.designsystem.components.textfield

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.title_email
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.email_message_validation
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class AppTextFieldTest {

    private val textFieldTag = "AppTextField"

    @Test
    fun shouldDisplayLabelAndPlaceholderWhenProvided() = runComposeUiTest {
        setContent {
            DLearnTheme {
                AppTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = Res.string.title_email,
                    label = Res.string.title_email,
                    modifier = Modifier.testTag(textFieldTag)
                )
            }
        }

        onNodeWithTag(textFieldTag).assertIsDisplayed()
        onNodeWithText("E-mail", ignoreCase = true).assertIsDisplayed()
    }

    @Test
    fun shouldUpdateValueWhenTextIsEntered() = runComposeUiTest {
        var capturedValue by mutableStateOf("")
        setContent {
            DLearnTheme {
                AppTextField(
                    value = capturedValue,
                    onValueChange = { capturedValue = it },
                    placeholder = Res.string.title_email,
                    modifier = Modifier.testTag(textFieldTag)
                )
            }
        }

        val inputText = "test@example.com"
        onNodeWithTag("OutlinedTextField").performTextInput(inputText)

        assertEquals(inputText, capturedValue)
    }

    @Test
    fun shouldDisplaySupportingTextWhenProvided() = runComposeUiTest {
        setContent {
            DLearnTheme {
                AppTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = Res.string.title_email,
                    supportingText = Res.string.email_message_validation
                )
            }
        }

        // The string for email_message_validation in strings.xml is "Informe um e-mail válido."
        onNodeWithText("Informe um e-mail válido.", ignoreCase = true).assertIsDisplayed()
    }
}
