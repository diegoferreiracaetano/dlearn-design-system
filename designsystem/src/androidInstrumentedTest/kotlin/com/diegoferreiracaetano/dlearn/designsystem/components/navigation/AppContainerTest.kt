package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

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
    fun shouldDisplaySearchBarWhenProvided() = runComposeUiTest {
        val searchBarText = "Search Bar"
        setContent {
            AppContainer(
                searchBar = { Text(text = searchBarText) }
            ) {
                Text(text = "Content")
            }
        }

        onNodeWithText(searchBarText).assertIsDisplayed()
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
}
