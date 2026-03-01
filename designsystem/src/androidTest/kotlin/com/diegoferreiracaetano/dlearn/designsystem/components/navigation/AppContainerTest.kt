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
