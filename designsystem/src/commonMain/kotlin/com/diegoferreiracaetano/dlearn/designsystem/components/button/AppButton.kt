package com.diegoferreiracaetano.dlearn.designsystem.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toPainter
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.google
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.theme.Shapes
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ButtonHeight = 56.dp
private val ButtonIconSize = 20.dp
private val ButtonContentSpacing = 4.dp
private val ButtonBorderWidth = 1.dp
private val PreviewPadding = 16.dp
private val PreviewSpacing = 12.dp

/**
 * Types of buttons available in the design system.
 */
enum class ButtonType {
    PRIMARY,
    SECONDARY,
    TERTIARY,
}

/**
 * A custom button component that supports different styles (Primary, Secondary, Tertiary)
 * and an optional leading image.
 *
 * @param text The localized text for the button.
 * @param onClick Callback triggered when the button is clicked.
 * @param modifier Modifier for the button container.
 * @param type The visual style of the button ([ButtonType.PRIMARY], [ButtonType.SECONDARY], [ButtonType.TERTIARY]).
 * @param imageSource Optional leading icon for the button.
 * @param iconTint Optional tint for the leading icon.
 * @param enabled Whether the button is interactive.
 * @param backgroundColor Optional background color override.
 * @param testTag Tag for UI testing.
 */
@Composable
fun AppButton(
    text: StringResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.PRIMARY,
    imageSource: AppImageSource? = null,
    iconTint: Color? = null,
    enabled: Boolean = true,
    backgroundColor: Color? = null,
    testTag: String? = null,
) {
    AppButton(
        text = stringResource(text),
        onClick = onClick,
        modifier = modifier,
        type = type,
        imageSource = imageSource,
        iconTint = iconTint,
        enabled = enabled,
        backgroundColor = backgroundColor,
        testTag = testTag,
    )
}

/**
 * A custom button component that supports different styles (Primary, Secondary, Tertiary)
 * and an optional leading image.
 *
 * @param modifier Modifier for the button container.
 * @param text The raw string for the button text.
 * @param onClick Callback triggered when the button is clicked.
 * @param type The visual style of the button ([ButtonType.PRIMARY], [ButtonType.SECONDARY], [ButtonType.TERTIARY]).
 * @param imageSource Optional leading icon for the button.
 * @param iconTint Optional tint for the leading icon.
 * @param enabled Whether the button is interactive.
 * @param backgroundColor Optional background color override.
 * @param testTag Tag for UI testing.
 */
@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: () -> Unit,
    type: ButtonType = ButtonType.PRIMARY,
    imageSource: AppImageSource? = null,
    iconTint: Color? = null,
    enabled: Boolean = true,
    backgroundColor: Color? = null,
    testTag: String? = null,
) {
    val defaultContainerColor = when (type) {
        ButtonType.PRIMARY -> MaterialTheme.colorScheme.primary
        ButtonType.SECONDARY -> MaterialTheme.colorScheme.surface
        ButtonType.TERTIARY -> MaterialTheme.colorScheme.onSurface
    }

    val defaultContentColor = when (type) {
        ButtonType.PRIMARY -> MaterialTheme.colorScheme.onPrimary
        ButtonType.SECONDARY -> MaterialTheme.colorScheme.onSurfaceVariant
        ButtonType.TERTIARY -> MaterialTheme.colorScheme.surface
    }

    val finalBackgroundColor = backgroundColor ?: defaultContainerColor

    val border = when (type) {
        ButtonType.PRIMARY -> null
        ButtonType.SECONDARY -> BorderStroke(
            ButtonBorderWidth,
            defaultContentColor
        )
        ButtonType.TERTIARY -> BorderStroke(
            ButtonBorderWidth,
            finalBackgroundColor
        )
    }

    val finalColors = ButtonDefaults.buttonColors(
        containerColor = finalBackgroundColor,
        contentColor = defaultContentColor,
        disabledContainerColor = Color.Gray,
        disabledContentColor = Color.LightGray
    )

    AppButtonInternal(
        modifier = if (testTag != null) modifier.testTag(testTag) else modifier,
        text = text,
        onClick = onClick,
        imageSource = imageSource,
        iconTint = iconTint,
        enabled = enabled,
        colors = finalColors,
        border = border,
    )
}

@Composable
private fun AppButtonInternal(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: () -> Unit,
    imageSource: AppImageSource?,
    iconTint: Color?,
    enabled: Boolean,
    colors: ButtonColors,
    border: BorderStroke?,
) {
    val isIconOnly = text.isNullOrEmpty()
    
    val buttonModifier = if (isIconOnly) {
        modifier.size(ButtonHeight)
    } else {
        modifier.defaultMinSize(minHeight = ButtonHeight)
    }

    val contentPadding = if (isIconOnly) {
        PaddingValues(0.dp)
    } else {
        PaddingValues(horizontal = 8.dp, vertical = 0.dp)
    }

    if (border != null) {
        OutlinedButton(
            onClick = onClick,
            shape = if (isIconOnly) CircleShape else Shapes.extraLarge,
            enabled = enabled,
            border = border,
            colors = colors,
            modifier = buttonModifier,
            contentPadding = contentPadding
        ) {
            AppButtonContent(text, imageSource, iconTint)
        }
    } else {
        Button(
            onClick = onClick,
            shape = if (isIconOnly) CircleShape else Shapes.extraLarge,
            enabled = enabled,
            colors = colors,
            modifier = buttonModifier,
            contentPadding = contentPadding
        ) {
            AppButtonContent(text, imageSource, iconTint)
        }
    }
}

@Composable
private fun RowScope.AppButtonContent(
    text: String? = null,
    imageSource: AppImageSource?,
    iconTint: Color?,
) {
    if (imageSource != null) {
        Icon(
            painter = imageSource.toPainter(),
            contentDescription = text,
            modifier = Modifier.size(ButtonIconSize),
            tint = iconTint ?: LocalContentColor.current
        )
        if (!text.isNullOrEmpty()) {
            Spacer(modifier = Modifier.width(ButtonContentSpacing))
        }
    }
    if (!text.isNullOrEmpty()) {
        Text(
            text = text,
            style = typography.labelMedium,
            color = LocalContentColor.current,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun AppButtonPrimaryPreview() {
    DLearnTheme {
        Column(
            modifier = Modifier.padding(PreviewPadding),
            verticalArrangement = Arrangement.spacedBy(PreviewSpacing),
        ) {
            AppButton(
                text = "Apple Style (Follows Theme)",
                onClick = {},
                imageSource = Res.drawable.google.toAppImageSource(),
            )
            AppButton(
                text = "Google Style (Original Colors)",
                onClick = {},
                imageSource = Res.drawable.google.toAppImageSource(),
                iconTint = Color.Unspecified
            )
            AppButton(
                modifier = Modifier.size(64.dp),
                onClick = {},
                type = ButtonType.SECONDARY,
                imageSource = Res.drawable.google.toAppImageSource(),
                iconTint = Color.Unspecified
            )
            AppButton(
                text = "Custom Background Only",
                onClick = {},
                backgroundColor = Color.Red
            )
            AppButton(
                text = "Secondary Custom BG",
                onClick = {},
                type = ButtonType.SECONDARY,
                backgroundColor = Color.Yellow
            )
            AppButton(
                text = "Primary Disable",
                onClick = {},
                enabled = false,
            )
        }
    }
}
