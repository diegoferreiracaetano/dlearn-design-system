package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.AppSnackbarHost
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun AppScaffoldContent(
    modifier: Modifier = Modifier,
    topBar: AppTopBar? = null,
    bottomBar: AppBottomNavigation? = null,
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
            topBar?.let {
                AppTopBarFactory(
                    config = it,
                    scrollBehavior = scrollBehavior
                )
            }
        },
        bottomBar = {
            bottomBar?.let {
                AppBottomNavigationBar(
                    items = it.items,
                    onTabSelected = it.onTabSelected,
                    selectedRoute = it.selectedRoute
                )
            }
        }
    ) { innerPadding ->

        val baseModifier = modifier
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
            content(baseModifier)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContainer(
    modifier: Modifier = Modifier,
    topBar: AppTopBar? = null,
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    bottomBar: AppBottomNavigation? = null,
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
    content: @Composable (Modifier) -> Unit
) {
    if (drawerContent != null) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    drawerContent()
                }
            },
            content = {
                AppScaffoldContent(
                    modifier = modifier,
                    topBar = topBar?.copy(onMenuClick = { scope.launch { drawerState.open() } }),
                    bottomBar = bottomBar,
                    snackBarHostState = snackBarHostState,
                    scrollBehavior = scrollBehavior,
                    content = content
                )
            }
        )
    } else {
        AppScaffoldContent(
            modifier = modifier,
            topBar = topBar,
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
fun AppTopBarPreview() {
    DLearnTheme(darkTheme = true) {
        AppContainer(
            topBar = AppTopBar(
                title = "Create",
                backgroundColor = MaterialTheme.colorScheme.background,
                onBack = {}
            ),
        ) {
            Text(
                text = "Container",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
