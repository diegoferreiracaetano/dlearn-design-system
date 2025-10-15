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
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppSelectionSimple
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppSwitcher
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType

@Composable
fun ButtonsScreen() {
    var switchChecked by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ComponentScaffold(
                title = "AppButton",
                description = "A simple button with primary, secondary and tertiary styles.",
                codeSnippet = "AppButton(text = \"Primary\", onClick = {}, type = ButtonType.PRIMARY)"
            ) {
                AppButton(text = "Primary", onClick = {})
                AppButton(text = "Secondary", onClick = {}, type = ButtonType.SECONDARY)
                AppButton(text = "Tertiary", onClick = {}, type = ButtonType.TERTIARY)
            }
        }
        item {
            ComponentScaffold(
                title = "AppSwitcher",
                description = "A simple switcher.",
                codeSnippet = "AppSwitcher(isChecked = true, onCheckedChange = { })"
            ) {
                AppSwitcher(isChecked = switchChecked, onCheckedChange = { switchChecked = it })
            }
        }
        item {
            ComponentScaffold(
                title = "AppSelectionSimple",
                description = "A simple selection component.",
                codeSnippet = "AppSelectionSimple(list = listOf(\"Option 1\", \"Option 2\"), selected = { _, _ -> })"
            ) {
                AppSelectionSimple(list = listOf("Option 1", "Option 2", "Option 3"), onSelectionChanged = {})
            }
        }
    }
}
