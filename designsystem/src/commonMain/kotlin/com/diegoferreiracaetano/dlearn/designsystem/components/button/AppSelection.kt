package com.diegoferreiracaetano.dlearn.designsystem.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.selection_option_a_z
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.selection_option_highest_number
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.selection_option_lowest_number
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.selection_option_z_a
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.util.contrastTextColor
import com.github.guilhe.kmp.composeuiviewcontroller.ComposeUIViewController
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val DropdownItemPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
private val NoPadding = 0.dp
private val PreviewPadding = 16.dp
private val PreviewSpacing = 16.dp

data class AppSelectionOption(
    val label: String,
    val value: Any,
    val color: Color,
)

@ComposeUIViewController
@Composable
fun AppSelectionSimple(
    modifier: Modifier = Modifier,
    list: List<String>,
    onSelectionChanged: (AppSelectionOption) -> Unit,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    val options = remember(list, color) {
        list.map { AppSelectionOption(it, it, color) }
    }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options.first()) }

    AppSelection(
        modifier = modifier,
        expanded = expanded,
        selectedOption = selectedOption,
        options = options,
        onExpandedChange = { expanded = it },
        onOptionSelected = {
            selectedOption = it
            onSelectionChanged(it)
        }
    )
}

@ComposeUIViewController
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSelection(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    selectedOption: AppSelectionOption,
    options: List<AppSelectionOption>,
    onExpandedChange: (Boolean) -> Unit,
    onOptionSelected: (AppSelectionOption) -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = onExpandedChange,
        modifier = modifier
            .clip(MaterialTheme.shapes.extraLarge)
            .background(MaterialTheme.colorScheme.background)
    ) {
        TextField(
            onValueChange = {},
            value = selectedOption.label,
            readOnly = true,
            maxLines = 1,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                focusedTextColor = selectedOption.color.contrastTextColor(),
                unfocusedTextColor = selectedOption.color.contrastTextColor(),
                disabledTextColor = selectedOption.color.contrastTextColor(),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedTrailingIconColor = selectedOption.color.contrastTextColor(),
                unfocusedTrailingIconColor = selectedOption.color.contrastTextColor(),
                disabledTrailingIconColor = selectedOption.color.contrastTextColor(),
                focusedContainerColor = selectedOption.color,
                unfocusedContainerColor = selectedOption.color,
                disabledContainerColor = selectedOption.color
            ),
            textStyle = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.SemiBold,
                color = selectedOption.color.contrastTextColor()
            ),
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryEditable)
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    modifier = Modifier
                        .background(option.color)
                        .padding(DropdownItemPadding),
                    text = {
                        Text(
                            text = option.label,
                            style = MaterialTheme.typography.labelMedium,
                        )
                    },
                    onClick = {
                        onOptionSelected(option)
                        onExpandedChange(false)
                    },
                    colors = MenuDefaults.itemColors(
                        textColor = option.color.contrastTextColor(),
                        leadingIconColor = option.color.contrastTextColor(),
                        trailingIconColor = option.color.contrastTextColor(),
                    ),
                    contentPadding = PaddingValues(NoPadding)
                )
            }
        }
    }
}

@Preview
@Composable
fun AppSelectionDropdownPreview() {
    DLearnTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(PreviewSpacing),
            modifier = Modifier
                .padding(PreviewPadding)
                .fillMaxWidth()
        ) {
            AppSelectionSimple(
                list = listOf(
                    stringResource(Res.string.selection_option_lowest_number),
                    stringResource(Res.string.selection_option_highest_number)
                ),
                onSelectionChanged = { /* No-op for preview */ }
            )

            AppSelectionSimple(
                list = listOf(
                    stringResource(Res.string.selection_option_a_z),
                    stringResource(Res.string.selection_option_z_a)
                ),
                onSelectionChanged = { /* No-op for preview */ }
            )
        }
    }
}
