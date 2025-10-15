package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.foundation.layout.RowScope
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
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_back
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_favorite
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_menu
import com.diegoferreiracaetano.dlearn.designsystem.util.contrastTextColor
import org.jetbrains.compose.resources.stringResource

private const val MAX_TITLE_LINES = 1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onBack: (() -> Unit)? = null,
    onFavorite: (() -> Unit)? = null,
    onMenuClick: (() -> Unit)? = null,
    backgroundColor: Color = Color.Unspecified,
    useTransparent: Boolean = false,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    if (useTransparent) {
        AppTopBarTransparent(
            modifier = modifier,
            backgroundColor = backgroundColor,
            onBack = onBack,
            onFavorite = onFavorite,
            scrollBehavior = scrollBehavior,
        )
    } else {
        AppTopBarDefault(
            modifier = modifier,
            title = title,
            onBack = onBack,
            onMenuClick = onMenuClick,
            scrollBehavior = scrollBehavior,
            actions = actions,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBarDefault(
    modifier: Modifier = Modifier,
    title: String?,
    onBack: (() -> Unit)?,
    onMenuClick: (() -> Unit)?,
    scrollBehavior: TopAppBarScrollBehavior?,
    actions: @Composable RowScope.() -> Unit,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            if (title != null) {
                Text(
                    text = title,
                    maxLines = MAX_TITLE_LINES,
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        },
        navigationIcon = {
            if (onMenuClick != null) {
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
        actions = actions,
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
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {},
        navigationIcon = {
            if (onBack != null) {
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
