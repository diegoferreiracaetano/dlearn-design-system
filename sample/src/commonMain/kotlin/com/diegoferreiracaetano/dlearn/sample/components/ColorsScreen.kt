package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorsScreen() {
    val colors = listOf(
        "primary" to MaterialTheme.colorScheme.primary,
        "onPrimary" to MaterialTheme.colorScheme.onPrimary,
        "secondary" to MaterialTheme.colorScheme.secondary,
        "onSecondary" to MaterialTheme.colorScheme.onSecondary,
        "error" to MaterialTheme.colorScheme.error,
        "onError" to MaterialTheme.colorScheme.onError,
        "background" to MaterialTheme.colorScheme.background,
        "onBackground" to MaterialTheme.colorScheme.onBackground,
        "surface" to MaterialTheme.colorScheme.surface,
        "onSurface" to MaterialTheme.colorScheme.onSurface,
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("Colors", style = MaterialTheme.typography.titleLarge)
        }
        items(colors) { (name, color) ->
            ColorPalette(color, name)
        }
    }
}

@Composable
private fun ColorPalette(color: Color, name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = name, modifier = Modifier.width(120.dp))
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(color)
            )
        }
    }
}
