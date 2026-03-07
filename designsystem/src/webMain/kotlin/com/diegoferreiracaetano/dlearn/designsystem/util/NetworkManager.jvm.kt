package com.diegoferreiracaetano.dlearn.designsystem.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual class NetworkManager {
    actual fun isNetworkAvailable(): Boolean {
        TODO("Not yet implemented")
    }
}

@Composable
actual fun rememberNetworkManager(): NetworkManager {
    return remember { NetworkManager() }
}