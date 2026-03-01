package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class AppDrawerTest {

    private val testItems = listOf(
        DrawerItem("Home", Icons.Default.Home),
        DrawerItem("Settings", Icons.Default.Home)
    )

    @Test
    fun shouldDisplayAllItemsWhenRendered() = runComposeUiTest {
        setContent {
            AppDrawer(
                items = testItems,
                selectedRoute = "Home",
                onItemSelected = {}
            )
        }

        onNodeWithText("Home").assertIsDisplayed()
        onNodeWithText("Settings").assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnItemSelectedWhenItemIsClicked() = runComposeUiTest {
        var selectedItem: DrawerItem? = null
        setContent {
            AppDrawer(
                items = testItems,
                selectedRoute = "Home",
                onItemSelected = { selectedItem = it }
            )
        }

        onNodeWithText("Settings").performClick()

        assertEquals(testItems[1], selectedItem)
    }
}
