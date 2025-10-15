package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@Composable
fun CodeSnippet(code: String) {
    val clipboardManager = LocalClipboardManager.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
    ) {
        Text(
            text = code,
            style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily.Monospace)
        )
        IconButton(
            onClick = {
                clipboardManager.setText(AnnotatedString(code))
            },
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(Icons.Default.ContentCopy, contentDescription = "Copy code")
        }
    }
}
