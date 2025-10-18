package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

object CarouselUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier,
        title: String,
        items: List<CarouselItem>
    ): UIViewController {
        return ComposeUIViewController {
            Carousel(
                modifier = modifier,
                title = title,
                items = items
            )
        }
    }
}
