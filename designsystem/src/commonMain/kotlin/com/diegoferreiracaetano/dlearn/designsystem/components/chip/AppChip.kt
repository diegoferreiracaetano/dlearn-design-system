package com.diegoferreiracaetano.dlearn.designsystem.components.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
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

data class AppChip(
    val label: String,
    val onClick: () -> Unit = {},
    val hasDropDown: Boolean = false,
    val isFilter: Boolean = true
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppChipGroup(
    modifier: Modifier = Modifier,
    items: List<AppChip>,
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
            horizontalArrangement = Arrangement.spacedBy(CHIP_SPACING)
        ) {
            items(visibleChips) { chip ->
                val isSelected = chip.label == selectedFilterLabel
                FilterChip(
                    shape = Shapes.extraLarge,
                    selected = isSelected,
                    onClick = {
                        if (chip.isFilter) {
                            val newFilter = if (isSelected) null else chip.label
                            selectedFilterLabel = newFilter
                            onFilterChanged(newFilter)
                        }
                        chip.onClick()
                    },
                    label = { Text(chip.label) },
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
                    trailingIcon = if (chip.hasDropDown) {
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
                AppChip(
                    label = stringResource(Res.string.chip_label_series)
                ),
                AppChip(
                    label = stringResource(Res.string.chip_label_movies)
                ),
                AppChip(
                    label = stringResource(Res.string.chip_label_categories),
                    hasDropDown = true,
                    isFilter = false
                )
            ),
            onFilterChanged = {}
        )
    }
}
