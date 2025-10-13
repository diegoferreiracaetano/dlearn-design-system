package com.diegoferreiracaetano.dlearn.designsystem.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

fun Color.contrastTextColor(): Color {
    return if (this.luminance() > 0.5f) Color.Black else Color.White
}
