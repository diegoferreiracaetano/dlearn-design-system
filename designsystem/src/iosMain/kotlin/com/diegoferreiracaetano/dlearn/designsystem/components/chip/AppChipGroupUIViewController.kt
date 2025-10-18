package com.diegoferreiracaetano.dlearn.designsystem.components.chip

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

object AppChipGroupUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier,
        items: List<AppChip>,
        onFilterChanged: (String?) -> Unit
    ): UIViewController {
        return ComposeUIViewController {
            AppChipGroup(
                modifier = modifier,
                items = items,
                onFilterChanged = onFilterChanged
            )
        }
    }
}
