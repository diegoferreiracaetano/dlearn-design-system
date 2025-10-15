package com.diegoferreiracaetano.dlearn.sample

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArtTrack
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Title
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.SnackbarType
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.showAppSnackBar
import com.diegoferreiracaetano.dlearn.sample.components.ButtonsScreen
import com.diegoferreiracaetano.dlearn.sample.components.CardsScreen
import com.diegoferreiracaetano.dlearn.sample.components.ColorsScreen
import com.diegoferreiracaetano.dlearn.sample.components.FeedbackScreen
import com.diegoferreiracaetano.dlearn.sample.components.ImageScreen
import com.diegoferreiracaetano.dlearn.sample.components.NavigationScreen
import com.diegoferreiracaetano.dlearn.sample.components.OverviewScreen
import com.diegoferreiracaetano.dlearn.sample.components.TextFieldsScreen
import com.diegoferreiracaetano.dlearn.sample.components.TypographyScreen
import com.diegoferreiracaetano.dlearn.sample.previews.ThemeViewModel
import kotlinx.coroutines.launch

enum class Destination(
    val route: String,
    val icon: ImageVector,
) {
    Overview("Overview", Icons.Default.Dashboard),
    Colors("Colors", Icons.Default.Palette),
    Typography("Typography", Icons.Default.Title),
    Buttons("Buttons", Icons.Default.CheckBox),
    TextFields("TextFields", Icons.Default.TextFields),
    Cards("Cards", Icons.Default.ArtTrack),
    Feedback("Feedback", Icons.Default.Feedback),
    Image("Image", Icons.Default.Image),
    Navigation("Navigation", Icons.Default.Navigation)
}

@Composable
fun ComponentGalleryApp(themeViewModel: ThemeViewModel) {
    var currentDestination by remember { mutableStateOf(Destination.Overview) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val onNavigate: (Destination) -> Unit = {
        currentDestination = it
    }

    val onShowSnackbar: (String, SnackbarType) -> Unit = {
            message, type ->
        scope.launch {
            snackbarHostState.showAppSnackBar(scope = this, message = message, type = type)
        }
    }

    BoxWithConstraints {
        val isExpandedScreen = maxWidth > 840.dp
        MainApp(currentDestination, onNavigate, onShowSnackbar, snackbarHostState, themeViewModel, isExpandedScreen) {
            when (currentDestination) {
                Destination.Overview -> OverviewScreen()
                Destination.Colors -> ColorsScreen()
                Destination.Typography -> TypographyScreen()
                Destination.Buttons -> ButtonsScreen()
                Destination.TextFields -> TextFieldsScreen()
                Destination.Cards -> CardsScreen()
                Destination.Feedback -> FeedbackScreen(onShowSnackbar)
                Destination.Image -> ImageScreen()
                Destination.Navigation -> NavigationScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    currentDestination: Destination,
    onNavigate: (Destination) -> Unit,
    onShowSnackbar: (String, SnackbarType) -> Unit,
    snackbarHostState: SnackbarHostState,
    themeViewModel: ThemeViewModel,
    isExpandedScreen: Boolean,
    content: @Composable () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    if (isExpandedScreen) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(modifier = Modifier.widthIn(max = 240.dp)) {
                    NavDrawerContent(currentDestination, onNavigate)
                }
            }
        ) {
            AppScaffold(
                currentDestination = currentDestination,
                onNavigate = onNavigate,
                onShowSnackbar = onShowSnackbar,
                snackbarHostState = snackbarHostState,
                themeViewModel = themeViewModel,
                content = content
            )
        }
    } else {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    NavDrawerContent(currentDestination, onNavigate) {
                        scope.launch { drawerState.close() }
                    }
                }
            }
        ) {
            AppScaffold(
                currentDestination = currentDestination,
                onNavigate = onNavigate,
                onShowSnackbar = onShowSnackbar,
                snackbarHostState = snackbarHostState,
                themeViewModel = themeViewModel,
                content = content,
                onMenuClick = {
                    scope.launch { drawerState.open() }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    currentDestination: Destination,
    onNavigate: (Destination) -> Unit,
    onShowSnackbar: (String, SnackbarType) -> Unit,
    snackbarHostState: SnackbarHostState,
    themeViewModel: ThemeViewModel,
    onMenuClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentDestination.route) },
                navigationIcon = {
                    if(onMenuClick != null){
                        IconButton(onClick = onMenuClick) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { themeViewModel.toggleTheme() }) {
                        Icon(Icons.Default.Palette, contentDescription = "Theme")
                    }
                }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {
        Row(modifier = Modifier.padding(it)) {
            content()
        }
    }
}


@Composable
private fun NavDrawerContent(
    currentDestination: Destination,
    onNavigate: (Destination) -> Unit,
    onDrawerClose: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Destination.entries.forEach { destination ->
            NavigationDrawerItem(
                label = { Text(destination.route) },
                icon = { Icon(destination.icon, contentDescription = null) },
                selected = destination == currentDestination,
                onClick = {
                    onNavigate(destination)
                    onDrawerClose?.invoke()
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}
