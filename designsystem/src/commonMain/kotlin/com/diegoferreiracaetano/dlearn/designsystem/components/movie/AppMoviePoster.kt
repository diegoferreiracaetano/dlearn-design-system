package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.badge.AppBadge
import com.diegoferreiracaetano.dlearn.designsystem.components.badge.AppBadgeType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private val RatingBadgePadding = 8.dp

/**
 * A component to display a movie poster with specialized overlays.
 * It handles the image rendering and displays a rating badge in the top-right corner.
 * Additionally, it can display informational tags at the bottom.
 *
 * @param imageSource The [AppImageSource] to load the poster image.
 * @param rating The numeric rating to be displayed in a [AppBadgeType.RATING] badge.
 * @param modifier Modifier to be applied to the poster container.
 * @param width The width of the poster. Defaults to 110.dp.
 * @param height The height of the poster. Defaults to 150.dp.
 * @param primaryInfo Optional primary status text (e.g., "New"). Shown as a badge at the bottom.
 * @param secondaryInfo Optional secondary status text (e.g., "Trending"). Shown below [primaryInfo].
 */
@Composable
fun AppMoviePoster(
    imageSource: AppImageSource,
    rating: Double,
    modifier: Modifier = Modifier,
    width: Dp = 110.dp,
    height: Dp = 150.dp,
    primaryInfo: String? = null,
    secondaryInfo: String? = null
) {
    Box(
        modifier = modifier
            .size(width = width, height = height)
            .clip(MaterialTheme.shapes.medium)
    ) {
        AppImage(
            source = imageSource,
            modifier = Modifier.size(width = width, height = height)
        )

        AppBadge(
            text = rating.toString(),
            type = AppBadgeType.RATING,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(RatingBadgePadding)
        )

        if (primaryInfo != null || secondaryInfo != null) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                primaryInfo?.let {
                    AppBadge(
                        text = it,
                        type = AppBadgeType.TAG,
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                }
                secondaryInfo?.let {
                    AppBadge(
                        text = it,
                        type = AppBadgeType.TAG,
                        containerColor = MaterialTheme.colorScheme.onSurface,
                        contentColor = MaterialTheme.colorScheme.surface
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AppMoviePosterPreview() {
    DLearnTheme {
        AppMoviePoster(
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            rating = 4.5,
            primaryInfo = "Novidade",
            secondaryInfo = "Assista já",
            modifier = Modifier.padding(16.dp)
        )
    }
}
