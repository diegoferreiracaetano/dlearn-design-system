package com.diegoferreiracaetano.dlearn.designsystem

import androidx.compose.ui.window.ComposeUIViewController
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton

fun mainViewController() = ComposeUIViewController { AppButton(text = "", onClick = {}) }
