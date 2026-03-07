package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.badge.AppBadge
import com.diegoferreiracaetano.dlearn.designsystem.components.badge.AppBadgeType
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.label_free
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.label_premium
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val MetadataIconSize = 16.dp
private val MetadataSpacing = 8.dp

/**
 * A specialized component to display movie metadata and textual information.
 * It automatically adjusts the density and arrangement of information based on whether
 * it's used in a horizontal or vertical layout.
 *
 * @param title The movie title.
 * @param year The release year.
 * @param duration The duration string (e.g., "148 min").
 * @param contentRating Parental guidance rating (e.g., "PG-13").
 * @param genre The genre of the content.
 * @param type The type of content (e.g., "Movie").
 * @param isPremium If true, displays a "Premium" tag; otherwise, a "Free" tag (only in horizontal layout).
 * @param modifier Modifier to be applied to the layout.
 * @param isVerticalLayout If true, uses a more compact vertical arrangement suitable for grid items.
 */
@Composable
fun AppMovieInfo(
    title: String,
    year: String,
    duration: String,
    contentRating: String,
    genre: String,
    type: String,
    isPremium: Boolean,
    modifier: Modifier = Modifier,
    isVerticalLayout: Boolean = false
) {
    Column(
        modifier = modifier,
        verticalArrangement = if (isVerticalLayout) Arrangement.spacedBy(4.dp) else Arrangement.SpaceBetween
    ) {
        if (!isVerticalLayout) {
            AppBadge(
                text = stringResource(if (isPremium) Res.string.label_premium else Res.string.label_free),
                type = AppBadgeType.TAG,
                containerColor = if (isPremium) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
            )
        }

        Text(
            text = title,
            style = if (isVerticalLayout) MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            else MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        if (!isVerticalLayout) {
            AppMetadataItem(icon = Icons.Default.CalendarToday, text = year)

            Row(verticalAlignment = Alignment.CenterVertically) {
                AppMetadataItem(icon = Icons.Default.Schedule, text = duration)
                Spacer(modifier = Modifier.width(MetadataSpacing))
                AppBadge(
                    text = contentRating,
                    type = AppBadgeType.OUTLINE
                )
            }

            AppMetadataItem(
                icon = Icons.AutoMirrored.Filled.List,
                text = "$genre  |  $type"
            )
        } else {
            Text(
                text = "$genre  •  $year",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * A small utility component to display an icon alongside a text metadata.
 * Usually used for year, duration, or lists.
 *
 * @param icon The [ImageVector] to display.
 * @param text The metadata text.
 * @param modifier Modifier to be applied to the row.
 */
@Composable
fun AppMetadataItem(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MetadataSpacing)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline,
            modifier = Modifier.size(MetadataIconSize)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Preview
@Composable
fun AppMovieInfoPreview() {
    DLearnTheme {
        Surface {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                AppMovieInfo(
                    title = "Spider-Man No Way Home",
                    year = "2021",
                    duration = "148 Minutes",
                    contentRating = "PG-13",
                    genre = "Action",
                    type = "Movie",
                    isPremium = true,
                    modifier = Modifier.padding(16.dp).height(150.dp)
                )

                AppMovieInfo(
                    title = "Spider-Man No Way Home",
                    year = "2021",
                    duration = "148 Minutes",
                    contentRating = "PG-13",
                    genre = "Action",
                    type = "Movie",
                    isPremium = true,
                    isVerticalLayout = true,
                    modifier = Modifier.padding(16.dp).fillMaxWidth()
                )
            }
        }
    }
}
