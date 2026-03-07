package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource

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
 */
data class MovieItem(
    val id: String,
    val title: String,
    val imageSource: AppImageSource,
    val rating: Double,
    val year: String,
    val duration: String,
    val contentRating: String,
    val genre: String,
    val type: String,
    val isPremium: Boolean,
    val primaryInfo: String? = null,
    val secondaryInfo: String? = null
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
    type: MovieItemType = MovieItemType.HORIZONTAL
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
                    isVerticalLayout = false
                )
            }
        }
        MovieItemType.VERTICAL -> {
            Column(
                modifier = modifier
                    .width(VerticalPosterWidth)
                    .clickable(onClick = onClick)
                    .padding(bottom = VerticalPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AppMoviePoster(
                    imageSource = movie.imageSource,
                    rating = movie.rating,
                    width = VerticalPosterWidth,
                    height = VerticalPosterHeight,
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
                    isVerticalLayout = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
