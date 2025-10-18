package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.extendedColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private val SnackbarPadding = 16.dp
private const val SNACKBAR_TYPE_DELIMITER = ":"

enum class SnackbarType {
    ERROR,
    SUCCESS,
    WARNING
}

@Composable
fun AppSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier.padding(SnackbarPadding),
        snackbar = { data ->
            val (type, message) = data.visuals.message.split(SNACKBAR_TYPE_DELIMITER, limit = 2)
            val snackbarType = SnackbarType.valueOf(type)

            val (containerColor, contentColor) = when (snackbarType) {
                SnackbarType.ERROR -> MaterialTheme.colorScheme.error to MaterialTheme.colorScheme.onError
                SnackbarType.SUCCESS -> extendedColors.success.color to extendedColors.success.onColor
                SnackbarType.WARNING -> extendedColors.warning.color to extendedColors.warning.onColor
            }

            Snackbar(
                snackbarData = data,
                containerColor = containerColor,
                contentColor = contentColor,
                shape = MaterialTheme.shapes.medium
            )
        }
    )
}

fun SnackbarHostState.showAppSnackBar(
    scope: CoroutineScope,
    message: String,
    actionLabel: String? = null,
    withDismissAction: Boolean = false,
    duration: SnackbarDuration = SnackbarDuration.Short,
    type: SnackbarType = SnackbarType.ERROR
) {
    scope.launch {
        val prefixedMessage = "${type.name}$SNACKBAR_TYPE_DELIMITER$message"
        showSnackbar(
            message = prefixedMessage,
            actionLabel = actionLabel,
            withDismissAction = withDismissAction,
            duration = duration
        )
    }
}
