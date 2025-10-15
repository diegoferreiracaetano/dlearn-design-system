package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.diegoferreiracaetano.dlearn.designsystem.util.contrastTextColor
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_back
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_favorite
import org.jetbrains.compose.resources.stringResource

data class AppTopBar(
    val title: String,
    val onBack: () -> Unit = {},
    val onFavorite: () -> Unit = {},
    val onMenuClick: (() -> Unit)? = null,
    val backgroundColor: Color = Color.Unspecified,
    val useTransparent: Boolean = false,
    val navigationIcon: @Composable (() -> Unit)? = null,
    val actions: @Composable (() -> Unit)? = null
)

@OptIn(ExperimentalMaterial3Api::class)
object AppTopBarFactory {

    @Composable
    operator fun invoke(
        config: AppTopBar,
        scrollBehavior: TopAppBarScrollBehavior? = null
    ) {
        if (config.useTransparent) {
            AppTopBarTransparent(
                backgroundColor = config.backgroundColor,
                onBack = config.onBack,
                onFavorite = config.onFavorite,
                scrollBehavior = scrollBehavior,
            )
        } else {
            AppTopBarDefault(
                title = config.title,
                onBack = config.onBack,
                onMenuClick = config.onMenuClick,
                scrollBehavior = scrollBehavior,
                navigationIcon = config.navigationIcon,
                actions = config.actions
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarDefault(
    title: String,
    onBack: () -> Unit,
    onMenuClick: (() -> Unit)?,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                title,
                maxLines = 1,
                style = MaterialTheme.typography.labelLarge
            )
        },

        navigationIcon = navigationIcon ?: {
            if(onMenuClick != null) {
                IconButton(onClick = onMenuClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
            } else {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.action_back)
                    )
                }
            }
        },
        actions = { actions?.invoke() },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarTransparent(
    backgroundColor: Color,
    onBack: () -> Unit,
    onFavorite: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(Res.string.action_back),
                    tint = backgroundColor.contrastTextColor()
                )
            }
        },
        actions = {
            IconButton(onClick = onFavorite) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(Res.string.action_favorite),
                    tint = backgroundColor.contrastTextColor()
                )
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth(),
        scrollBehavior = scrollBehavior,
    )
}