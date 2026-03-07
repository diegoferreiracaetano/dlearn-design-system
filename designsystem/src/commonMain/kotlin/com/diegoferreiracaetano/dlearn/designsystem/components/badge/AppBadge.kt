package com.diegoferreiracaetano.dlearn.designsystem.components.badge

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Types of badges available in the design system.
 * Each type represents a specific visual style and use case.
 */
enum class AppBadgeType {
    /**
     * Used for movie/series ratings. Typically features a semi-transparent dark background
     * and a primary-colored star icon.
     */
    RATING,

    /**
     * Used for categorical labels like "Premium", "Free", or "New".
     * Supports solid background colors.
     */
    TAG,

    /**
     * Used for secondary metadata like age ratings (e.g., "PG-13").
     * Features a transparent background with a thin border.
     */
    OUTLINE
}

/**
 * A unified and flexible Badge component that follows the design system patterns.
 * Internally handles styles based on [AppBadgeType].
 *
 * @param text The text to display inside the badge.
 * @param type The [AppBadgeType] to determine the badge's style.
 * @param modifier Modifier to be applied to the badge layout.
 * @param icon Optional icon to display before the text. If [type] is [AppBadgeType.RATING], 
 * defaults to [Icons.Default.Star].
 * @param containerColor Optional background color override.
 * @param contentColor Optional color for the text and icon.
 */
@Composable
fun AppBadge(
    text: String,
    type: AppBadgeType,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    containerColor: Color? = null,
    contentColor: Color? = null,
) {
    val defaultContainerColor = when (type) {
        AppBadgeType.RATING -> Color.Black.copy(alpha = 0.6f)
        AppBadgeType.TAG -> containerColor ?: MaterialTheme.colorScheme.primary
        AppBadgeType.OUTLINE -> Color.Transparent
    }

    val defaultContentColor = when (type) {
        AppBadgeType.RATING -> MaterialTheme.colorScheme.primary
        AppBadgeType.TAG -> contentColor ?: Color.White
        AppBadgeType.OUTLINE -> contentColor ?: MaterialTheme.colorScheme.primary
    }

    val finalContainerColor = if (type == AppBadgeType.TAG) (containerColor ?: defaultContainerColor) else defaultContainerColor
    val finalContentColor = contentColor ?: defaultContentColor

    val shape: Shape = when (type) {
        AppBadgeType.OUTLINE -> RoundedCornerShape(4.dp)
        else -> RoundedCornerShape(8.dp)
    }

    val padding = when (type) {
        AppBadgeType.TAG -> PaddingValues(horizontal = 12.dp, vertical = 4.dp)
        AppBadgeType.OUTLINE -> PaddingValues(horizontal = 4.dp, vertical = 2.dp)
        else -> PaddingValues(horizontal = 6.dp, vertical = 4.dp)
    }

    val border = if (type == AppBadgeType.OUTLINE) {
        BorderStroke(1.dp, finalContentColor)
    } else null

    val finalIcon = if (type == AppBadgeType.RATING) Icons.Default.Star else icon

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = finalContainerColor,
            contentColor = finalContentColor
        ),
        shape = shape,
        border = border,
    ) {
        Row(
            modifier = Modifier.padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            if (finalIcon != null) {
                Icon(
                    imageVector = finalIcon,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = if (type == AppBadgeType.OUTLINE) 10.sp else 11.sp
                ),
            )
        }
    }
}

@Preview
@Composable
fun AppBadgeUnifiedPreview() {
    DLearnTheme {
        Surface {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Rating Style
                AppBadge(
                    text = "4.5",
                    type = AppBadgeType.RATING
                )

                // Outline Style
                AppBadge(
                    text = "PG-13",
                    type = AppBadgeType.OUTLINE
                )

                // Tag Style
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    AppBadge(
                        text = "Premium",
                        type = AppBadgeType.TAG,
                        containerColor = MaterialTheme.colorScheme.tertiary
                    )
                    AppBadge(
                        text = "Free",
                        type = AppBadgeType.TAG,
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
