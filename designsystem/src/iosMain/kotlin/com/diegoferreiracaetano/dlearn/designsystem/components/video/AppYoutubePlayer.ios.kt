package com.diegoferreiracaetano.dlearn.designsystem.components.video

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import platform.Foundation.NSURL
import platform.WebKit.WKWebView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSMutableURLRequest
import platform.Foundation.addValue
import platform.WebKit.WKWebViewConfiguration
import platform.CoreGraphics.CGRectZero
import kotlinx.cinterop.cValue
import platform.CoreGraphics.CGRect

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun AppYoutubePlayer(
    videoId: String,
    modifier: Modifier,
    isPaused: Boolean
) {
    val webView = remember {
        val config = WKWebViewConfiguration().apply {
            allowsInlineMediaPlayback = true
            mediaTypesRequiringUserActionForPlayback = platform.WebKit.WKAudiovisualMediaTypeNone
        }
        WKWebView(frame = cValue<CGRect> { CGRectZero }, configuration = config)
    }

    LaunchedEffect(videoId) {
        val url = NSURL.URLWithString("https://www.youtube.com/embed/$videoId?enablejsapi=1&playsinline=1&autoplay=1")
        if (url != null) {
            val request = NSMutableURLRequest.requestWithURL(url).apply {
                addValue("https://com.diegoferreiracaetano.dlearn", forHTTPHeaderField = "Referer")
                addValue("strict-origin-when-cross-origin", forHTTPHeaderField = "Referrer-Policy")
            }
            webView.loadRequest(request)
        }
    }

    LaunchedEffect(isPaused) {
        val jsCommand = if (isPaused) {
            "document.getElementsByTagName('video')[0].pause();"
        } else {
            "document.getElementsByTagName('video')[0].play();"
        }
        webView.evaluateJavaScript(jsCommand, null)
    }

    UIKitView(
        factory = { webView },
        modifier = modifier
    )
}
