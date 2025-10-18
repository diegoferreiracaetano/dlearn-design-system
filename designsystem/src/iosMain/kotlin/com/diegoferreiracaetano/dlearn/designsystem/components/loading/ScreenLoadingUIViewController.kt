package com.diegoferreiracaetano.dlearn.designsystem.components.loading

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

object ScreenLoadingUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier
    ): UIViewController {
        return ComposeUIViewController {
            ScreenLoading(modifier = modifier)
        }
    }
}
