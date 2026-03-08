package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.badge.AppBadge
import com.diegoferreiracaetano.dlearn.designsystem.components.badge.AppBadgeType
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.theme.LocalExtendedColorScheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private val DetailIconSize = 20.dp
private val DetailSpacing = 12.dp
private val DividerHeight = 16.dp

/**
 * A specialized component to display detailed movie metadata and rating.
 * Used primarily in the detail screen header.
 *
 * @param year The release year.
 * @param duration The duration string (e.g., "148 min").
 * @param genre The genre of the content.
 * @param rating Optional numeric rating (e.g., 4.5).
 * @param modifier Modifier to be applied to the layout.
 */
@Composable
fun AppMovieDetailInfo(
    year: String,
    duration: String,
    genre: String,
    rating: Double?,
    modifier: Modifier = Modifier
) {
    val extendedColorScheme = LocalExtendedColorScheme.current
    val ratingColor = extendedColorScheme.warning.color

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(DetailSpacing)
        ) {
            AppMetadataItem(
                icon = Icons.Default.CalendarToday,
                text = year,
                iconSize = DetailIconSize,
                textStyle = MaterialTheme.typography.bodyMedium
            )

            VerticalDivider(
                modifier = Modifier.height(DividerHeight),
                color = MaterialTheme.colorScheme.outlineVariant
            )

            AppMetadataItem(
                icon = Icons.Default.Schedule,
                text = duration,
                iconSize = DetailIconSize,
                textStyle = MaterialTheme.typography.bodyMedium
            )

            VerticalDivider(
                modifier = Modifier.height(DividerHeight),
                color = MaterialTheme.colorScheme.outlineVariant
            )

            AppMetadataItem(
                icon = Icons.Default.LocalMovies,
                text = genre,
                iconSize = DetailIconSize,
                textStyle = MaterialTheme.typography.bodyMedium
            )
        }

        rating?.let {
            AppBadge(
                text = it.toString(),
                type = AppBadgeType.RATING,
                containerColor = Color.Transparent,
                contentColor = ratingColor
            )
        }
    }
}

@Preview
@Composable
fun AppMovieDetailInfoPreview() {
    DLearnTheme(darkTheme = true) {
        Surface {
            AppMovieDetailInfo(
                year = "2021",
                duration = "148 Minutes",
                genre = "Action",
                rating = 4.5,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
