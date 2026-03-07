package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.sample.generated.resources.Res
import com.diegoferreiracaetano.dlearn.sample.generated.resources.banner1
import com.diegoferreiracaetano.dlearn.sample.generated.resources.dlearn_logo

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
                codeSnippet = "AppImage(source = AppImageSource.Resource(Res.drawable.banner3))"
            ) {
                AppImage(source = AppImageSource.Resource(Res.drawable.banner1))
            }
        }
        item {
            ComponentScaffold(
                title = "AppImageCircular",
                description = "A circular image component.",
                codeSnippet = "AppImageCircular(source = AppImageSource.Resource(Res.drawable.dlearn_logo))"
            ) {
                AppImageCircular(source = AppImageSource.Resource(Res.drawable.dlearn_logo))
            }
        }
    }
}
