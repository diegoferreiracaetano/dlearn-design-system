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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private val BannerPadding = 16.dp
private val BannerIconSize = 56.dp
private val BannerIconPadding = 12.dp
private val BannerSpacing = 16.dp

/**
 * A banner component for displaying highlighted information or memberships.
 *
 * @param title The title text of the banner.
 * @param description The description text of the banner.
 * @param modifier The [Modifier] to be applied to the banner.
 * @param icon Optional [ImageVector] to be displayed as a leading icon.
 * @param containerColor Optional background color. Defaults to the theme's tertiary color.
 * @param contentColor Optional content color. Defaults to the theme's onTertiary color.
 */
@Composable
fun AppBanner(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    containerColor: Color? = null,
    contentColor: Color? = null
) {
    val finalContainerColor = containerColor ?: MaterialTheme.colorScheme.tertiary
    val finalContentColor = contentColor ?: MaterialTheme.colorScheme.onTertiary
    val shape = MaterialTheme.shapes.medium

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = finalContentColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            finalContainerColor,
                            finalContainerColor.copy(alpha = 0.6f)
                        )
                    )
                )
                .padding(BannerPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Box(
                    modifier = Modifier
                        .size(BannerIconSize)
                        .background(
                            color = finalContentColor.copy(alpha = 0.2f),
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(BannerIconPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        modifier = Modifier.size(BannerIconSize - (BannerIconPadding * 2)),
                        tint = finalContentColor
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
                    color = finalContentColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = finalContentColor.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Preview
@Composable
fun AppBannerPreview() {
    DLearnTheme(
        darkTheme = true
    ) {
        AppBanner(
            title = "Premium Member",
            description = "New movies are coming for you, Download Now!",
            icon = Icons.Default.WorkspacePremium
        )
    }
}
