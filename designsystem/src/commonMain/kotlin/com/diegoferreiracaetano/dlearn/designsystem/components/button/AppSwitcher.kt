package com.diegoferreiracaetano.dlearn.designsystem.components.button // Use o seu pacote correto

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private val PreviewPadding = 16.dp
private val PreviewSpacing = 16.dp

@Composable
fun AppSwitcher(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
) {
    val customSwitchColors = SwitchDefaults.colors(
        checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
        checkedTrackColor = MaterialTheme.colorScheme.primary,
        uncheckedThumbColor = MaterialTheme.colorScheme.outlineVariant,
        uncheckedTrackColor = MaterialTheme.colorScheme.outline
    )

    Switch(
        modifier = modifier,
        checked = isChecked,
        enabled = enabled,
        onCheckedChange = onCheckedChange,
        colors = customSwitchColors
    )
}

@Preview(showBackground = true)
@Composable
fun AppSwitchesPreview() {
    DLearnTheme {
        Column(
            Modifier.padding(PreviewPadding),
            verticalArrangement = Arrangement.spacedBy(PreviewSpacing)
        ) {
            var isChecked1 by remember { mutableStateOf(true) }
            var isChecked2 by remember { mutableStateOf(false) }
            val isChecked3 by remember { mutableStateOf(true) } // For disabled state

            AppSwitcher(
                isChecked = isChecked1,
                onCheckedChange = { isChecked1 = it }
            )
            AppSwitcher(
                isChecked = isChecked2,
                onCheckedChange = { isChecked2 = it }
            )
            AppSwitcher(
                isChecked = isChecked3,
                onCheckedChange = {},
                enabled = false
            )
        }
    }
}
