package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
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
        val errorMsg = "Something went wrong"
        val error = Throwable(errorMsg)
        
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
        onNodeWithText("Tentar Novamente").performClick()
        assertTrue(retryClicked, "Retry button should be clicked")
    }
}
