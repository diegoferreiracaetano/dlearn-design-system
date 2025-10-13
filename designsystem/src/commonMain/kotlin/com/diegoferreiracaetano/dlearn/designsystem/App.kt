package com.diegoferreiracaetano.dlearn.designsystem

import androidx.compose.runtime.Composable
import com.diegoferreiracaetano.dlearn.designsystem.components.ComponentGallery
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    DLearnTheme {
        ComponentGallery()
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}
