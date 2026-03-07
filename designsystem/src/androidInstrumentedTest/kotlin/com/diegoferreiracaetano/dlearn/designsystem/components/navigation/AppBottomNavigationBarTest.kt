package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class AppBottomNavigationBarTest {

    private val testTabs = listOf(
        AppNavigationTab("home", "Home", Icons.Filled.Home, Icons.Outlined.Home),
        AppNavigationTab("search", "Search", Icons.Filled.Home, Icons.Outlined.Home)
    )

    @Test
    fun shouldDisplayAllTabsWhenRendered() = runComposeUiTest {
        setContent {
            AppBottomNavigationBar(
                items = testTabs,
                selectedRoute = "home",
                onTabSelected = {}
            )
        }

        onNodeWithText("Home").assertIsDisplayed()
        onNodeWithText("Search").assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnTabSelectedWhenNewTabIsClicked() = runComposeUiTest {
        var selectedRoute = ""
        setContent {
            AppBottomNavigationBar(
                items = testTabs,
                selectedRoute = "home",
                onTabSelected = { selectedRoute = it }
            )
        }

        onNodeWithText("Search").performClick()

        assertEquals("search", selectedRoute)
    }

    @Test
    fun shouldNotTriggerOnTabSelectedWhenAlreadySelectedTabIsClicked() = runComposeUiTest {
        var callCount = 0
        setContent {
            AppBottomNavigationBar(
                items = testTabs,
                selectedRoute = "home",
                onTabSelected = { callCount++ }
            )
        }

        onNodeWithText("Home").performClick()

        assertEquals(0, callCount)
    }
}
