package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.question
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val DialogPadding = 24.dp
private val DialogImageSize = 120.dp
private val DialogSpacing = 16.dp
private val DialogButtonSpacing = 12.dp

/**
 * A custom alert dialog component following the Material 3 specifications and project styling.
 *
 * @param onDismissRequest Callback when the dialog is dismissed.
 * @param confirmButtonText The text for the confirmation button.
 * @param onConfirmClick Callback for the confirmation button.
 * @param modifier The [Modifier] to be applied to the dialog.
 * @param dismissButtonText Optional text for the dismiss button.
 * @param onDismissClick Optional callback for the dismiss button.
 * @param title Optional title for the dialog.
 * @param description Optional description for the dialog.
 * @param imageResource Optional [DrawableResource] to be displayed at the top.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDialog(
    onDismissRequest: () -> Unit,
    confirmButtonText: String,
    onConfirmClick: () -> Unit,
    modifier: Modifier = Modifier,
    dismissButtonText: String? = null,
    onDismissClick: (() -> Unit)? = null,
    title: String? = null,
    description: String? = null,
    imageResource: DrawableResource? = null,
) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(DialogPadding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                imageResource?.let {
                    AppImage(
                        imageResource = it,
                        modifier = Modifier.size(DialogImageSize),
                        contentDescription = title
                    )
                    Spacer(modifier = Modifier.height(DialogSpacing))
                }

                title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(DialogSpacing))
                }

                description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(DialogSpacing))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(DialogButtonSpacing)
                ) {
                    if (dismissButtonText != null && onDismissClick != null) {
                        AppButton(
                            modifier = Modifier.weight(1f),
                            text = dismissButtonText,
                            onClick = onDismissClick,
                            type = ButtonType.SECONDARY
                        )
                    }
                    AppButton(
                        modifier = Modifier.weight(1f),
                        text = confirmButtonText,
                        onClick = onConfirmClick,
                        type = ButtonType.PRIMARY
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AppDialogPreview() {
    DLearnTheme(
        darkTheme = true
    ) {
        AppDialog(
            onDismissRequest = {},
            title = "Are you sure ?",
            description = "Ullamcorper imperdiet urna id non sed est sem. Rhoncus amet, enim purus gravida donec aliquet.",
            confirmButtonText = "Cancel",
            onConfirmClick = {},
            dismissButtonText = "Log Out",
            onDismissClick = {},
            imageResource = Res.drawable.question
        )
    }
}
