package com.diegoferreiracaetano.dlearn.designsystem.components.search

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_back
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_menu
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_profile
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_search
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_placeholder
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.search_placeholder
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val PROFILE_IMAGE_SIZE = 32.dp

/**
 * A custom [SearchBar] styled for the application based on Material 3.
 *
 * @param query The current text value of the search field.
 * @param onQueryChange Callback when the search value changes.
 * @param onSearch Callback when the search action is triggered (e.g., keyboard search button).
 * @param active Whether the search bar is currently active (expanded).
 * @param onActiveChange Callback when the active state changes.
 * @param modifier The [Modifier] to be applied to the search bar.
 * @param placeholder The placeholder text to display.
 * @param onMenuClick Callback for the menu icon. If provided, replaces the search icon when not active.
 * @param profileImageSource The source of the profile image to be displayed in the trailing icon slot.
 * @param onProfileClick Callback when the profile image is clicked.
 * @param content The content to display when the search bar is active (e.g., search results or suggestions).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(Res.string.search_placeholder),
    onMenuClick: (() -> Unit)? = null,
    profileImageSource: AppImageSource? = null,
    onProfileClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = onQueryChange,
                onSearch = onSearch,
                expanded = active,
                onExpandedChange = onActiveChange,
                placeholder = {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                leadingIcon = {
                    if (active) {
                        IconButton(onClick = { onActiveChange(false) }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(Res.string.action_back)
                            )
                        }
                    } else if (onMenuClick != null) {
                        IconButton(onClick = onMenuClick) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(Res.string.action_menu)
                            )
                        }
                    } else {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(Res.string.action_search)
                        )
                    }
                },
                trailingIcon = {
                    if (active) {
                        if (query.isNotEmpty()) {
                            IconButton(onClick = { onQueryChange("") }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = null
                                )
                            }
                        }
                    } else {
                        if (profileImageSource != null || onProfileClick != null) {
                            IconButton(onClick = { onProfileClick?.invoke() }) {
                                AppImageCircular(
                                    modifier = Modifier.size(PROFILE_IMAGE_SIZE),
                                    source = profileImageSource,
                                    contentDescription = stringResource(Res.string.action_profile)
                                )
                            }
                        } else {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(Res.string.action_search)
                            )
                        }
                    }
                }
            )
        },
        expanded = active,
        onExpandedChange = onActiveChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = if (active) 0.dp else 16.dp),
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        content = {
            content()
        }
    )
}

@Preview
@Composable
fun AppSearchBarPreview() {
    DLearnTheme {
        AppSearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            onMenuClick = {},
            profileImageSource = AppImageSource.Resource(Res.drawable.profile_placeholder)
        )
    }
}
