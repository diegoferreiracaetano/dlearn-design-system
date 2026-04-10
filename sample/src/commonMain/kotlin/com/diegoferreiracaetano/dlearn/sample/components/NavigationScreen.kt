package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChipGroup
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChipItem
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppTopBar
import com.diegoferreiracaetano.dlearn.designsystem.components.search.AppSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreen() {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        item {
            ComponentScaffold(
                title = "AppTopBar",
                description = "A barra superior da aplicação. Suporta títulos, ícones de navegação e ações.",
                codeSnippet = "AppTopBar(title = \"DLearn Catalog\", onMenuClick = { })"
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    AppTopBar(
                        title = "Sample Title",
                        onMenuClick = { },
                        onBack = {}
                    )
                    Text(
                        "A AppTopBar principal do catálogo também está visível no topo da tela.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        item {
            ComponentScaffold(
                title = "AppSearchBar",
                description = "Barra de busca integrada com estado de query e ações.",
                codeSnippet = "AppSearchBar(onSearch = { }, onBackClick = { })"
            ) {
                Column(modifier = Modifier.fillMaxWidth().height(200.dp)) {
                    AppSearchBar(
                        onSearch = { },
                        onBackClick = { },
                        placeholder = "Search movies, series..."
                    )
                }
            }
        }

        item {
            ComponentScaffold(
                title = "AppChipGroup",
                description = "Um grupo de chips usado para filtragem ou seleção rápida.",
                codeSnippet = "AppChipGroup(items = listOf(AppChipItem(label = \"Séries\")), onFilterChanged = { })"
            ) {
                AppChipGroup(
                    items = listOf(
                        AppChipItem(label = "Séries"),
                        AppChipItem(label = "Filmes"),
                        AppChipItem(label = "Documentários"),
                        AppChipItem(label = "Categorias", hasDropDown = true, dropDownOptions = listOf("Ação", "Drama", "Comédia"))
                    ),
                    onFilterChanged = {}
                )
            }
        }
    }
}
