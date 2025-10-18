package com.diegoferreiracaetano.dlearn.designsystem.components.loading

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

object AppLoadingUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier
    ): UIViewController {
        return ComposeUIViewController {
            // Using the AppLoading composable with its default parameters
            AppLoading(modifier = modifier)
        }
    }
}
