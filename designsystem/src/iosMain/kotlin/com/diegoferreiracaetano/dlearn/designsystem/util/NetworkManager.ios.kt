package com.diegoferreiracaetano.dlearn.designsystem.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.Network.nw_path_get_status
import platform.Network.nw_path_monitor_create
import platform.Network.nw_path_monitor_set_queue
import platform.Network.nw_path_monitor_set_update_handler
import platform.Network.nw_path_monitor_start
import platform.Network.nw_path_status_satisfied
import platform.darwin.dispatch_get_main_queue

actual class NetworkManager {
    private var isAvailable: Boolean = true

    init {
        val monitor = nw_path_monitor_create()
        nw_path_monitor_set_update_handler(monitor) { path ->
            isAvailable = nw_path_get_status(path) == nw_path_status_satisfied
        }
        nw_path_monitor_set_queue(monitor, dispatch_get_main_queue())
        nw_path_monitor_start(monitor)
    }

    actual fun isNetworkAvailable(): Boolean = isAvailable
}

@Composable
actual fun rememberNetworkManager(): NetworkManager {
    return remember { NetworkManager() }
}
