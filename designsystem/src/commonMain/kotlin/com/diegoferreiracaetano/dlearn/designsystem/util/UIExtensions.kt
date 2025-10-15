package com.diegoferreiracaetano.dlearn.designsystem.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

private const val BRIGHTNESS_THRESHOLD = 0.5f
fun Color.contrastTextColor(): Color {
    return if (this.luminance() > BRIGHTNESS_THRESHOLD) Color.Black else Color.White
}
