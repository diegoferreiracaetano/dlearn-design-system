package com.diegoferreiracaetano.dlearn.designsystem.components.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.github.guilhe.kmp.composeuiviewcontroller.ComposeUIViewController
import org.jetbrains.compose.ui.tooling.preview.Preview

@ComposeUIViewController
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
