package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import kotlinx.coroutines.launch
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class, ExperimentalMaterial3Api::class)
class AppContainerTest {

    @Test
    fun shouldDisplayContentWhenRendered() = runComposeUiTest {
        val contentText = "Hello Container"
        setContent {
            AppContainer {
                Text(text = contentText)
            }
        }

        onNodeWithText(contentText).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayTopBarWhenProvided() = runComposeUiTest {
        val topBarText = "Top Bar"
        setContent {
            AppContainer(
                topBar = { Text(text = topBarText) }
            ) {
                Text(text = "Content")
            }
        }

        onNodeWithText(topBarText).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayBothTopBarAndSearchBarWhenProvided() = runComposeUiTest {
        val topBarText = "Top Bar"
        val searchBarText = "Search Bar"
        setContent {
            AppContainer(
                topBar = { Text(text = topBarText) },
                searchBar = { Text(text = searchBarText) }
            ) {
                Text(text = "Content")
            }
        }

        onNodeWithText(topBarText).assertIsDisplayed()
        onNodeWithText(searchBarText).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayChipGroupWhenProvided() = runComposeUiTest {
        val chipGroupText = "Chip Group"
        setContent {
            AppContainer(
                chipGroup = { Text(text = chipGroupText) }
            ) {
                Text(text = "Content")
            }
        }

        onNodeWithText(chipGroupText).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayTopBarSearchBarAndChipGroupWhenProvided() = runComposeUiTest {
        val topBarText = "Top Bar"
        val searchBarText = "Search Bar"
        val chipGroupText = "Chip Group"
        setContent {
            AppContainer(
                topBar = { Text(text = topBarText) },
                searchBar = { Text(text = searchBarText) },
                chipGroup = { Text(text = chipGroupText) }
            ) {
                Text(text = "Content")
            }
        }

        onNodeWithText(topBarText).assertIsDisplayed()
        onNodeWithText(searchBarText).assertIsDisplayed()
        onNodeWithText(chipGroupText).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayBottomBarWhenProvided() = runComposeUiTest {
        val bottomBarText = "Bottom Bar"
        setContent {
            AppContainer(
                bottomBar = { Text(text = bottomBarText) }
            ) {
                Text(text = "Content")
            }
        }

        onNodeWithText(bottomBarText).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayLoadingAndPreserveBarsWhenIsLoadingIsTrue() = runComposeUiTest {
        val topBarText = "Top Bar"
        val bottomBarText = "Bottom Bar"
        
        setContent {
            AppContainer(
                isLoading = true,
                topBar = { Text(text = topBarText) },
                bottomBar = { Text(text = bottomBarText) }
            ) {
                Text(text = "Content")
            }
        }
        
        // Assert Loading is visible
        onNodeWithTag("AppLoading").assertIsDisplayed()
        
        // Assert Bars are visible
        onNodeWithText(topBarText).assertIsDisplayed()
        onNodeWithText(bottomBarText).assertIsDisplayed()
        
        // Assert Content is not visible
        onNodeWithText("Content").assertDoesNotExist()
    }

    @Test
    fun shouldDisplayErrorAndPreserveBarsWhenErrorIsProvided() = runComposeUiTest {
        val topBarText = "Top Bar"
        val bottomBarText = "Bottom Bar"
        val error = GenericError()
        
        var retryClicked = false

        setContent {
            AppContainer(
                error = error,
                onRetry = { retryClicked = true },
                topBar = { Text(text = topBarText) },
                bottomBar = { Text(text = bottomBarText) }
            ) {
                Text(text = "Content")
            }
        }
        
        // Assert Bars are visible
        onNodeWithText(topBarText).assertIsDisplayed()
        onNodeWithText(bottomBarText).assertIsDisplayed()
        
        // Assert Error State is visible (by checking the retry action button and default title)
        onNodeWithText("Erro Inesperado").assertIsDisplayed() // The generic error title
        
        // Assert Content is not visible
        onNodeWithText("Content").assertDoesNotExist()

        // Perform click on Retry and verify
        onNodeWithText("Tentar Novamente", ignoreCase = true).performClick()
        assertTrue(retryClicked, "Retry button should be clicked")
    }

    @Test
    fun shouldUpdateTopBarTitleWhenBottomTabIsSelected() = runComposeUiTest {
        setContent {
            var selectedRoute by remember { mutableStateOf("home") }
            val configs = listOf(
                TopBarConfig(route = "home", title = "Página Inicial"),
                TopBarConfig(route = "search", title = "Pesquisar")
            )
            val tabs = listOf(
                AppNavigationTab("home", "Home", Icons.Filled.Home, Icons.Outlined.Home),
                AppNavigationTab("search", "Busca", Icons.Filled.Search, Icons.Outlined.Search)
            )

            AppContainer(
                topBar = { AppTopBar(configs = configs, selectedRoute = selectedRoute) },
                bottomBar = {
                    AppBottomNavigationBar(
                        items = tabs,
                        selectedRoute = selectedRoute,
                        onTabSelected = { selectedRoute = it }
                    )
                }
            ) {
                Text("Content")
            }
        }

        // Initially Home
        onNodeWithText("Página Inicial").assertIsDisplayed()

        // Click Search tab
        onNodeWithText("Busca").performClick()

        // Should update TopBar
        onNodeWithText("Pesquisar").assertIsDisplayed()
    }

    @Test
    fun shouldOpenDrawerWhenMenuIconIsClicked() = runComposeUiTest {
        val drawerText = "Drawer Content"
        setContent {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            AppContainer(
                drawerState = drawerState,
                drawerContent = {
                    Text(text = drawerText)
                }
            ) {
                Text("Content")
            }
        }

        // Drawer should be hidden initially
        onNodeWithText(drawerText).assertDoesNotExist()

        // Click Menu (AppContainer injects its own TopBar with Menu if drawerContent is provided and no topBar is given)
        onNodeWithContentDescription("Menu", ignoreCase = true).performClick()

        // Drawer should be visible
        onNodeWithText(drawerText).assertIsDisplayed()
    }
}
