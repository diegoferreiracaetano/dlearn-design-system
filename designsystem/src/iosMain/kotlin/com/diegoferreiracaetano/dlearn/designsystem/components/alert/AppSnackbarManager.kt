package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * A wrapper class to manage and display Snackbars from Swift.
 * This class holds the state and provides a method to show snackbars.
 * An instance of this class should be created and retained in your Swift UI.
 */
class AppSnackbarManager {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private val snackbarHostState = SnackbarHostState()

    /**
     * The UIViewController that hosts the Snackbar UI.
     * This should be added to your view hierarchy (e.g., as an overlay).
     */
    val snackbarHostController: UIViewController = ComposeUIViewController {
        AppSnackbarHost(hostState = snackbarHostState)
    }

    /**
     * Shows a snackbar with the given message and type.
     * This method can be called from Swift to trigger a snackbar.
     */
    fun show(message: String, type: SnackbarType) {
        snackbarHostState.showAppSnackBar(
            scope = scope,
            message = message,
            type = type
        )
    }
}
