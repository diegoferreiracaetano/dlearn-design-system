package com.diegoferreiracaetano.dlearn.designsystem.components.chip

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class AppChipGroupTest {

    @Test
    fun shouldDisplayAllChipsWhenNoFilterIsSelected() = runComposeUiTest {
        val items = listOf(
            AppChip(label = "Chip 1"),
            AppChip(label = "Chip 2")
        )
        setContent {
            AppChipGroup(items = items, onFilterChanged = {})
        }

        onNodeWithText("Chip 1").assertIsDisplayed()
        onNodeWithText("Chip 2").assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnFilterChangedWhenAFilterChipIsClicked() = runComposeUiTest {
        var selectedFilter: String? = null
        val items = listOf(
            AppChip(label = "Chip 1", isFilter = true),
            AppChip(label = "Chip 2", isFilter = true)
        )
        setContent {
            AppChipGroup(items = items, onFilterChanged = { selectedFilter = it })
        }

        onNodeWithText("Chip 1").performClick()

        assertEquals("Chip 1", selectedFilter)
    }

    @Test
    fun shouldFilterVisibleChipsWhenAFilterIsSelected() = runComposeUiTest {
        val items = listOf(
            AppChip(label = "Filter 1", isFilter = true),
            AppChip(label = "Filter 2", isFilter = true),
            AppChip(label = "Action 1", isFilter = false)
        )
        setContent {
            AppChipGroup(items = items, onFilterChanged = {})
        }

        // Select Filter 1
        onNodeWithText("Filter 1").performClick()

        // Filter 1 should be displayed
        onNodeWithText("Filter 1").assertIsDisplayed()
        // Action 1 should be displayed (isFilter = false)
        onNodeWithText("Action 1").assertIsDisplayed()
        // Filter 2 should NOT be displayed (it was filtered out)
        onNodeWithText("Filter 2").assertDoesNotExist()
    }
}
