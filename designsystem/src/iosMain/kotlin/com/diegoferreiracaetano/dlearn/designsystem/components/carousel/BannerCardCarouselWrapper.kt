package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.DrawableResource
import platform.UIKit.UIViewController

/**
 * A data class to represent the data needed for a BannerCard.
 * This is exposed to Swift.
 */
data class BannerCardItem(
    val title: String,
    val subtitle: String,
    val imageResource: DrawableResource? = null,
    val imageUrl: String? = null,
    val onClick: () -> Unit
)

/**
 * A specific Composable wrapper that uses the generic BannerCarousel
 * to display a carousel of BannerCard items.
 */
@Composable
private fun BannerCardCarousel(
    modifier: Modifier = Modifier,
    title: String,
    items: List<BannerCardItem>
) {
    BannerCarousel(
        modifier = modifier,
        title = title,
        pageCount = items.size
    ) { pageIndex ->
        val item = items[pageIndex]
        BannerCard(
            title = item.title,
            subtitle = item.subtitle,
            imageResource = item.imageResource,
            imageUrl = item.imageUrl,
            onClick = item.onClick
        )
    }
}

/**
 * The UIViewController factory for the BannerCardCarousel.
 */
object BannerCardCarouselUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier,
        title: String,
        items: List<BannerCardItem>
    ): UIViewController {
        return ComposeUIViewController {
            BannerCardCarousel(
                modifier = modifier,
                title = title,
                items = items
            )
        }
    }
}
