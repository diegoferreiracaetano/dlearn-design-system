package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_back
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_close
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_favorite
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_menu
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_profile
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_search
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.util.contrastTextColor
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val MAX_TITLE_LINES = 1
private val PROFILE_IMAGE_SIZE = 32.dp

/**
 * Configuration for the TopBar that can be dynamically applied.
 *
 * @property route The route identifier for this configuration.
 * @property title The title to display in the TopBar.
 * @property subtitle The optional subtitle to display.
 * @property onBack Optional callback for back navigation.
 * @property onClose Optional callback for close navigation.
 * @property onFavorite Optional callback for favorite action.
 * @property onMenuClick Optional callback for menu action.
 * @property onSearchClick Optional callback for search action.
 * @property useTransparent Whether to use the transparent style.
 * @property backgroundColor The background color used for contrast in transparent mode.
 * @property profileImageSource The source of the profile image (URL or Resource).
 * @property onProfileClick Optional callback for profile action.
 */
data class TopBarConfig(
    val route: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val onBack: (() -> Unit)? = null,
    val onClose: (() -> Unit)? = null,
    val onFavorite: (() -> Unit)? = null,
    val onMenuClick: (() -> Unit)? = null,
    val onSearchClick: (() -> Unit)? = null,
    val useTransparent: Boolean = false,
    val backgroundColor: Color = Color.Unspecified,
    val profileImageSource: AppImageSource? = null,
    val onProfileClick: (() -> Unit)? = null,
)

/**
 * A custom [TopAppBar] that can switch between a default and a transparent style.
 * It supports a title, subtitle, back button, close button, favorite button, menu button, and actions.
 *
 * @param modifier The [Modifier] to be applied to the top bar.
 * @param title The title text to be displayed.
 * @param subtitle The subtitle text to be displayed below the title.
 * @param onBack Callback for the back navigation icon.
 * @param onClose Callback for the close navigation icon.
 * @param onFavorite Callback for the favorite action icon.
 * @param onMenuClick Callback for the menu navigation icon.
 * @param onSearchClick Callback when the search icon is clicked.
 * @param backgroundColor The background color used for contrast in transparent mode.
 * @param useTransparent Whether to use the transparent style.
 * @param scrollBehavior The [TopAppBarScrollBehavior] to use.
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
    onClose: (() -> Unit)? = null,
    onFavorite: (() -> Unit)? = null,
    onMenuClick: (() -> Unit)? = null,
    onSearchClick: (() -> Unit)? = null,
    backgroundColor: Color = Color.Unspecified,
    useTransparent: Boolean = false,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    profileImageSource: AppImageSource? = null,
    onProfileClick: (() -> Unit)? = null,
) {
    if (useTransparent) {
        AppTopBarTransparent(
            modifier = modifier,
            backgroundColor = backgroundColor,
            onBack = onBack,
            onClose = onClose,
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
            onClose = onClose,
            onMenuClick = onMenuClick,
            onSearchClick = onSearchClick,
            scrollBehavior = scrollBehavior,
            profileImageSource = profileImageSource,
            onProfileClick = onProfileClick,
        )
    }
}

/**
 * A custom [TopAppBar] that uses a [TopBarConfig] to determine its state.
 *
 * @param config The [TopBarConfig] to use.
 * @param modifier The [Modifier] to be applied to the top bar.
 * @param scrollBehavior The [TopAppBarScrollBehavior] to use.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    config: TopBarConfig,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    AppTopBar(
        modifier = modifier,
        title = config.title,
        subtitle = config.subtitle,
        onBack = config.onBack,
        onClose = config.onClose,
        onFavorite = config.onFavorite,
        onMenuClick = config.onMenuClick,
        onSearchClick = config.onSearchClick,
        backgroundColor = config.backgroundColor,
        useTransparent = config.useTransparent,
        scrollBehavior = scrollBehavior,
        profileImageSource = config.profileImageSource,
        onProfileClick = config.onProfileClick
    )
}

/**
 * A custom [TopAppBar] that selects the appropriate configuration from a list based on the selected route.
 *
 * @param configs The list of [TopBarConfig] to choose from.
 * @param selectedRoute The currently selected route.
 * @param modifier The [Modifier] to be applied to the top bar.
 * @param scrollBehavior The [TopAppBarScrollBehavior] to use.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    configs: List<TopBarConfig>,
    selectedRoute: String,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    val config = configs.find { it.route == selectedRoute } ?: TopBarConfig()
    AppTopBar(
        config = config,
        modifier = modifier,
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBarDefault(
    modifier: Modifier = Modifier,
    title: String?,
    subtitle: String?,
    onBack: (() -> Unit)?,
    onClose: (() -> Unit)?,
    onMenuClick: (() -> Unit)?,
    onSearchClick: (() -> Unit)?,
    scrollBehavior: TopAppBarScrollBehavior?,
    profileImageSource: AppImageSource?,
    onProfileClick: (() -> Unit)?,
) {

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
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
        },
        navigationIcon = {
            if (profileImageSource != null || onProfileClick != null) {
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
            } else if (onClose != null) {
                IconButton(onClick = onClose) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(Res.string.action_close),
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
            if (onSearchClick != null) {
                IconButton(onClick = onSearchClick) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(Res.string.action_search),
                    )
                }
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
    onClose: (() -> Unit)?,
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
            } else if (onClose != null) {
                IconButton(onClick = onClose) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(Res.string.action_close),
                        tint = backgroundColor.contrastTextColor(),
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
                title = "With Close",
                onClose = {}
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
            )

            AppTopBar(
                title = "User Profile",
                subtitle = "Online",
                onProfileClick = {},
                onSearchClick = {},
                onMenuClick = {}
            )

            AppTopBar(
                useTransparent = true,
                backgroundColor = Color.Black,
                onBack = {},
                onFavorite = {},
                onProfileClick = {}
            )

            AppTopBar(
                configs = listOf(
                    TopBarConfig(route = "home", title = "Home"),
                    TopBarConfig(route = "favorites", title = "Favorites")
                ),
                selectedRoute = "home"
            )
        }
    }
}
