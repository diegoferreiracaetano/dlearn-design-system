package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.extendedColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private val SnackbarPadding = 16.dp

/**
 * Types of snackbars supported by the system.
 */
enum class SnackbarType {
    ERROR,
    SUCCESS,
    WARNING
}

/**
 * Custom visuals to support SnackbarType.
 */
data class AppSnackbarVisuals(
    override val message: String,
    override val actionLabel: String? = null,
    override val withDismissAction: Boolean = false,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
    val type: SnackbarType
) : SnackbarVisuals

/**
 * Custom SnackbarHost with styled snackbars.
 */
@Composable
fun AppSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier.padding(SnackbarPadding),
        snackbar = { data ->
            val visuals = data.visuals as? AppSnackbarVisuals
            val snackbarType = visuals?.type ?: SnackbarType.ERROR

            val (containerColor, contentColor) = when (snackbarType) {
                SnackbarType.ERROR ->
                    MaterialTheme.colorScheme.error to MaterialTheme.colorScheme.onError
                SnackbarType.SUCCESS ->
                    extendedColors.success.color to extendedColors.success.onColor
                SnackbarType.WARNING ->
                    extendedColors.warning.color to extendedColors.warning.onColor
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

/**
 * Shows a custom snackbar using proper visuals.
 */
fun SnackbarHostState.showAppSnackBar(
    scope: CoroutineScope,
    message: String,
    actionLabel: String? = null,
    withDismissAction: Boolean = false,
    duration: SnackbarDuration = SnackbarDuration.Short,
    type: SnackbarType = SnackbarType.ERROR
) {
    scope.launch {
        showSnackbar(
            visuals = AppSnackbarVisuals(
                message = message,
                actionLabel = actionLabel,
                withDismissAction = withDismissAction,
                duration = duration,
                type = type
            )
        )
    }
}
