package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun TypographyScreen() {
    val typography = MaterialTheme.typography
    val styles = listOf(
        "Display Large" to typography.displayLarge,
        "Display Medium" to typography.displayMedium,
        "Display Small" to typography.displaySmall,
        "Headline Large" to typography.headlineLarge,
        "Headline Medium" to typography.headlineMedium,
        "Headline Small" to typography.headlineSmall,
        "Title Large" to typography.titleLarge,
        "Title Medium" to typography.titleMedium,
        "Title Small" to typography.titleSmall,
        "Body Large" to typography.bodyLarge,
        "Body Medium" to typography.bodyMedium,
        "Body Small" to typography.bodySmall,
        "Label Large" to typography.labelLarge,
        "Label Medium" to typography.labelMedium,
        "Label Small" to typography.labelSmall
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("Typography", style = MaterialTheme.typography.titleLarge)
        }
        items(styles) { (name, style) ->
            TypographyItem(style, name)
        }
    }
}

@Composable
private fun TypographyItem(style: TextStyle, name: String) {
    val formattedName = name.replace(" ", "")
    ComponentScaffold(
        title = name,
        description = "Used for ${name.lowercase()} text.",
        codeSnippet = "Text(\"Example\", style = MaterialTheme.typography.$formattedName)"
    ) {
        Text("Hello, World!", style = style)
    }
}
