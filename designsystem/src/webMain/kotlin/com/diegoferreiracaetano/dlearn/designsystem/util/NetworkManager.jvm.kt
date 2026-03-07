package com.diegoferreiracaetano.dlearn.designsystem.util

import kotlinx.browser.window

/**
 * Web implementation of [NetworkManager] using [window.navigator.onLine].
 */
actual class NetworkManager {
    /**
     * Checks if the browser is currently online.
     * Note: This property only indicates if the browser is connected to a network,
     * not necessarily if it has internet access.
     */
    actual fun isNetworkAvailable(): Boolean {
        return window.navigator.onLine
    }
}
