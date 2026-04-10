package com.diegoferreiracaetano.dlearn.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArtTrack
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Title
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.SnackbarType
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.showAppSnackBar
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppContainer
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppDrawer
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppTopBar
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.DrawerItem
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.sample.components.ButtonsScreen
import com.diegoferreiracaetano.dlearn.sample.components.CardsScreen
import com.diegoferreiracaetano.dlearn.sample.components.ColorsScreen
import com.diegoferreiracaetano.dlearn.sample.components.FeedbackScreen
import com.diegoferreiracaetano.dlearn.sample.components.HomeScreen
import com.diegoferreiracaetano.dlearn.sample.components.ImageScreen
import com.diegoferreiracaetano.dlearn.sample.components.ListsProfileScreen
import com.diegoferreiracaetano.dlearn.sample.components.NavigationScreen
import com.diegoferreiracaetano.dlearn.sample.components.OverviewScreen
import com.diegoferreiracaetano.dlearn.sample.components.TextFieldsScreen
import com.diegoferreiracaetano.dlearn.sample.components.TypographyScreen
import com.diegoferreiracaetano.dlearn.sample.previews.ThemeViewModel
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Destination(
    val route: String,
    val icon: ImageVector,
) {
    Home("Página Inicial", Icons.Default.Home),
    Overview("Visão Geral", Icons.Default.Dashboard),
    Colors("Cores", Icons.Default.Palette),
    Typography("Tipografia", Icons.Default.Title),
    Buttons("Botões", Icons.Default.CheckBox),
    TextFields("Campos de Texto", Icons.Default.TextFields),
    Cards("Cards & Carrosséis", Icons.Default.ArtTrack),
    Feedback("Feedback & Estados", Icons.Default.Feedback),
    Image("Imagens", Icons.Default.Image),
    ListsProfile("Listas & Perfil", Icons.Default.AccountCircle),
    Navigation("Navegação & Inputs", Icons.Default.Navigation)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DLearnCatalogApp(themeViewModel: ThemeViewModel) {
    var currentDestination by remember { mutableStateOf(Destination.Home) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val onShowSnackbar: (String, SnackbarType) -> Unit = { message, type ->
        scope.launch {
            snackbarHostState.showAppSnackBar(scope = this, message = message, type = type)
        }
    }

    AppContainer(
        snackBarHostState = snackbarHostState,
        topBar = {
            AppTopBar(
                title = currentDestination.route,
                onMenuClick = {
                    scope.launch { drawerState.open() }
                },
                onSearchClick = {
                    themeViewModel.toggleTheme()
                }
            )
        },
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                items = Destination.entries.map { DrawerItem(it.route, it.icon) },
                selectedRoute = currentDestination.route,
                onItemSelected = {
                    val destination = Destination.entries.find { d -> d.route == it.route }
                    if (destination != null) {
                        currentDestination = destination
                        scope.launch { drawerState.close() }
                    }
                }
            )
        }
    ) { modifier ->
        Box(modifier = modifier.fillMaxSize()) {
            when (currentDestination) {
                Destination.Home -> HomeScreen(onStartExploration = { currentDestination = Destination.Overview })
                Destination.Overview -> OverviewScreen()
                Destination.Colors -> ColorsScreen()
                Destination.Typography -> TypographyScreen()
                Destination.Buttons -> ButtonsScreen()
                Destination.TextFields -> TextFieldsScreen()
                Destination.Cards -> CardsScreen()
                Destination.Feedback -> FeedbackScreen(onShowSnackbar)
                Destination.Image -> ImageScreen()
                Destination.ListsProfile -> ListsProfileScreen()
                Destination.Navigation -> NavigationScreen()
            }
        }
    }
}

@Preview
@Composable
fun DLearnCatalogAppPreview() {
    val themeViewModel = remember { ThemeViewModel() }
    DLearnTheme(darkTheme = true) {
        DLearnCatalogApp(themeViewModel)
    }
}
