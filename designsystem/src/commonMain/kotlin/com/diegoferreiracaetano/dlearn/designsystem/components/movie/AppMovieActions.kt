package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

object AppMovieActionsTags {
    const val PLAY_BUTTON = "AppMovieActions_PlayButton"
    const val DOWNLOAD_BUTTON = "AppMovieActions_DownloadButton"
    const val SHARE_BUTTON = "AppMovieActions_ShareButton"
}

/**
 * A specialized action bar for movie details.
 *
 * @param onPlayClick Callback for the main play action.
 * @param onDownloadClick Callback for the download action.
 * @param onShareClick Callback for the share action.
 * @param modifier Modifier for the container.
 * @param playText Raw string for the play button label.
 */
@Composable
fun AppMovieActions(
    onPlayClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
    playText: String = "Trailer",
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppButton(
            text = playText,
            onClick = onPlayClick,
            type = ButtonType.PRIMARY,
            imageSource = Icons.Default.PlayArrow.toAppImageSource(),
            backgroundColor = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.weight(2f),
            testTag = AppMovieActionsTags.PLAY_BUTTON
        )

        AppButton(
            onClick = onDownloadClick,
            type = ButtonType.SECONDARY,
            imageSource = Icons.Default.Download.toAppImageSource(),
            iconTint = MaterialTheme.colorScheme.tertiary,
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.size(64.dp),
            testTag = AppMovieActionsTags.DOWNLOAD_BUTTON
        )

        AppButton(
            onClick = onShareClick,
            type = ButtonType.SECONDARY,
            imageSource = Icons.Default.Share.toAppImageSource(),
            iconTint = MaterialTheme.colorScheme.primary,
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.size(64.dp),
            testTag = AppMovieActionsTags.SHARE_BUTTON
        )
    }
}

@Preview
@Composable
fun AppMovieActionsPreview() {
    DLearnTheme(darkTheme = true) {
        Box(modifier = Modifier.padding(16.dp)) {
            AppMovieActions(
                onPlayClick = {},
                onDownloadClick = {},
                onShareClick = {}
            )
        }
    }
}
