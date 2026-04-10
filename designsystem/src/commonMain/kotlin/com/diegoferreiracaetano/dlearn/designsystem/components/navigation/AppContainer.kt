package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.AppSnackbarHost
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChipGroup
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChipItem
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun AppScaffoldContent(
    modifier: Modifier = Modifier,
    topBar: @Composable (() -> Unit)? = null,
    searchBar: @Composable (() -> Unit)? = null,
    chipGroup: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    snackBarHostState: SnackbarHostState,
    scrollBehavior: TopAppBarScrollBehavior,
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        snackbarHost = {
            AppSnackbarHost(
                hostState = snackBarHostState
            )
        },
        topBar = {
            if (topBar != null || searchBar != null || chipGroup != null) {
                Column {
                    AnimatedContent(
                        targetState = topBar,
                        transitionSpec = { fadeIn() togetherWith fadeOut() },
                        label = "TopBarTransition"
                    ) { currentTopBar ->
                        currentTopBar?.invoke()
                    }
                    searchBar?.invoke()
                    chipGroup?.invoke()
                }
            }
        },
        bottomBar = { bottomBar?.invoke() }
    ) { innerPadding ->

        val baseModifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .consumeWindowInsets(innerPadding)
            .systemBarsPadding()
            .padding(start = 8.dp, end = 8.dp)

        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            AnimatedContent(
                targetState = content,
                transitionSpec = { fadeIn() togetherWith fadeOut() },
                label = "ContentTransition"
            ) { currentContent ->
                currentContent(baseModifier)
            }
        }
    }
}

/**
 * A root container component that provides a common layout structure including a top bar,
 * bottom bar, navigation drawer, and snackbar host. It automatically handles responsive
 * drawer behavior (modal for small screens, permanent for large screens) and centralized
 * loading/error states.
 *
 * @param modifier The [Modifier] to be applied to the container.
 * @param topBar Optional top app bar composable.
 * @param searchBar Optional search bar composable.
 * @param chipGroup Optional chip group composable.
 * @param drawerContent Optional content for the navigation drawer.
 * @param drawerState Optional state to control the drawer.
 * @param bottomBar Optional bottom navigation bar composable.
 * @param snackBarHostState The [SnackbarHostState] for managing snackbars.
 * @param scrollBehavior The [TopAppBarScrollBehavior] to coordinate with the top bar.
 * @param content The main content of the container, receiving a [Modifier] with appropriate padding and insets.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContainer(
    modifier: Modifier = Modifier,
    topBar: @Composable (() -> Unit)? = null,
    searchBar: @Composable (() -> Unit)? = null,
    chipGroup: @Composable (() -> Unit)? = null,
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    drawerState: DrawerState? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
    content: @Composable (Modifier) -> Unit
) {
    if (drawerContent != null) {
        BoxWithConstraints {
            val showPermanentDrawer = maxWidth > 600.dp

            if (showPermanentDrawer) {
                PermanentNavigationDrawer(
                    modifier = modifier,
                    drawerContent = {
                        PermanentDrawerSheet {
                            drawerContent()
                        }
                    },
                    content = {
                        AppScaffoldContent(
                            modifier = Modifier,
                            topBar = topBar,
                            searchBar = searchBar,
                            chipGroup = chipGroup,
                            bottomBar = bottomBar,
                            snackBarHostState = snackBarHostState,
                            scrollBehavior = scrollBehavior,
                            content = content
                        )
                    }
                )
            } else {
                val currentDrawerState = drawerState ?: rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                val topBarWithMenu: @Composable () -> Unit = {
                    AppTopBar(
                        onMenuClick = { scope.launch { currentDrawerState.open() } }
                    )
                }

                ModalNavigationDrawer(
                    modifier = modifier,
                    drawerState = currentDrawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            drawerContent()
                        }
                    },
                    content = {
                        AppScaffoldContent(
                            modifier = Modifier,
                            topBar = topBarWithMenu,
                            searchBar = searchBar,
                            chipGroup = chipGroup,
                            bottomBar = bottomBar,
                            snackBarHostState = snackBarHostState,
                            scrollBehavior = scrollBehavior,
                            content = content
                        )
                    }
                )
            }
        }
    } else {
        AppScaffoldContent(
            modifier = modifier,
            topBar = topBar,
            searchBar = searchBar,
            chipGroup = chipGroup,
            bottomBar = bottomBar,
            snackBarHostState = snackBarHostState,
            scrollBehavior = scrollBehavior,
            content = content
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppContainerPreview() {
    DLearnTheme(darkTheme = true) {
        AppContainer(
            topBar = { AppTopBar(title = "Home") },
            bottomBar = { AppBottomNavigationBar(items = emptyList(), selectedRoute = "", onTabSelected = {}) }
        ) { modifier ->
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Content Screen")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppContainerWithListTopBarPreview() {
    DLearnTheme(darkTheme = true) {
        var selectedRoute by remember { mutableStateOf("home") }
        val configs = listOf(
            TopBarConfig(route = "home", title = "Página Inicial"),
            TopBarConfig(route = "search", title = "Pesquisar"),
            TopBarConfig(route = "profile", title = "Meu Perfil")
        )

        val navigationTabs = listOf(
            AppNavigationTab("home", "Home", Icons.Filled.Home, Icons.Outlined.Home),
            AppNavigationTab("search", "Busca", Icons.Filled.Search, Icons.Outlined.Search),
            AppNavigationTab("profile", "Perfil", Icons.Filled.Person, Icons.Outlined.Person)
        )

        AppContainer(
            topBar = {
                AppTopBar(
                    configs = configs,
                    selectedRoute = selectedRoute
                )
            },
            bottomBar = {
                AppBottomNavigationBar(
                    selectedRoute = selectedRoute,
                    onTabSelected = { selectedRoute = it },
                    items = navigationTabs
                )
            }
        ) { modifier ->
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Conteúdo da Rota: $selectedRoute")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppContainerWithChipGroupPreview() {
    DLearnTheme(darkTheme = true) {
        AppContainer(
            topBar = { AppTopBar(title = "Movies") },
            chipGroup = {
                AppChipGroup(
                    items = listOf(
                        AppChipItem(label = "Action"),
                        AppChipItem(label = "Comedy"),
                        AppChipItem(label = "Drama")
                    ),
                    onFilterChanged = {}
                )
            }
        ) { modifier ->
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Content with Chips")
            }
        }
    }
}
