package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.sample.generated.resources.Res
import com.diegoferreiracaetano.dlearn.sample.generated.resources.overview_description
import com.diegoferreiracaetano.dlearn.sample.generated.resources.overview_explore
import com.diegoferreiracaetano.dlearn.sample.generated.resources.overview_welcome_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun OverviewScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.overview_welcome_title),
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        onDraw = {
                            val canvasWidth = size.width
                            val canvasHeight = size.height
                            drawLine(
                                start = Offset(x = 0f, y = canvasHeight / 2),
                                end = Offset(x = canvasWidth, y = canvasHeight / 2),
                                color = Color.Gray,
                                strokeWidth = 5f
                            )
                        }
                    )
                }
            }
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.overview_description),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.overview_explore),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
