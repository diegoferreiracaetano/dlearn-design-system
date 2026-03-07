package com.diegoferreiracaetano.dlearn.designsystem.util

import androidx.compose.runtime.Composable

expect class NetworkManager {
    fun isNetworkAvailable(): Boolean
}

@Composable
expect fun rememberNetworkManager(): NetworkManager
