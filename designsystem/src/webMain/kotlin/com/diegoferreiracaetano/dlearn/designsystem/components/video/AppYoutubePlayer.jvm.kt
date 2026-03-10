package com.diegoferreiracaetano.dlearn.designsystem.components.video

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * JVM implementation of [AppYoutubePlayer]. 
 * Since WebView support varies on Desktop, this displays a placeholder.
 */
@Composable
actual fun AppYoutubePlayer(
    videoId: String,
    modifier: Modifier,
    isPaused: Boolean
) {
    Box(
        modifier = modifier.background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "YouTube Player not supported on this platform\nVideo ID: $videoId",
            color = Color.White
        )
    }
}
