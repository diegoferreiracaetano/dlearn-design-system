package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.extendedColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

enum class SnackbarType {
    ERROR,
    SUCCESS,
    WARNING
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier.padding(16.dp),
        snackbar = { data ->
            val type = SnackbarManager.currentType

            val (containerColor, contentColor) = when (type) {
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


object SnackbarManager {
    var currentType: SnackbarType = SnackbarType.ERROR
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
        showTypedSnackBar(
            message = message,
            actionLabel = actionLabel,
            withDismissAction = withDismissAction,
            duration = duration,
            type = type
        )
    }
}

 private suspend fun SnackbarHostState.showTypedSnackBar(
    message: String,
    actionLabel: String? = null,
    withDismissAction: Boolean = false,
    duration: SnackbarDuration = SnackbarDuration.Short,
    type: SnackbarType = SnackbarType.ERROR
): SnackbarResult {
    SnackbarManager.currentType = type
    return showSnackbar(
        message = message,
        actionLabel = actionLabel,
        withDismissAction = withDismissAction,
        duration = duration
    )
}