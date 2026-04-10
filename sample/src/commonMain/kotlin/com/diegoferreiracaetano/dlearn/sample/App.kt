package com.diegoferreiracaetano.dlearn.sample

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.sample.previews.ThemeViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App(darkTheme: Boolean = isSystemInDarkTheme()) {
    val themeViewModel = remember { ThemeViewModel(darkTheme) }
    val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

    DLearnTheme(darkTheme = isDarkTheme) {
        DLearnCatalogApp(themeViewModel)
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}
