package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChip
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChipGroup

@Composable
fun NavigationScreen() {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ComponentScaffold(
                title = "AppTopBar",
                description = "The top app bar. A transparent version is also available.",
                codeSnippet = "AppTopBar(title = " +
                        "\"Navigation\")\nAppTopBar(title = \"Navigation\", useTransparent = true)"
            ) {
                Text(
                    "This screen is displayed within an AppContainer.",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        item {
            ComponentScaffold(
                title = "AppChipGroup",
                description = "A group of chips, often used for filtering.",
                codeSnippet = "AppChipGroup(\n" +
                    "    items = listOf(AppChip(label = \"Chip 1\"), AppChip(label = \"Chip 2\")),\n" +
                    "    onFilterChanged = {}\n" +
                    ")"
            ) {
                AppChipGroup(
                    items = listOf(AppChip(label = "Chip 1"), AppChip(label = "Chip 2")),
                    onFilterChanged = {}
                )
            }
        }
    }
}
