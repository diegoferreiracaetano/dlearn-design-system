package com.diegoferreiracaetano.dlearn.designsystem.components.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AppErrorData
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AuthError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError
import com.diegoferreiracaetano.dlearn.designsystem.components.feedback.AppFeedback
import com.diegoferreiracaetano.dlearn.designsystem.components.feedback.AppFeedbackTags
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_close
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_retry
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A comprehensive UI component for displaying error states within the application.
 *
 * This component uses [AppFeedback] as its base and displays standardized error content
 * based on the provided [errorData].
 *
 * @param errorData The [AppErrorData] containing title, description, and image for the error state.
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
    errorData: AppErrorData,
    modifier: Modifier = Modifier,
    fullScreen: Boolean = false,
    primaryText: StringResource? = null,
    onPrimary: (() -> Unit)? = null,
    secondaryText: StringResource? = null,
    onSecondary: (() -> Unit)? = null,
    onClose: (() -> Unit)? = null,
    primaryTestTag: String = AppFeedbackTags.PRIMARY_BUTTON,
    secondaryTestTag: String = AppFeedbackTags.SECONDARY_BUTTON,
) {
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
        onClose = onClose,
        primaryTestTag = primaryTestTag,
        secondaryTestTag = secondaryTestTag,
    )
}

@Preview
@Composable
fun AppErrorPreview() {
    DLearnTheme(darkTheme = true) {
        AppError(
            errorData = NoInternetError(),
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
            errorData = AuthError(),
            onPrimary = {},
            onSecondary = {}
        )
    }
}
