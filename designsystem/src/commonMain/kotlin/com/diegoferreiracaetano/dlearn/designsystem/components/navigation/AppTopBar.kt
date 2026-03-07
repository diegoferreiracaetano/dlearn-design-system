package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_back
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_favorite
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_menu
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_profile
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_search
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.search_placeholder
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.util.contrastTextColor
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val MAX_TITLE_LINES = 1
private val PROFILE_IMAGE_SIZE = 32.dp

/**
 * A custom [TopAppBar] that can switch between a default and a transparent style.
 * It supports a title, subtitle, back button, favorite button, menu button, and integrated search.
 *
 * @param modifier The [Modifier] to be applied to the top bar.
 * @param title The title text to be displayed.
 * @param subtitle The subtitle text to be displayed below the title.
 * @param onBack Callback for the back navigation icon.
 * @param onFavorite Callback for the favorite action icon.
 * @param onMenuClick Callback for the menu navigation icon.
 * @param searchValue The current value of the search field.
 * @param onSearchValueChange Callback when the search value changes. If null, search is disabled.
 * @param backgroundColor The background color used for contrast in transparent mode.
 * @param useTransparent Whether to use the transparent style.
 * @param scrollBehavior The [TopAppBarScrollBehavior] to use.
 * @param actions Additional actions to be displayed in the top bar.
 * @param profileImageSource The source of the profile image (URL or Resource).
 * @param onProfileClick Callback when the profile image is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null,
    onBack: (() -> Unit)? = null,
    onFavorite: (() -> Unit)? = null,
    onMenuClick: (() -> Unit)? = null,
    searchValue: String = "",
    onSearchValueChange: ((String) -> Unit)? = null,
    backgroundColor: Color = Color.Unspecified,
    useTransparent: Boolean = false,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    actions: @Composable RowScope.() -> Unit = {},
    profileImageSource: AppImageSource? = null,
    onProfileClick: (() -> Unit)? = null,
) {
    if (useTransparent) {
        AppTopBarTransparent(
            modifier = modifier,
            backgroundColor = backgroundColor,
            onBack = onBack,
            onFavorite = onFavorite,
            scrollBehavior = scrollBehavior,
            profileImageSource = profileImageSource,
            onProfileClick = onProfileClick,
        )
    } else {
        AppTopBarDefault(
            modifier = modifier,
            title = title,
            subtitle = subtitle,
            onBack = onBack,
            onMenuClick = onMenuClick,
            searchValue = searchValue,
            onSearchValueChange = onSearchValueChange,
            scrollBehavior = scrollBehavior,
            actions = actions,
            profileImageSource = profileImageSource,
            onProfileClick = onProfileClick,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBarDefault(
    modifier: Modifier = Modifier,
    title: String?,
    subtitle: String?,
    onBack: (() -> Unit)?,
    onMenuClick: (() -> Unit)?,
    searchValue: String,
    onSearchValueChange: ((String) -> Unit)?,
    scrollBehavior: TopAppBarScrollBehavior?,
    actions: @Composable RowScope.() -> Unit,
    profileImageSource: AppImageSource?,
    onProfileClick: (() -> Unit)?,
) {
    var isSearchActive by remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            if (isSearchActive && onSearchValueChange != null) {
                TextField(
                    value = searchValue,
                    onValueChange = onSearchValueChange,
                    placeholder = {
                        Text(
                            text = stringResource(Res.string.search_placeholder),
                            style = MaterialTheme.typography.labelLarge
                        )
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.primary
                    ),
                    textStyle = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (title != null) {
                        Text(
                            text = title,
                            maxLines = MAX_TITLE_LINES,
                            style = MaterialTheme.typography.labelLarge,
                        )
                    }
                    if (subtitle != null) {
                        Text(
                            text = subtitle,
                            maxLines = MAX_TITLE_LINES,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        },
        navigationIcon = {
            if (isSearchActive) {
                IconButton(onClick = {
                    isSearchActive = false
                    onSearchValueChange?.invoke("")
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.action_back),
                    )
                }
            } else if (profileImageSource != null || onProfileClick != null) {
                IconButton(onClick = { onProfileClick?.invoke() }) {
                    AppImageCircular(
                        modifier = Modifier.size(PROFILE_IMAGE_SIZE),
                        source = profileImageSource,
                        contentDescription = stringResource(Res.string.action_profile)
                    )
                }
            } else if (onMenuClick != null) {
                IconButton(onClick = onMenuClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = stringResource(Res.string.action_menu),
                    )
                }
            } else if (onBack != null) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.action_back),
                    )
                }
            }
        },
        actions = {
            if (onSearchValueChange != null && !isSearchActive) {
                IconButton(onClick = { isSearchActive = true }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(Res.string.action_search),
                    )
                }
            }

            if (isSearchActive) {
                if (searchValue.isNotEmpty()) {
                    IconButton(onClick = { onSearchValueChange?.invoke("") }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                        )
                    }
                }
            } else {
                actions()
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBarTransparent(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    onBack: (() -> Unit)?,
    onFavorite: (() -> Unit)?,
    scrollBehavior: TopAppBarScrollBehavior?,
    profileImageSource: AppImageSource?,
    onProfileClick: (() -> Unit)?,
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {},
        navigationIcon = {
            if (profileImageSource != null || onProfileClick != null) {
                IconButton(onClick = { onProfileClick?.invoke() }) {
                    AppImageCircular(
                        modifier = Modifier.size(PROFILE_IMAGE_SIZE),
                        source = profileImageSource,
                        contentDescription = stringResource(Res.string.action_profile)
                    )
                }
            } else if (onBack != null) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.action_back),
                        tint = backgroundColor.contrastTextColor(),
                    )
                }
            }
        },
        actions = {
            if (onFavorite != null) {
                IconButton(onClick = onFavorite) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = stringResource(Res.string.action_favorite),
                        tint = backgroundColor.contrastTextColor(),
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
        ),
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppTopBarComponentPreview() {
    DLearnTheme(darkTheme = true) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AppTopBar(
                title = "Default Top Bar",
                onBack = {}
            )

            AppTopBar(
                title = "With Subtitle",
                subtitle = "Active Now",
                onBack = {}
            )

            AppTopBar(
                title = "With Menu",
                onMenuClick = {}
            )

            AppTopBar(
                title = "With Search",
                onBack = {},
                onSearchValueChange = {}
            )

            AppTopBar(
                title = "User Profile",
                subtitle = "Online",
                onProfileClick = {},
                onSearchValueChange = {},
                onMenuClick = {}
            )

            AppTopBar(
                useTransparent = true,
                backgroundColor = Color.Black,
                onBack = {},
                onFavorite = {},
                onProfileClick = {}
            )
        }
    }
}
