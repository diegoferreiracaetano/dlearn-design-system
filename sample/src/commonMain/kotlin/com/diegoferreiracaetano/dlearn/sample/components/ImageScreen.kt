package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.image.CircularImage
import dlearn.sample.generated.resources.Res
import dlearn.sample.generated.resources.banner1
import dlearn.sample.generated.resources.banner2
import dlearn.sample.generated.resources.banner3
import dlearn.sample.generated.resources.dlearn_logo

@Composable
fun ImageScreen() {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ComponentScaffold(
                title = "AppImage",
                description = "A simple image component.",
                codeSnippet = "AppImage(resource = Res.drawable.banner3)"
            ) {
                AppImage(imageResource = Res.drawable.banner1)
            }
        }
        item {
            ComponentScaffold(
                title = "CircularImage",
                description = "A circular image component.",
                codeSnippet = "CircularImage(resource = Res.drawable.dlearn_logo)"
            ) {
                CircularImage(resource = Res.drawable.dlearn_logo)
            }
        }
    }
}