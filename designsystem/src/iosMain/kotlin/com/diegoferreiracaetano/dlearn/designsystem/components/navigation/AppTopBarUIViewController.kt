package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController


@OptIn(ExperimentalMaterial3Api::class)
object AppTopBarUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier,
        title: String? = null,
        onBack: (() -> Unit)? = null,
        onFavorite: (() -> Unit)? = null,
        onMenuClick: (() -> Unit)? = null,
        useTransparent: Boolean = false
    ): UIViewController {
        return ComposeUIViewController {
            AppTopBar(
                modifier = modifier,
                title = title,
                onBack = onBack,
                onFavorite = onFavorite,
                onMenuClick = onMenuClick,
                useTransparent = useTransparent
            )
        }
    }
}
