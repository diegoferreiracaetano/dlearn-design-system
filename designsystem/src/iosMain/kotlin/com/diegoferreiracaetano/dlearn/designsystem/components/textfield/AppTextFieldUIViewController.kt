package com.diegoferreiracaetano.dlearn.designsystem.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

@Composable
private fun AppTextFieldWrapper(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    label: String? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    type: TextFieldType = TextFieldType.NONE,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }
    val visualTransformation = if (type == TextFieldType.PASSWORD && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None

    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = label?.let { { Text(it) } },
            placeholder = { Text(placeholder) },
            isError = isError,
            visualTransformation = visualTransformation,
            trailingIcon = {
                if (type == TextFieldType.PASSWORD) {
                    val icon = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = icon, contentDescription = "Toggle password visibility")
                    }
                }
            },
            singleLine = true,
            shape = MaterialTheme.shapes.extraLarge,
            modifier = Modifier.fillMaxWidth()
        )
        if (supportingText != null) {
            Text(
                text = supportingText,
                color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp, start = 16.dp)
            )
        }
    }
}

object AppTextFieldUIViewController {
    operator fun invoke(
        value: String,
        onValueChange: (String) -> Unit,
        placeholder: String,
        label: String? = null,
        supportingText: String? = null,
        isError: Boolean = false,
        type: TextFieldType = TextFieldType.NONE,
        modifier: Modifier = Modifier
    ): UIViewController {
        return ComposeUIViewController {
            AppTextFieldWrapper(value, onValueChange, placeholder, label, supportingText, isError, type, modifier)
        }
    }
}
