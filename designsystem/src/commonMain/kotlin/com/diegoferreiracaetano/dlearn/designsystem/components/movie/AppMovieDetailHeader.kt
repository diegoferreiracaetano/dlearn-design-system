package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppContainer
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppTopBar
import com.diegoferreiracaetano.dlearn.designsystem.components.video.AppYoutubePlayer
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.app_subtitle
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val PosterWidth = 205.dp
private val PosterHeight = 287.dp
private val VerticalSpacing = 24.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppMovieDetailHeader(
    movie: MovieItem,
    modifier: Modifier = Modifier,
    onPlayClick: () -> Unit = {},
    onDownloadClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    var isPlaying by remember { mutableStateOf(false) }
    var isStarted by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(
            targetState = isStarted,
            transitionSpec = {
                fadeIn(animationSpec = tween(500)) togetherWith fadeOut(animationSpec = tween(500))
            }
        ) { started ->
            if (started) {
                AppYoutubePlayer(
                    videoId = movie.youtubeVideoId ?: "",
                    isPaused = !isPlaying,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(PosterHeight)
                )
            } else {
                Box(
                    modifier = Modifier
                        .width(PosterWidth)
                        .height(PosterHeight),
                    contentAlignment = Alignment.Center
                ) {
                    AppMoviePoster(
                        imageSource = movie.imageSource,
                        width = PosterWidth,
                        height = PosterHeight
                    )
                }
            }
        }

        AppMovieDetailInfo(
            year = movie.year,
            duration = movie.duration,
            genre = movie.genre,
            rating = movie.rating,
            modifier = Modifier.padding(top = VerticalSpacing)
        )

        AppMovieActions(
            onPlayClick = {
                if (!isStarted) {
                    isStarted = true
                    isPlaying = true
                } else {
                    isPlaying = !isPlaying
                }
                onPlayClick()
            },
            isPlaying = isPlaying,
            onDownloadClick = onDownloadClick,
            onShareClick = onShareClick,
            modifier = Modifier.padding(top = VerticalSpacing)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppMovieDetailHeaderPreview() {
    val sampleMovie = MovieItem(
        id = "1",
        title = "Riverdale",
        imageSource = AppImageSource.Resource(Res.drawable.banner),
        year = "2021",
        duration = "148 Minutes",
        genre = "Action",
        rating = 4.5,
        youtubeVideoId = "dQw4w9WgXcQ"
    )

    DLearnTheme(darkTheme = true) {
        AppContainer(
            topBar = {
                AppTopBar(
                    title = sampleMovie.title,
                    subtitle = stringResource(Res.string.app_subtitle),
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
            AppMovieDetailHeader(
                movie = sampleMovie,
                modifier = containerModifier.padding(16.dp)
            )
        }
    }
}
