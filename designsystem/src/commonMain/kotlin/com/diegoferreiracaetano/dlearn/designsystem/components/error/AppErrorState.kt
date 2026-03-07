package com.diegoferreiracaetano.dlearn.designsystem.components.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.diegoferreiracaetano.dlearn.designsystem.components.error.factory.AppErrorFactory
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppTopBar
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_close
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_retry
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.util.rememberNetworkManager
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ErrorStateImageSize = 160.dp

/**
 * A comprehensive UI component for displaying error states within the application.
 * 
 * This component automatically adapts its content (title, description, image) based on the
 * provided [statusCode] and current network connectivity using [AppErrorFactory].
 * 
 * Features:
 * - Top toolbar with an optional close action.
 * - Central illustration and localized text.
 * - Bottom action bar with "Retry" and "Close" buttons.
 *
 * @param statusCode The HTTP status code to determine the specific error type (e.g., 404, 500).
 *                   If null, it defaults to a generic error unless the network is down.
 * @param modifier The [Modifier] to be applied to the root layout.
 * @param onRetry Optional callback invoked when the "Retry" button is clicked. 
 *                The button is only visible if this callback is provided.
 * @param onClose Optional callback invoked when the close icon in the toolbar or the 
 *                "Close" button at the bottom is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppErrorState(
    statusCode: Int? = null,
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null,
    onClose: (() -> Unit)? = null,
) {
    val networkManager = rememberNetworkManager()
    val error = AppErrorFactory(
        statusCode = statusCode,
        isNetworkAvailable = networkManager.isNetworkAvailable()
    )

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
            if (onClose != null || onRetry != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if (onClose != null) {
                        AppButton(
                            modifier = Modifier.weight(1f),
                            text = stringResource(Res.string.action_close),
                            type = ButtonType.SECONDARY,
                            onClick = onClose
                        )
                    }
                    if (onRetry != null) {
                        AppButton(
                            modifier = Modifier.weight(1f),
                            text = stringResource(Res.string.action_retry),
                            type = ButtonType.PRIMARY,
                            onClick = onRetry
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
            AppImage(
                modifier = Modifier.size(ErrorStateImageSize),
                source = error.imageSource,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = error.title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = error.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun AppErrorStatePreview() {
    DLearnTheme(darkTheme = true) {
        AppErrorState(
            onRetry = {},
            onClose = {}
        )
    }
}

@Preview
@Composable
fun AppErrorStateNoNetworkPreview() {
    DLearnTheme(darkTheme = true) {
        AppErrorState(
            onRetry = {}
        )
    }
}
