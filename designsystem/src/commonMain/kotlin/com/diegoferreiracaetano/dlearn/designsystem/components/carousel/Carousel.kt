package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner1
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner2
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner3
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

data class CarouselItem(
    val title: String,
    val subtitle: String? = null,
    val rating: Float = 0f,
    val imageResource: DrawableResource? = null,
    val imageUrl: String? = null,
    val primaryInfo: String? = null,
    val secondaryInfo: String? = null,
    val rank: Int? = null,
    val onClick: () -> Unit = {}
)

@Composable
fun Carousel(
    modifier: Modifier = Modifier,
    title: String,
    items: List<CarouselItem>
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(items) { item ->
                val hasRank = item.rank != null
                Column(
                    modifier = Modifier
                        .width(if (hasRank) 180.dp else 140.dp)
                        .clickable(onClick = item.onClick)
                ) {
                    Box(
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                    ) {
                        if (hasRank) {
                            item.rank?.let {
                                Text(
                                    text = it.toString(),
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
                        }

                        // Image and Overlays
                        Box(
                            modifier = Modifier
                                .align(if (hasRank) Alignment.CenterEnd else Alignment.Center)
                                .width(140.dp)
                                .height(200.dp)
                                .zIndex(if (hasRank) 1f else 0f)
                                .clip(MaterialTheme.shapes.small)
                        ) {
                            AppImage(
                                imageURL = item.imageUrl,
                                imageResource = item.imageResource,
                                contentDescription = item.title,
                                modifier = Modifier.fillMaxSize(),
                            )
                            if (item.rating > 0) {
                                RatingBadge(
                                    rating = item.rating.toString(),
                                    modifier = Modifier.align(Alignment.TopEnd),
                                )
                            }
                            if (item.primaryInfo != null || item.secondaryInfo != null) {
                                InfoBadges(
                                    primaryInfo = item.primaryInfo,
                                    secondaryInfo = item.secondaryInfo,
                                    modifier = Modifier.align(Alignment.BottomCenter)
                                )
                            }
                        }
                    }

                    // Title and Subtitle for non-ranked items
                    if (!hasRank) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(top = 8.dp),
                        )
                        item.subtitle?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.labelSmall,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun InfoBadges(
    modifier: Modifier = Modifier,
    primaryInfo: String? = null,
    secondaryInfo: String? = null,
) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        primaryInfo?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary, MaterialTheme.shapes.small)
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
        secondaryInfo?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onSurface, MaterialTheme.shapes.small)
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
    }
}

@Composable
private fun RatingBadge(
    rating: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                shape = MaterialTheme.shapes.medium,
            )
            .padding(horizontal = 6.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.size(14.dp),
        )
        Text(
            text = rating,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CarouselDefaultPreview() {
    val dummyItems = listOf(
        CarouselItem(
            title = "Introduction to Jetpack Compose",
            subtitle = "Jetpack Compose",
            imageResource = Res.drawable.banner1,
            rating = 4.5f,
            primaryInfo = "Novidade"
        ),
        CarouselItem(
            title = "State Management in Compose",
            subtitle = "Jetpack Compose",
            imageResource = Res.drawable.banner2,
            rating = 4.8f,
        ),
        CarouselItem(
            title = "Dagger Hilt for Dependency Injection",
            subtitle = "Android",
            imageResource = Res.drawable.banner3,
            rating = 4.2f,
            primaryInfo = "Novo episódio",
            secondaryInfo = "Assista já"
        ),
    )

    DLearnTheme {
        Carousel(
            title = "New Releases",
            items = dummyItems,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CarouselTop10Preview() {
    val dummyItems = listOf(
        CarouselItem(
            rank = 1,
            title = "Introduction to Jetpack Compose",
            imageResource = Res.drawable.banner1,
            rating = 4.5f,
            primaryInfo = "Novidade"
        ),
        CarouselItem(
            rank = 2,
            title = "State Management in Compose",
            imageResource = Res.drawable.banner2,
            rating = 4.8f,
        ),
        CarouselItem(
            rank = 3,
            title = "Dagger Hilt for Dependency Injection",
            imageResource = Res.drawable.banner3,
            rating = 4.2f,
            primaryInfo = "Novo episódio",
            secondaryInfo = "Assista já"
        ),
    )

    DLearnTheme {
        Carousel(
            title = "Top 10 in Brazil",
            items = dummyItems,
        )
    }
}
