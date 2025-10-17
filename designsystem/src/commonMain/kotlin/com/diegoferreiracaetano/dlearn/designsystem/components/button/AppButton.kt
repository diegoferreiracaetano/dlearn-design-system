package com.diegoferreiracaetano.dlearn.designsystem.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.google
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.theme.Shapes
import com.github.guilhe.kmp.composeuiviewcontroller.ComposeUIViewController
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ButtonHeight = 56.dp
private val ButtonIconSize = 28.dp
private val ButtonContentSpacing = 16.dp
private val ButtonBorderWidth = 1.dp
private val PreviewPadding = 16.dp
private val PreviewSpacing = 12.dp

enum class ButtonType {
    PRIMARY,
    SECONDARY,
    TERTIARY,
}

@ComposeUIViewController
@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    type: ButtonType = ButtonType.PRIMARY,
    image: DrawableResource? = null,
    enabled: Boolean = true,
) {
    val (colors, border) = when (type) {
        ButtonType.PRIMARY -> getPrimaryButtonColors() to null
        ButtonType.SECONDARY -> getSecondaryButtonColors() to BorderStroke(
            ButtonBorderWidth,
            MaterialTheme.colorScheme.onSurface
        )

        ButtonType.TERTIARY -> getTertiaryButtonColors() to BorderStroke(
            ButtonBorderWidth,
            MaterialTheme.colorScheme.surface
        )
    }

    AppButtonInternal(
        modifier = modifier,
        text = text,
        onClick = onClick,
        image = image,
        enabled = enabled,
        colors = colors,
        border = border
    )
}

@Composable
private fun AppButtonInternal(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    image: DrawableResource?,
    enabled: Boolean,
    colors: ButtonColors,
    border: BorderStroke?,
) {
    val buttonModifier = modifier
        .fillMaxWidth()
        .height(ButtonHeight)

    if (border != null) {
        OutlinedButton(
            onClick = onClick,
            shape = Shapes.extraLarge,
            enabled = enabled,
            border = border,
            colors = colors,
            modifier = buttonModifier,
        ) {
            AppButtonContent(text, image)
        }
    } else {
        Button(
            onClick = onClick,
            shape = Shapes.extraLarge,
            enabled = enabled,
            colors = colors,
            modifier = buttonModifier,
        ) {
            AppButtonContent(text, image)
        }
    }
}

@Composable
private fun AppButtonContent(
    text: String,
    image: DrawableResource?,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (image != null) {
            Image(
                painter = painterResource(image),
                contentDescription = text,
                modifier = Modifier.size(ButtonIconSize),
            )
            Spacer(modifier = Modifier.width(ButtonContentSpacing))
        }
        Text(
            text = text,
            style = typography.labelLarge,
        )
    }
}

@Composable
private fun getPrimaryButtonColors() = ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.primary,
    contentColor = MaterialTheme.colorScheme.onPrimary,
    disabledContentColor = Color.LightGray,
    disabledContainerColor = Color.Gray,
)

@Composable
private fun getSecondaryButtonColors() = ButtonDefaults.outlinedButtonColors(
    containerColor = MaterialTheme.colorScheme.surface,
    contentColor = MaterialTheme.colorScheme.onSurface,
    disabledContentColor = Color.LightGray,
    disabledContainerColor = Color.Gray,
)

@Composable
private fun getTertiaryButtonColors() = ButtonDefaults.outlinedButtonColors(
    containerColor = MaterialTheme.colorScheme.onSurface,
    contentColor = MaterialTheme.colorScheme.surface,
    disabledContentColor = Color.LightGray,
    disabledContainerColor = Color.Gray,
)

@Preview
@Composable
fun AppButtonPrimaryPreview() {
    DLearnTheme {
        Column(
            modifier = Modifier.padding(PreviewPadding),
            verticalArrangement = Arrangement.spacedBy(PreviewSpacing),
        ) {
            AppButton(
                text = "Primary",
                onClick = {},
            )
            AppButton(
                text = "Primary disable",
                onClick = {},
                enabled = false,
            )
            AppButton(
                text = "Secondary",
                onClick = {},
                type = ButtonType.SECONDARY,
            )
            AppButton(
                text = "Secondary disable",
                onClick = {},
                enabled = false,
                type = ButtonType.SECONDARY,
            )
            AppButton(
                text = "Tertiary",
                onClick = {},
                type = ButtonType.TERTIARY,
                image = Res.drawable.google,
            )
        }
    }
}
