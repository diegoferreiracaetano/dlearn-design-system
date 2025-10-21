package com.diegoferreiracaetano.dlearn.designsystem

import androidx.compose.ui.window.ComposeUIViewController
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import platform.UIKit.UIViewController

object AppButtonUIViewController {
    operator fun invoke(
        text: String,
        onClick: () -> Unit,
        type: ButtonType = ButtonType.PRIMARY,
        enabled: Boolean = true
    ): UIViewController {
        return ComposeUIViewController {
            AppButton(
                text = text,
                onClick = onClick,
                type = type,
                enabled = enabled
            )
        }
    }
}
