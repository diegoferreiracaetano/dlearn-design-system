package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val RowPaddingVertical = 16.dp
private val RowPaddingHorizontal = 16.dp
private val CheckIconSize = 24.dp

/**
 * A row component designed for selection lists (like Language or Country selection).
 * It shows a label and displays a checkmark only when [isSelected] is true.
 *
 * @param label The [StringResource] for the label text.
 * @param isSelected Whether this row is currently selected.
 * @param onClick Callback when the row is clicked.
 * @param modifier The [Modifier] to be applied to the row.
 */
@Composable
fun AppSelectableRow(
    label: StringResource,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AppSelectableRow(
        label = stringResource(label),
        isSelected = isSelected,
        onClick = onClick,
        modifier = modifier
    )
}

/**
 * A row component designed for selection lists (like Language or Country selection).
 * This version accepts a raw [String].
 *
 * @param label The string for the label text.
 * @param isSelected Whether this row is currently selected.
 * @param onClick Callback when the row is clicked.
 * @param modifier The [Modifier] to be applied to the row.
 */
@Composable
fun AppSelectableRow(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = RowPaddingVertical, horizontal = RowPaddingHorizontal)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium,
            color = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f)
        )

        if (isSelected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                modifier = Modifier.size(CheckIconSize),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
private fun AppSelectableRowPreview() {
    DLearnTheme(darkTheme = true) {
        androidx.compose.foundation.layout.Column {
            AppSelectableRow(
                label = "English (UK)",
                isSelected = true,
                onClick = {}
            )
            AppSelectableRow(
                label = "English",
                isSelected = false,
                onClick = {}
            )
        }
    }
}
