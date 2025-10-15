package com.diegoferreiracaetano.dlearn.sample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArtTrack
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Title
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.diegoferreiracaetano.dlearn.sample.components.ImageScreen
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentGalleryApp(themeViewModel: ThemeViewModel) {
    var currentDestination by remember { mutableStateOf(Destination.Overview) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val onShowSnackbar: (String, SnackbarType) -> Unit = { message, type ->
        scope.launch {
            snackbarHostState.showAppSnackBar(scope = this, message = message, type = type)
        }
    }

    AppContainer(
        snackBarHostState = snackbarHostState,
        topBar = AppTopBar(
            title = currentDestination.route,
            actions = {
                IconButton(onClick = { themeViewModel.toggleTheme() }) {
                    Icon(Icons.Default.Palette, contentDescription = "Theme")
                }
            }
        ),
        drawerContent = {
            AppDrawer(
                items = Destination.entries.map { DrawerItem(it.route, it.icon) },
                selectedRoute = currentDestination.route,
                onItemSelected = {
                    val destination = Destination.entries.find { d -> d.route == it.route }
                    if (destination != null) {
                        currentDestination = destination
                    }
                }
            )
        }
    ) {
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

@Preview
@Composable
fun ComponentGalleryAppPreview() {
    val themeViewModel = remember { ThemeViewModel() }
    DLearnTheme(darkTheme = true) {
        ComponentGalleryApp(themeViewModel)
    }
}
