package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.DesignSystemRes

@Composable
fun ButtonsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Section(title = "Primary Buttons") {
            AppButton(text = "Primary Button", onClick = {})
            AppButton(text = "With Icon", onClick = {}, imageSource = DesignSystemRes.google.toAppImageSource())
            AppButton(text = "Disabled", onClick = {}, enabled = false)
        }

        Section(title = "Secondary Buttons") {
            AppButton(text = "Secondary Button", onClick = {}, type = ButtonType.SECONDARY)
            AppButton(
                text = "With Icon",
                onClick = {},
                type = ButtonType.SECONDARY,
                imageSource = DesignSystemRes.google.toAppImageSource(),
                iconTint = Color.Unspecified
            )
            AppButton(text = "Disabled", onClick = {}, type = ButtonType.SECONDARY, enabled = false)
        }

        Section(title = "Tertiary Buttons") {
            AppButton(text = "Tertiary Button", onClick = {}, type = ButtonType.TERTIARY)
            AppButton(text = "Disabled", onClick = {}, type = ButtonType.TERTIARY, enabled = false)
        }

        Section(title = "Custom Background") {
            AppButton(text = "Custom Color", onClick = {}, backgroundColor = Color(0xFF4CAF50))
        }
    }
}

@Composable
private fun Section(title: String, content: @Composable () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(text = title, style = MaterialTheme.typography.titleMedium)
        content()
    }
}
