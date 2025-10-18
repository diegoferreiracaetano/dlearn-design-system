package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ContinueWatchingCarousel(
    modifier: Modifier = Modifier,
    title: String,
    itemCount: Int,
    itemContent: @Composable (index: Int) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(
                top = 16.dp,
                bottom = 8.dp,
            ),
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(itemCount) { index ->
                itemContent(index)
            }
        }
    }
}

private const val RATIO = 16f / 9f

@Composable
fun ContinueWatchingCard(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(RATIO)
                .clip(RoundedCornerShape(8.dp))
        ) {
            AppImage(
                imageURL = imageUrl,
                contentDescription = title,
                modifier = Modifier.fillMaxSize()
            )

            // Gradiente e ícone de play centralizado
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Unspecified.copy(alpha = 0.8f)
                            ),
                        )
                    )
            )

            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun ContinueWatchingPreview() {
    val dummyTitles = listOf(
        "Introduction to Jetpack Compose",
        "State Management in Compose",
        "Dagger Hilt for Dependency Injection"
    )
    val dummyImageUrls = listOf(
        "https://i3.ytimg.com/vi/n2t5_qA1Q-o/maxresdefault.jpg",
        "https://i3.ytimg.com/vi/N_9o_L4nN5E/maxresdefault.jpg",
        "https://i3.ytimg.com/vi/g-2fcfd4gVE/maxresdefault.jpg"
    )

    DLearnTheme {
        ContinueWatchingCarousel(
            title = "Continue Watching",
            itemCount = dummyTitles.size,
        ) { index ->
            ContinueWatchingCard(
                modifier = Modifier.width(350.dp),
                title = dummyTitles[index],
                imageUrl = dummyImageUrls[index],
                onClick = {}
            )
        }
    }
}
