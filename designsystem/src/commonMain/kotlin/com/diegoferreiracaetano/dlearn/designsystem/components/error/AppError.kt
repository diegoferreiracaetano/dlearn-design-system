package com.diegoferreiracaetano.dlearn.designsystem.components.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diegoferreiracaetano.dlearn.designsystem.components.error.factory.AppErrorFactory
import com.diegoferreiracaetano.dlearn.designsystem.components.feedback.AppFeedback
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_close
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_retry
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.util.rememberNetworkManager
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A comprehensive UI component for displaying error states within the application.
 * 
 * This component uses [AppFeedback] as its base and automatically adapts its content 
 * based on the provided [throwable] and current network connectivity using [AppErrorFactory].
 *
 * @param throwable The [Throwable] caught during an operation to determine the error type.
 * @param modifier The [Modifier] to be applied to the root layout.
 * @param primaryText Optional text for the primary action button. Defaults to "Tentar Novamente".
 * @param onPrimary Optional callback invoked when the primary action button is clicked.
 * @param secondaryText Optional text for the secondary action button. Defaults to "Fechar".
 * @param onSecondary Optional callback invoked when the secondary action button is clicked.
 * @param onClose Optional callback invoked when the close icon in the toolbar is clicked.
 */
@Composable
fun AppError(
    throwable: Throwable? = null,
    modifier: Modifier = Modifier,
    primaryText: String? = null,
    onPrimary: (() -> Unit)? = null,
    secondaryText: String? = null,
    onSecondary: (() -> Unit)? = null,
    onClose: (() -> Unit)? = null,
) {
    val networkManager = rememberNetworkManager()
    val errorData = AppErrorFactory(
        throwable = throwable,
        isNetworkAvailable = networkManager.isNetworkAvailable()
    )

    AppFeedback(
        modifier = modifier,
        title = errorData.title,
        description = errorData.description,
        imageSource = errorData.imageSource,
        primaryText = primaryText ?: stringResource(Res.string.action_retry),
        onPrimary = onPrimary,
        secondaryText = secondaryText ?: stringResource(Res.string.action_close),
        onSecondary = onSecondary,
        onClose = onClose
    )
}

@Preview
@Composable
fun AppErrorPreview() {
    DLearnTheme(darkTheme = true) {
        AppError(
            onPrimary = {},
            onSecondary = {},
            onClose = {}
        )
    }
}
