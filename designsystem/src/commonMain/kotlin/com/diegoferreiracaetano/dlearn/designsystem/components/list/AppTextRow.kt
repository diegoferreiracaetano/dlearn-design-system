package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppSwitcher
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_back
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val RowPaddingVertical = 12.dp
private val ContentSpacing = 16.dp
private val IconBoxSize = 40.dp
private val LeadingIconSize = 20.dp
private const val ICON_BACKGROUND_ALPHA = 0.3f

/**
 * A row component that displays a label and a value, optionally with a leading icon,
 * a switcher, or an arrow icon.
 *
 * @param label The [StringResource] for the label text.
 * @param value The [StringResource] for the value text.
 * @param modifier The [Modifier] to be applied to the row.
 * @param leadingIcon Optional [ImageVector] to be displayed on the left.
 * @param isEnabled Whether the switcher (if present) is checked.
 * @param onClick Callback when the row is clicked.
 * @param onCheckedChange Callback when the switcher state changes. If provided, a switcher is shown.
 */
@Composable
fun AppTextRow(
    label: StringResource,
    value: StringResource,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    isEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {
    AppTextRow(
        label = stringResource(label),
        value = stringResource(value),
        modifier = modifier,
        leadingIcon = leadingIcon,
        isEnabled = isEnabled,
        onClick = onClick,
        onCheckedChange = onCheckedChange,
    )
}

/**
 * A row component that displays a label and a string value, optionally with a leading icon,
 * a switcher, or an arrow icon.
 *
 * @param label The [StringResource] for the label text.
 * @param modifier The [Modifier] to be applied to the row.
 * @param value Optional string value text.
 * @param leadingIcon Optional [ImageVector] to be displayed on the left.
 * @param isEnabled Whether the switcher (if present) is checked.
 * @param onClick Callback when the row is clicked.
 * @param onCheckedChange Callback when the switcher state changes. If provided, a switcher is shown.
 */
@Composable
fun AppTextRow(
    label: StringResource,
    modifier: Modifier = Modifier,
    value: String? = null,
    leadingIcon: ImageVector? = null,
    isEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {
    AppTextRow(
        label = stringResource(label),
        value = value,
        modifier = modifier,
        leadingIcon = leadingIcon,
        isEnabled = isEnabled,
        onClick = onClick,
        onCheckedChange = onCheckedChange,
    )
}

/**
 * A row component that displays a label and a string value, optionally with a leading icon,
 * a switcher, or an arrow icon.
 *
 * @param label The string for the label text.
 * @param modifier The [Modifier] to be applied to the row.
 * @param value Optional string value text.
 * @param leadingIcon Optional [ImageVector] to be displayed on the left.
 * @param isEnabled Whether the switcher (if present) is checked.
 * @param onClick Callback when the row is clicked.
 * @param onCheckedChange Callback when the switcher state changes. If provided, a switcher is shown.
 */
@Composable
fun AppTextRow(
    label: String,
    modifier: Modifier = Modifier,
    value: String? = null,
    leadingIcon: ImageVector? = null,
    isEnabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(vertical = RowPaddingVertical)
    ) {
        leadingIcon?.let { icon ->
            Box(
                modifier = Modifier
                    .size(IconBoxSize)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = ICON_BACKGROUND_ALPHA),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(LeadingIconSize),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.width(ContentSpacing))
        }

        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (!value.isNullOrEmpty()) {
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        when {
            onCheckedChange != null -> {
                AppSwitcher(
                    modifier = Modifier.padding(start = ContentSpacing),
                    isChecked = isEnabled,
                    onCheckedChange = onCheckedChange
                )
            }
            onClick != null -> {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = stringResource(Res.string.action_back),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview
@Composable
private fun AppTextRowPreview() {
    DLearnTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            AppTextRow(
                label = "Label from backend",
                value = "Example value",
                onClick = {}
            )
            AppTextRow(
                label = Res.string.action_back,
                onCheckedChange = {},
                isEnabled = true
            )
        }
    }
}
