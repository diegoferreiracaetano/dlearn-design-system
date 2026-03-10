package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ItemSpacing = 16.dp
private val VerticalPadding = 8.dp
private val PosterHeight = 150.dp
private val HorizontalPosterWidth = 110.dp
private val VerticalPosterWidth = 140.dp
private val VerticalPosterHeight = 200.dp

/**
 * Data class representing a movie or series item in the design system.
 * 
 * @property id Unique identifier for the movie.
 * @property title The name of the movie or series.
 * @property imageSource The source for the poster image (Resource, URL, etc).
 * @property rating Numeric rating (e.g., 4.5).
 * @property year Release year as a string.
 * @property duration Duration description (e.g., "120 min" or "1h 30m").
 * @property contentRating Parental guidance rating (e.g., "PG-13").
 * @property genre Main genre of the content.
 * @property type Content type (e.g., "Movie", "TV Series").
 * @property isPremium Whether the content requires a premium subscription.
 * @property primaryInfo Optional short text displayed on a primary badge over the poster.
 * @property secondaryInfo Optional short text displayed on a secondary badge over the poster.
 * @property rank Optional rank number for "Top 10" style carousels.
 * @property youtubeVideoId Optional YouTube video ID for trailers/previews.
 */
data class MovieItem(
    val id: String,
    val title: String,
    val imageSource: AppImageSource,
    val rating: Double? = null,
    val year: String = "",
    val duration: String = "",
    val contentRating: String = "",
    val genre: String = "",
    val type: String = "",
    val isPremium: Boolean = false,
    val primaryInfo: String? = null,
    val secondaryInfo: String? = null,
    val rank: Int? = null,
    val youtubeVideoId: String? = null,
)

/**
 * Defines the available layout variations for movie items.
 */
enum class MovieItemType {
    /**
     * Horizontal layout optimized for lists. Poster on the left, details on the right.
     */
    HORIZONTAL,

    /**
     * Vertical layout optimized for grids and carousels. Poster on top, details below.
     */
    VERTICAL
}

/**
 * A comprehensive component to display a movie or series item.
 * It automatically handles the layout based on the [type] provided and uses
 * [AppMoviePoster] and [AppMovieInfo] internally.
 *
 * @param movie The [MovieItem] data model containing all necessary information.
 * @param onClick Callback triggered when the item is tapped.
 * @param modifier Modifier to be applied to the container.
 * @param type The layout variation to use ([MovieItemType.HORIZONTAL] or [MovieItemType.VERTICAL]).
 */
@Composable
fun AppMovieItem(
    movie: MovieItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: MovieItemType = MovieItemType.HORIZONTAL,
) {
    when (type) {
        MovieItemType.HORIZONTAL -> {
            Row(
                modifier = modifier
                    .clickable(onClick = onClick)
                    .padding(vertical = VerticalPadding),
                horizontalArrangement = Arrangement.spacedBy(ItemSpacing)
            ) {
                AppMoviePoster(
                    imageSource = movie.imageSource,
                    rating = movie.rating,
                    width = HorizontalPosterWidth,
                    height = PosterHeight,
                    primaryInfo = movie.primaryInfo,
                    secondaryInfo = movie.secondaryInfo
                )

                AppMovieInfo(
                    title = movie.title,
                    year = movie.year,
                    duration = movie.duration,
                    contentRating = movie.contentRating,
                    genre = movie.genre,
                    type = movie.type,
                    isPremium = movie.isPremium,
                    modifier = Modifier.weight(1f).height(PosterHeight),
                    layoutType = AppMovieInfoType.HORIZONTAL
                )
            }
        }
        MovieItemType.VERTICAL -> {
            val hasRank = movie.rank != null
            Column(
                modifier = modifier
                    .width(if (hasRank) 180.dp else VerticalPosterWidth)
                    .clickable(onClick = onClick)
                    .padding(bottom = VerticalPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    if (hasRank) {
                        Text(
                            text = movie.rank.toString(),
                            style = MaterialTheme.typography.displayLarge.copy(
                                fontSize = 126.sp,
                                fontWeight = FontWeight.Black,
                                fontStyle = FontStyle.Italic
                            ),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .offset(x = (-5).dp)
                                .zIndex(0f)
                        )
                    }
                    AppMoviePoster(
                        imageSource = movie.imageSource,
                        rating = movie.rating,
                        width = VerticalPosterWidth,
                        height = VerticalPosterHeight,
                        primaryInfo = movie.primaryInfo,
                        secondaryInfo = movie.secondaryInfo,
                        modifier = Modifier
                            .align(if (hasRank) Alignment.CenterEnd else Alignment.Center)
                            .zIndex(1f)
                    )
                }

                if (!hasRank) {
                    AppMovieInfo(
                        title = movie.title,
                        year = movie.year,
                        duration = movie.duration,
                        contentRating = movie.contentRating,
                        genre = movie.genre,
                        type = movie.type,
                        isPremium = movie.isPremium,
                        layoutType = AppMovieInfoType.VERTICAL,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AppMovieItemPreview() {
    val sampleMovie = MovieItem(
        id = "1",
        title = "Spider-Man No Way Home",
        imageSource = AppImageSource.Resource(Res.drawable.banner),
        rating = 4.5,
        year = "2021",
        duration = "148 Minutes",
        contentRating = "PG-13",
        genre = "Action",
        type = "Movie",
        isPremium = true,
        primaryInfo = "New",
        secondaryInfo = "Trending"
    )

    DLearnTheme {
        Surface {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text("Horizontal Layout", style = MaterialTheme.typography.titleMedium)
                AppMovieItem(
                    movie = sampleMovie,
                    onClick = {},
                    type = MovieItemType.HORIZONTAL
                )

                Text("Vertical Layout", style = MaterialTheme.typography.titleMedium)
                AppMovieItem(
                    movie = sampleMovie,
                    onClick = {},
                    type = MovieItemType.VERTICAL
                )

                Text("Vertical Layout with Rank", style = MaterialTheme.typography.titleMedium)
                AppMovieItem(
                    movie = sampleMovie.copy(rank = 1),
                    onClick = {},
                    type = MovieItemType.VERTICAL
                )
            }
        }
    }
}
