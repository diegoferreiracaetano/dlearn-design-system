package com.diegoferreiracaetano.dlearn.designsystem.components.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A full-screen loading component that displays an [AppLoading] indicator centered on the screen.
 * It uses the surface variant background color from the current theme.
 *
 * @param modifier The [Modifier] to be applied to the loading screen.
 */
@Composable
fun ScreenLoading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        AppLoading()
    }
}

@Preview
@Composable
fun ScreenLoadingPreview() {
    DLearnTheme {
        ScreenLoading()
    }
}
