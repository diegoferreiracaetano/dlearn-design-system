package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val BANNER_RATIO = 16f / 9f

@Composable
fun BannerCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageResource: DrawableResource? = null,
    imageUrl: String? = null,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .aspectRatio(BANNER_RATIO)
            .fillMaxSize()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AppImage(
                imageURL = imageUrl,
                imageResource = imageResource,
                contentDescription = title,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.scrim.copy(alpha = 0.7f)
                            ),
                            startY = 300f
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = subtitle,
                    color = Color.White.copy(alpha = 0.8f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun BannerCarousel(
    modifier: Modifier = Modifier,
    title: String,
    pageCount: Int,
    pageContent: @Composable (pageIndex: Int) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 8.dp),
        )
        AppCarousel(
            pageCount = pageCount,
            pageContent = pageContent
        )
    }
}

@Preview
@Composable
fun BannerCardPreview() {
    DLearnTheme {
        BannerCard(
            title = "Introduction to Jetpack Compose",
            subtitle = "Jetpack Compose",
            imageUrl = "https://i3.ytimg.com/vi/n2t5_qA1Q-o/maxresdefault.jpg",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun BannerCarouselPreview() {
    val dummyTitles = listOf(
        "Introduction to Jetpack Compose",
        "State Management in Compose",
        "Dagger Hilt for Dependency Injection"
    )
    val dummySubtitles = listOf(
        "Jetpack Compose",
        "Jetpack Compose",
        "Android"
    )
    val dummyImageUrls = listOf(
        "https://i3.ytimg.com/vi/n2t5_qA1Q-o/maxresdefault.jpg",
        "https://i3.ytimg.com/vi/N_9o_L4nN5E/maxresdefault.jpg",
        "https://i3.ytimg.com/vi/g-2fcfd4gVE/maxresdefault.jpg"
    )

    DLearnTheme {
        BannerCarousel(
            title = "Favoritos",
            pageCount = dummyTitles.size,
        ) { pageIndex ->
            BannerCard(
                title = dummyTitles[pageIndex],
                subtitle = dummySubtitles[pageIndex],
                imageUrl = dummyImageUrls[pageIndex],
                onClick = { println("Clicked ${dummyTitles[pageIndex]}") }
            )
        }
    }
}
