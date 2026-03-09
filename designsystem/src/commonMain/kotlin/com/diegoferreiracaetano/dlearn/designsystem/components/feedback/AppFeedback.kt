package com.diegoferreiracaetano.dlearn.designsystem.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppTopBar
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_close
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.placeholder
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val FeedbackImageSize = 160.dp

/**
 * A generic feedback component used as a base for error states, empty states, and success messages.
 * This version accepts [StringResource] for title and description.
 *
 * @param title The main title of the feedback.
 * @param description A detailed description of the state.
 * @param imageSource The illustrative image for the feedback.
 * @param modifier The [Modifier] to be applied to the root layout.
 * @param primaryText Text for the primary action button.
 * @param onPrimary Callback for the primary action button.
 * @param secondaryText Text for the secondary action button.
 * @param onSecondary Callback for the secondary action button.
 * @param onClose Callback for the close icon in the toolbar.
 */
@Composable
fun AppFeedback(
    title: StringResource,
    description: StringResource,
    imageSource: AppImageSource?,
    modifier: Modifier = Modifier,
    primaryText: StringResource? = null,
    onPrimary: (() -> Unit)? = null,
    secondaryText: StringResource? = null,
    onSecondary: (() -> Unit)? = null,
    onClose: (() -> Unit)? = null,
) {
    AppFeedback(
        title = stringResource(title),
        description = stringResource(description),
        imageSource = imageSource,
        modifier = modifier,
        primaryText = primaryText?.let { stringResource(it) },
        onPrimary = onPrimary,
        secondaryText = secondaryText?.let { stringResource(it) },
        onSecondary = onSecondary,
        onClose = onClose
    )
}

/**
 * A generic feedback component used as a base for error states, empty states, and success messages.
 * This version accepts raw [String] for title and description.
 *
 * @param title The main title of the feedback.
 * @param description A detailed description of the state.
 * @param imageSource The illustrative image for the feedback.
 * @param modifier The [Modifier] to be applied to the root layout.
 * @param primaryText Text for the primary action button.
 * @param onPrimary Callback for the primary action button.
 * @param secondaryText Text for the secondary action button.
 * @param onSecondary Callback for the secondary action button.
 * @param onClose Callback for the close icon in the toolbar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppFeedback(
    title: String,
    description: String,
    imageSource: AppImageSource?,
    modifier: Modifier = Modifier,
    primaryText: String? = null,
    onPrimary: (() -> Unit)? = null,
    secondaryText: String? = null,
    onSecondary: (() -> Unit)? = null,
    onClose: (() -> Unit)? = null,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            AppTopBar(
                actions = {
                    if (onClose != null) {
                        IconButton(onClick = onClose) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = stringResource(Res.string.action_close)
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            if (onPrimary != null || onSecondary != null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if (onPrimary != null && primaryText != null) {
                        AppButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = primaryText,
                            type = ButtonType.PRIMARY,
                            onClick = onPrimary
                        )
                    }
                    if (onSecondary != null && secondaryText != null) {
                        AppButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = secondaryText,
                            type = ButtonType.SECONDARY,
                            onClick = onSecondary
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (imageSource != null) {
                AppImage(
                    modifier = Modifier.size(FeedbackImageSize),
                    source = imageSource,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(24.dp))
            }

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun AppFeedbackPreview() {
    DLearnTheme {
        AppFeedback(
            title = "Feedback Title",
            description = "This is a detailed description of the feedback state.",
            imageSource = AppImageSource.Resource(Res.drawable.placeholder),
            primaryText = "Primary Action",
            onPrimary = {},
            secondaryText = "Secondary Action",
            onSecondary = {},
            onClose = {}
        )
    }
}
