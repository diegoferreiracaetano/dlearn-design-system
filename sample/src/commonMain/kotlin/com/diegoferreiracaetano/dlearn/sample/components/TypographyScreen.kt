package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
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
        "Display Large" to (typography.displayLarge to "Display Large"),
        "Display Medium" to (typography.displayMedium to "Display Medium"),
        "Display Small" to (typography.displaySmall to "Display Small"),
        "Headline Large" to (typography.headlineLarge to "Headline Large"),
        "Headline Medium" to (typography.headlineMedium to "Headline Medium"),
        "Headline Small" to (typography.headlineSmall to "Headline Small"),
        "Title Large" to (typography.titleLarge to "Title Large"),
        "Title Medium" to (typography.titleMedium to "Title Medium"),
        "Title Small" to (typography.titleSmall to "Title Small"),
        "Body Large" to (typography.bodyLarge to "Body Large"),
        "Body Medium" to (typography.bodyMedium to "Body Medium"),
        "Body Small" to (typography.bodySmall to "Body Small"),
        "Label Large" to (typography.labelLarge to "Label Large"),
        "Label Medium" to (typography.labelMedium to "Label Medium"),
        "Label Small" to (typography.labelSmall to "Label Small")
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Text("Typography System", style = MaterialTheme.typography.headlineMedium)
        }
        items(styles) { (name, pair) ->
            TypographyItem(pair.first, name)
        }
    }
}

@Composable
private fun TypographyItem(style: TextStyle, name: String) {
    val formattedName = name.replace(" ", "").let { 
        it.first().lowercase() + it.substring(1)
    }
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "The quick brown fox jumps over the lazy dog",
            style = style
        )
        Text(
            text = "MaterialTheme.typography.$formattedName",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.outline
        )
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp), color = MaterialTheme.colorScheme.outlineVariant)
    }
}
