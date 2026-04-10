package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

@Composable
fun ColorsScreen() {
    val colorScheme = MaterialTheme.colorScheme
    val colors = listOf(
        "Primary" to (colorScheme.primary to colorScheme.onPrimary),
        "Primary Container" to (colorScheme.primaryContainer to colorScheme.onPrimaryContainer),
        "Secondary" to (colorScheme.secondary to colorScheme.onSecondary),
        "Secondary Container" to (colorScheme.secondaryContainer to colorScheme.onSecondaryContainer),
        "Tertiary" to (colorScheme.tertiary to colorScheme.onTertiary),
        "Tertiary Container" to (colorScheme.tertiaryContainer to colorScheme.onTertiaryContainer),
        "Error" to (colorScheme.error to colorScheme.onError),
        "Error Container" to (colorScheme.errorContainer to colorScheme.onErrorContainer),
        "Background" to (colorScheme.background to colorScheme.onBackground),
        "Surface" to (colorScheme.surface to colorScheme.onSurface),
        "Surface Variant" to (colorScheme.surfaceVariant to colorScheme.onSurfaceVariant),
        "Outline" to (colorScheme.outline to null),
        "Inverse Surface" to (colorScheme.inverseSurface to colorScheme.inverseOnSurface),
        "Inverse Primary" to (colorScheme.inversePrimary to null),
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("Color Palette", style = MaterialTheme.typography.headlineMedium)
        }
        items(colors) { (name, colorPair) ->
            ColorPalette(name, colorPair.first, colorPair.second)
        }
    }
}

@Composable
private fun ColorPalette(name: String, color: Color, onColor: Color?) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    color = onColor ?: if (isLightColor(color)) Color.Black else Color.White
                )
                Text(
                    text = "#${color.toArgb().toUInt().toString(16).uppercase()}",
                    style = MaterialTheme.typography.bodySmall,
                    color = onColor ?: if (isLightColor(color)) Color.Black else Color.White
                )
            }
            if (onColor != null) {
                Text(
                    text = "On $name",
                    style = MaterialTheme.typography.bodySmall,
                    color = onColor
                )
            }
        }
    }
}

private fun isLightColor(color: Color): Boolean {
    val luminance = 0.299 * color.red + 0.587 * color.green + 0.114 * color.blue
    return luminance > 0.5
}
