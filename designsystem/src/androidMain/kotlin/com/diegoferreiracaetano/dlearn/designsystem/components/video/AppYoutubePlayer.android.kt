package com.diegoferreiracaetano.dlearn.designsystem.components.video

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@SuppressLint("SetJavaScriptEnabled")
@Composable
actual fun AppYoutubePlayer(
    videoId: String,
    modifier: Modifier,
    isPaused: Boolean
) {
    var playerInstance by remember { mutableStateOf<YouTubePlayer?>(null) }

    DisposableEffect(isPaused) {
        if (isPaused) {
            playerInstance?.pause()
        } else {
            playerInstance?.play()
        }
        onDispose { }
    }

    AndroidView(
        modifier = modifier,
        factory = { context ->
            YouTubePlayerView(context).apply {
                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        playerInstance = youTubePlayer
                        youTubePlayer.loadVideo(videoId, 0f)
                        if (isPaused) {
                            youTubePlayer.pause()
                        }
                    }
                })
            }
        },
        update = { }
    )
}
