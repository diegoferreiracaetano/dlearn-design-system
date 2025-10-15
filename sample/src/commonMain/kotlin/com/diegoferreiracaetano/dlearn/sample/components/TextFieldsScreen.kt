package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.textfield.AppOtpVerification
import com.diegoferreiracaetano.dlearn.designsystem.components.textfield.AppTextField
import com.diegoferreiracaetano.dlearn.designsystem.components.textfield.TextFieldType
import dlearn.sample.generated.resources.Res
import dlearn.sample.generated.resources.email_message_validation
import dlearn.sample.generated.resources.password_message_validation
import dlearn.sample.generated.resources.title_email
import dlearn.sample.generated.resources.title_password

@Composable
fun TextFieldsScreen() {
    var textFieldValue by remember { mutableStateOf("") }
    var otpValue by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ComponentScaffold(
                title = "AppTextField",
                description = "A text field for email and password.",
                codeSnippet = "AppTextField(value = \"\", onValueChange = { }, type = TextFieldType.EMAIL)"
            ) {
                AppTextField(
                    value = textFieldValue,
                    label = Res.string.title_email,
                    onValueChange = { textFieldValue = it },
                    placeholder = Res.string.title_email,
                    isError = textFieldValue.contains("cm"),
                    type = TextFieldType.EMAIL,
                    supportingText = Res.string.email_message_validation,
                )
                AppTextField(
                    value = textFieldValue,
                    onValueChange = { textFieldValue = it },
                    placeholder = Res.string.title_password,
                    isError = textFieldValue.length < 6,
                    type = TextFieldType.PASSWORD,
                    supportingText = Res.string.password_message_validation,
                )
            }
        }
        item {
            ComponentScaffold(
                title = "AppOtpVerification",
                description = "A component for OTP verification.",
                codeSnippet = "AppOtpVerification(otpText = \"\", onOtpTextChange = { _, _ -> })"
            ) {
                AppOtpVerification(
                    otpText = otpValue,
                    onOtpTextChange = { text, _ -> otpValue = text },
                    onResendClick = {}
                )
            }
        }
    }
}
