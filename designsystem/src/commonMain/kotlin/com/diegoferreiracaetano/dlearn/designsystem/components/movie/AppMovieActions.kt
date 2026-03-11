package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_netflix
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.movie_action_pause
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.movie_action_play_trailer
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

object AppMovieActionsTags {
    const val PLAY_BUTTON = "AppMovieActions_PlayButton"
    const val ADD_BUTTON = "AppMovieActions_AddButton"
    const val FAVORITE_BUTTON = "AppMovieActions_FavoriteButton"
    const val WATCH_PROVIDERS = "AppMovieActions_WatchProviders"
}

/**
 * A vertical action bar for movies that includes a play button, list/favorite buttons and watch providers.
 *
 * @param onPlayClick Callback for the main play action.
 * @param onAddToListClick Callback for the add to list action.
 * @param onFavoriteClick Callback for the favorite action.
 * @param providers List of watch providers.
 * @param onProviderClick Callback when a provider is clicked.
 * @param modifier Modifier for the container.
 * @param playText Label for the play button.
 * @param isPlaying Whether the video is currently playing.
 * @param isFavorite Whether the movie is favorited.
 * @param isInList Whether the movie is in the user's list.
 */
@Composable
fun AppMovieActions(
    onPlayClick: () -> Unit,
    onAddToListClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    providers: List<WatchProvider>,
    onProviderClick: (WatchProvider) -> Unit,
    modifier: Modifier = Modifier,
    playText: String = stringResource(Res.string.movie_action_play_trailer),
    isPlaying: Boolean = false,
    isFavorite: Boolean = false,
    isInList: Boolean = false
) {
    var watchProvidersExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth().animateContentSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val playIcon = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow
            val playLabel = if (isPlaying) stringResource(Res.string.movie_action_pause) else playText

            AppButton(
                text = playLabel,
                onClick = onPlayClick,
                type = ButtonType.PRIMARY,
                imageSource = playIcon.toAppImageSource(),
                backgroundColor = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.weight(1f),
                testTag = AppMovieActionsTags.PLAY_BUTTON
            )

            AppButton(
                onClick = onAddToListClick,
                type = ButtonType.SECONDARY,
                imageSource = (if (isInList) Icons.Default.Check else Icons.Default.Add).toAppImageSource(),
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                testTag = AppMovieActionsTags.ADD_BUTTON
            )

            AppButton(
                onClick = onFavoriteClick,
                type = ButtonType.SECONDARY,
                imageSource = (if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder).toAppImageSource(),
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                testTag = AppMovieActionsTags.FAVORITE_BUTTON
            )
        }

        AppWatchProviders(
            providers = providers,
            onProviderClick = onProviderClick,
            isExpanded = watchProvidersExpanded,
            onExpandClick = { watchProvidersExpanded = !watchProvidersExpanded },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun AppMovieActionsPreview() {
    val providers = listOf(
        WatchProvider("Mercado Play", Res.drawable.ic_netflix.toAppImageSource(), "Sem custo financeiro"),
        WatchProvider("Netflix", Res.drawable.ic_netflix.toAppImageSource(), "Assinatura"),
        WatchProvider(
            "Amazon Prime Video",
            Res.drawable.ic_netflix.toAppImageSource(),
            "Assinatura",
        ),
        WatchProvider("Paramount+", Res.drawable.ic_netflix.toAppImageSource(), "Assinatura"),
        WatchProvider("Disney+", Res.drawable.ic_netflix.toAppImageSource(), "Assinatura")
    )
    DLearnTheme(darkTheme = true) {
        Box(modifier = Modifier.padding(16.dp)) {
            AppMovieActions(
                onPlayClick = {},
                onAddToListClick = {},
                onFavoriteClick = {},
                providers = providers,
                onProviderClick = {}
            )
        }
    }
}
