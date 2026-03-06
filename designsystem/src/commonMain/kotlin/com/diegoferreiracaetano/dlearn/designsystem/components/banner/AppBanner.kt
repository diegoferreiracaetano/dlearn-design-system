package com.diegoferreiracaetano.dlearn.designsystem.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val BannerPadding = 16.dp
private val BannerIconSize = 56.dp
private val BannerCornerRadius = 32.dp
private val BannerIconPadding = 12.dp
private val BannerSpacing = 16.dp

@Composable
fun AppBanner(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    imageResource: DrawableResource? = null,
    backgroundColor: Color? = null
) {
    val finalBackgroundColor = backgroundColor ?: Color(0xFFFF8700)

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(BannerCornerRadius),
        color = finalBackgroundColor
    ) {
        Row(
            modifier = Modifier.padding(BannerPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            imageResource?.let {
                Box(
                    modifier = Modifier
                        .size(BannerIconSize)
                        .background(
                            color = Color.White.copy(alpha = 0.2f),
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(BannerIconPadding),
                    contentAlignment = Alignment.Center
                ) {
                    AppImage(
                        imageResource = it,
                        modifier = Modifier.size(BannerIconSize - (BannerIconPadding * 2)),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(BannerSpacing))
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Preview
@Composable
fun AppBannerPreview() {
    DLearnTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            AppBanner(
                title = "Premium Member",
                subtitle = "New movies are coming for you, Download Now!",
            )
        }
    }
}
