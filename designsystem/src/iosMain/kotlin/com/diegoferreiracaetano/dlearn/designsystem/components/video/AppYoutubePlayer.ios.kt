package com.diegoferreiracaetano.dlearn.designsystem.components.video

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.WebKit.WKWebView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSMutableURLRequest
import platform.Foundation.addValue
import platform.Foundation.setValue

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun AppYoutubePlayer(
    videoId: String,
    modifier: Modifier,
    isPaused: Boolean
) {
    UIKitView(
        factory = {
            WKWebView().apply {
                val url = NSURL.URLWithString("https://www.youtube.com/embed/$videoId")

                if (url != null) {
                    val request = NSMutableURLRequest.requestWithURL(url).apply {
                        addValue("https://com.diegoferreiracaetano.dlearn", forHTTPHeaderField = "Referer")
                        addValue("strict-origin-when-cross-origin", forHTTPHeaderField = "Referrer-Policy")
                    }
                    loadRequest(request)
                }
            }
        },
        modifier = modifier
    )
}
