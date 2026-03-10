package com.diegoferreiracaetano.dlearn.designsystem.components.video

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppContainer
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppTopBar
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.youtube_player_title
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
expect fun AppYoutubePlayer(
    videoId: String,
    modifier: Modifier = Modifier,
    isPaused: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppYoutubePlayerPreview() {
    DLearnTheme(darkTheme = true) {
        AppContainer(
            topBar = {
                AppTopBar(
                    title = stringResource(Res.string.youtube_player_title),
                    subtitle = "dQw4w9WgXcQ",
                    onBack = {},
                    actions = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color.Red,
                            modifier = Modifier.padding(end = 16.dp)
                        )
                    }
                )
            }
        ) { containerModifier ->
            AppYoutubePlayer(
                videoId = "dQw4w9WgXcQ",
                modifier = containerModifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }
    }
}
