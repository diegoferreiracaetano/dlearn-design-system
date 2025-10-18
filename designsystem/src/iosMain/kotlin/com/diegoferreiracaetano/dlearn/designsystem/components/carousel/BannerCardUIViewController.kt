package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.DrawableResource
import platform.UIKit.UIViewController

object BannerCardUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier,
        title: String,
        subtitle: String,
        imageResource: DrawableResource? = null,
        imageUrl: String? = null,
        onClick: () -> Unit
    ): UIViewController {
        return ComposeUIViewController {
            BannerCard(
                modifier = modifier,
                title = title,
                subtitle = subtitle,
                imageResource = imageResource,
                imageUrl = imageUrl,
                onClick = onClick
            )
        }
    }
}
