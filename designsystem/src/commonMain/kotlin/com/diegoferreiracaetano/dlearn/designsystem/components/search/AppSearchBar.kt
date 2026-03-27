package com.diegoferreiracaetano.dlearn.designsystem.components.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.error.AppError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.loading.AppLoading
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.AppMovieItem
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItem
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItemType
import com.diegoferreiracaetano.dlearn.designsystem.components.state.AppEmptyState
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_search
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.search
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.search_placeholder
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A simplified search bar component based on Material 3 SearchBar.
 * It manages its own query state internally and provides a single callback for search actions.
 *
 * @param onSearch Callback invoked whenever the search text changes or the search action is triggered.
 * @param onBackClick Callback invoked when the back navigation button is clicked.
 * @param modifier The [Modifier] to be applied to the search bar.
 * @param placeholder The placeholder text displayed when the search field is empty.
 * @param content The content to be displayed below the search input (e.g., search results).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    onSearch: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(Res.string.search_placeholder),
    content: @Composable ColumnScope.() -> Unit = {}
) {
    var query by rememberSaveable { mutableStateOf("") }

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = {
                    query = it
                    onSearch(it)
                },
                onSearch = {
                    onSearch(it)
                },
                expanded = true,
                onExpandedChange = {},
                placeholder = {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                leadingIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = {
                            query = ""
                            onSearch("")
                        }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = null
                            )
                        }
                    } else {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(Res.string.action_search)
                        )
                    }
                }
            )
        },
        expanded = true,
        onExpandedChange = {},
        modifier = modifier.fillMaxWidth(),
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        content = content
    )
}

@Preview
@Composable
fun AppSearchBarSuccessPreview() {
    val sampleMovies = List(5) { index ->
        MovieItem(
            id = index.toString(),
            title = "Spider-Man No Way Home $index",
            imageSource = AppImageSource.Resource(Res.drawable.banner),
            rating = 4.5,
            year = "2021",
            duration = "148 Minutes",
            contentRating = "PG-13",
            genre = "Action",
            type = "Movie",
            isPremium = true
        )
    }

    DLearnTheme {
        AppSearchBar(
            onSearch = {},
            onBackClick = {},
            content = {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(sampleMovies) { movie ->
                        AppMovieItem(
                            movie = movie,
                            onClick = {},
                            type = MovieItemType.HORIZONTAL
                        )
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun AppSearchBarLoadingPreview() {
    DLearnTheme {
        AppSearchBar(
            onSearch = {},
            onBackClick = {},
            content = {
                AppLoading()
            }
        )
    }
}

@Preview
@Composable
fun AppSearchBarEmptyPreview() {
    DLearnTheme {
        AppSearchBar(
            onSearch = {},
            onBackClick = {},
            content = {
                AppEmptyState(
                    title = "Nenhum resultado encontrado",
                    description = "Não encontramos filmes para o termo pesquisado. Tente outros termos.",
                    imageSource = AppImageSource.Resource(Res.drawable.search)
                )
            }
        )
    }
}

@Preview
@Composable
fun AppSearchBarErrorPreview() {
    DLearnTheme {
        AppSearchBar(
            onSearch = {},
            onBackClick = {},
            content = {
                AppError(
                    errorData = GenericError(),
                    onPrimary = {}
                )
            }
        )
    }
}
