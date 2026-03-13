package com.diegoferreiracaetano.dlearn.designsystem.components.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.chip_action_clear_selection
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.chip_description_dropdown
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.chip_label_categories
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.chip_label_movies
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.chip_label_series
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.theme.Shapes
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val CHIP_GROUP_PADDING_VERTICAL = 8.dp
private val CHIP_GROUP_PADDING_HORIZONTAL = 16.dp
private val CHIP_SPACING = 8.dp
private const val CHIP_BORDER_ALPHA = 0.5f

/**
 * Data class representing a chip item in an [AppChipGroup].
 *
 * @property label The text to be displayed on the chip.
 * @property onClick Action to be performed when the chip is clicked.
 * @property hasDropDown Whether the chip should display a dropdown icon.
 * @property isFilter Whether the chip acts as a filter that can be selected.
 * @property isSelected Whether the chip is currently selected.
 * @property dropDownOptions List of options to show in the dropdown menu.
 * @property onOptionSelected Callback invoked when a dropdown option is selected.
 */
data class AppChipItem(
    val label: String,
    val onClick: () -> Unit = {},
    val hasDropDown: Boolean = false,
    val isFilter: Boolean = true,
    val isSelected: Boolean = false,
    val dropDownOptions: List<String>? = null,
    val onOptionSelected: (String) -> Unit = {}
)

/**
 * A specialized chip component for the Design System.
 *
 * @param modifier The [Modifier] to be applied to the chip.
 * @param label The text to be displayed.
 * @param isSelected Whether the chip is selected.
 * @param hasDropDown Whether to show a dropdown icon.
 * @param dropDownOptions List of options to show in the dropdown menu.
 * @param onOptionSelected Callback invoked when a dropdown option is selected.
 * @param onClick Callback when the chip is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppChip(
    modifier: Modifier = Modifier,
    label: String,
    isSelected: Boolean = false,
    hasDropDown: Boolean = false,
    dropDownOptions: List<String>? = null,
    onOptionSelected: (String) -> Unit = {},
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var itemWidth by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    Box(
        modifier = modifier.onGloballyPositioned { coordinates ->
            itemWidth = with(density) { coordinates.size.width.toDp() }
        }
    ) {
        FilterChip(
            selected = isSelected,
            onClick = {
                if (hasDropDown && !dropDownOptions.isNullOrEmpty()) {
                    expanded = true
                }
                onClick()
            },
            shape = Shapes.extraLarge,
            label = { Text(label) },
            colors = FilterChipDefaults.filterChipColors(
                containerColor = Color.Transparent,
                selectedContainerColor = MaterialTheme.colorScheme.onSurface,
                labelColor = MaterialTheme.colorScheme.onSurface,
                selectedLabelColor = MaterialTheme.colorScheme.surface,
                iconColor = MaterialTheme.colorScheme.onSurface,
                selectedTrailingIconColor = MaterialTheme.colorScheme.surface
            ),
            border = FilterChipDefaults.filterChipBorder(
                borderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = CHIP_BORDER_ALPHA),
                selectedBorderColor = Color.Transparent,
                enabled = true,
                selected = isSelected
            ),
            trailingIcon = if (hasDropDown) {
                {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = stringResource(Res.string.chip_description_dropdown)
                    )
                }
            } else {
                null
            }
        )

        if (hasDropDown && !dropDownOptions.isNullOrEmpty()) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(itemWidth)
            ) {
                dropDownOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

/**
 * A group of chips that can be used for filtering or selection.
 *
 * @param modifier The [Modifier] to be applied to the chip group.
 * @param items The list of [AppChipItem] items to be displayed.
 * @param onFilterChanged Callback invoked when the selected filter changes.
 */
@Composable
fun AppChipGroup(
    modifier: Modifier = Modifier,
    items: List<AppChipItem>,
    onFilterChanged: (String?) -> Unit
) {
    var selectedFilterLabel by remember { mutableStateOf<String?>(null) }

    val visibleChips = if (selectedFilterLabel == null) {
        items
    } else {
        items.filter { it.label == selectedFilterLabel || !it.isFilter }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = CHIP_GROUP_PADDING_VERTICAL, horizontal = CHIP_GROUP_PADDING_HORIZONTAL),
        horizontalArrangement = Arrangement.spacedBy(CHIP_SPACING),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (selectedFilterLabel != null) {
            IconButton(onClick = {
                selectedFilterLabel = null
                onFilterChanged(null)
            }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(Res.string.chip_action_clear_selection),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        LazyRow(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(CHIP_SPACING)
        ) {
            items(visibleChips) { chip ->
                val isSelected = chip.label == selectedFilterLabel || chip.isSelected
                AppChip(
                    label = chip.label,
                    isSelected = isSelected,
                    hasDropDown = chip.hasDropDown,
                    dropDownOptions = chip.dropDownOptions,
                    onOptionSelected = chip.onOptionSelected,
                    onClick = {
                        if (chip.isFilter) {
                            val newFilter = if (isSelected) null else chip.label
                            selectedFilterLabel = newFilter
                            onFilterChanged(newFilter)
                        }
                        chip.onClick()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun AppChipGroupPreview() {
    DLearnTheme(darkTheme = true) {
        AppChipGroup(
            items = listOf(
                AppChipItem(
                    label = stringResource(Res.string.chip_label_series)
                ),
                AppChipItem(
                    label = stringResource(Res.string.chip_label_movies)
                ),
                AppChipItem(
                    label = stringResource(Res.string.chip_label_categories),
                    hasDropDown = true,
                    isFilter = true,
                    dropDownOptions = listOf("Terror", "Comédia", "Drama"),
                    onOptionSelected = {}
                )
            ),
            onFilterChanged = {}
        )
    }
}
