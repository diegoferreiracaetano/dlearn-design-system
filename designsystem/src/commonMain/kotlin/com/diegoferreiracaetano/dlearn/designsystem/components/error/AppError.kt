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
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.StringResource

/**
 * A comprehensive UI component for displaying error states within the application.
 * 
 * This component uses [AppFeedback] as its base and automatically adapts its content 
 * based on the provided [throwable] and current network connectivity using [AppErrorFactory].
 *
 * @param throwable The [Throwable] caught during an operation to determine the error type.
 * @param modifier The [Modifier] to be applied to the root layout.
 * @param fullScreen If true, displays the error within a Scaffold and TopBar. Defaults to false.
 * @param primaryText Optional text for the primary action button. Defaults to "Tentar Novamente".
 * @param onPrimary Optional callback invoked when the primary action button is clicked.
 * @param secondaryText Optional text for the secondary action button. Defaults to "Fechar".
 * @param onSecondary Optional callback invoked when the secondary action button is clicked.
 * @param onClose Optional callback invoked when the close icon in the toolbar is clicked (only if fullScreen is true).
 */
@Composable
fun AppError(
    throwable: Throwable? = null,
    modifier: Modifier = Modifier,
    fullScreen: Boolean = false,
    primaryText: StringResource? = null,
    onPrimary: (() -> Unit)? = null,
    secondaryText: StringResource? = null,
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
        fullScreen = fullScreen,
        primaryText = primaryText ?: Res.string.action_retry,
        onPrimary = onPrimary,
        secondaryText = secondaryText ?: Res.string.action_close,
        onSecondary = onSecondary,
        onClose = onClose
    )
}

@Preview
@Composable
fun AppErrorPreview() {
    DLearnTheme(darkTheme = true) {
        AppError(
            fullScreen = true,
            onPrimary = {},
            onSecondary = {},
            onClose = {}
        )
    }
}

@Preview
@Composable
fun AppErrorContentPreview() {
    DLearnTheme(darkTheme = true) {
        AppError(
            onPrimary = {},
            onSecondary = {}
        )
    }
}
