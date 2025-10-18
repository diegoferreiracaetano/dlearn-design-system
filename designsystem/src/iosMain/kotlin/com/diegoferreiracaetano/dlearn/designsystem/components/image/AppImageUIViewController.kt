package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import org.jetbrains.compose.resources.DrawableResource
import platform.UIKit.UIViewController

object AppImageUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier,
        imageURL: String? = null,
        imageResource: DrawableResource? = null,
        contentDescription: String? = null
    ): UIViewController {
        return ComposeUIViewController {
            AppImage(
                modifier = modifier,
                imageURL = imageURL,
                imageResource = imageResource,
                contentDescription = contentDescription
            )
        }
    }
}
