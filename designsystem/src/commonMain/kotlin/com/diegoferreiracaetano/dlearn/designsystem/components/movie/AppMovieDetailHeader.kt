package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppContainer
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppTopBar
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private val PosterWidth = 205.dp
private val PosterHeight = 287.dp
private val VerticalSpacing = 24.dp
private val TitleSpacing = 16.dp

/**
 * Header component for the movie detail screen.
 * Displays the title at the top, followed by a centered poster and
 * metadata/rating information below.
 *
 * @param movie The [MovieItem] model containing movie data.
 * @param modifier Modifier applied to the root container.
 */
@Composable
fun AppMovieDetailHeader(
    movie: MovieItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppMoviePoster(
            imageSource = movie.imageSource,
            width = PosterWidth,
            height = PosterHeight
        )

        AppMovieDetailInfo(
            year = movie.year,
            duration = movie.duration,
            genre = movie.genre,
            rating = movie.rating,
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
        rating = 4.5
    )

    DLearnTheme(darkTheme = true) {
        AppContainer(
            topBar = {
                AppTopBar(
                    title = sampleMovie.title,
                    subtitle = "Active Now",
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
