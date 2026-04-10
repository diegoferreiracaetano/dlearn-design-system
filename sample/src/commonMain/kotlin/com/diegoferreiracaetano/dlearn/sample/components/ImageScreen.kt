package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImage
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.sample.generated.resources.Res
import com.diegoferreiracaetano.dlearn.sample.generated.resources.banner1
import com.diegoferreiracaetano.dlearn.sample.generated.resources.dlearn_logo

@Composable
fun ImageScreen() {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Text("Image Components", style = MaterialTheme.typography.headlineMedium)
        }

        item {
            ComponentScaffold(
                title = "AppImage - Resource",
                description = "Displays an image from resources.",
                codeSnippet = "AppImage(source = AppImageSource.Resource(Res.drawable.banner1))"
            ) {
                AppImage(
                    modifier = Modifier.fillMaxWidth().height(180.dp),
                    source = AppImageSource.Resource(Res.drawable.banner1)
                )
            }
        }

        item {
            ComponentScaffold(
                title = "AppImageCircular",
                description = "Displays a circular image, ideal for profiles.",
                codeSnippet = "AppImageCircular(source = AppImageSource.Resource(Res.drawable.dlearn_logo))"
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppImageCircular(
                        modifier = Modifier.size(64.dp),
                        source = AppImageSource.Resource(Res.drawable.dlearn_logo)
                    )
                    AppImageCircular(
                        modifier = Modifier.size(100.dp),
                        source = AppImageSource.Resource(Res.drawable.dlearn_logo)
                    )
                }
            }
        }

        item {
            ComponentScaffold(
                title = "AppImage - Vector",
                description = "Displays an image from a Vector.",
                codeSnippet = "AppImage(source = Icons.Default.Home.toAppImageSource())"
            ) {
                AppImage(
                    modifier = Modifier.size(48.dp),
                    source = Icons.Default.Home.toAppImageSource()
                )
            }
        }

        item {
            ComponentScaffold(
                title = "AppImage - URL",
                description = "Displays an image from a remote URL.",
                codeSnippet = "AppImage(source = AppImageSource.Url(\"https://...\"))"
            ) {
                AppImage(
                    modifier = Modifier.fillMaxWidth().height(180.dp),
                    source = AppImageSource.Url("https://images.unsplash.com/photo-1618477388954-7852f32655ec")
                )
            }
        }
    }
}
