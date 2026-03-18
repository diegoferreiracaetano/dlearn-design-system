package com.diegoferreiracaetano.dlearn.designsystem.components.search

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test

class AppSearchBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appSearchBar_displaysPlaceholder() {
        composeTestRule.setContent {
            DLearnTheme {
                AppSearchBar(
                    query = "",
                    onQueryChange = {},
                    onSearch = {},
                    onBackClick = {},
                    placeholder = "Search Placeholder"
                )
            }
        }

        composeTestRule.onNodeWithText("Search Placeholder").assertIsDisplayed()
    }

    @Test
    fun appSearchBar_callsOnQueryChange() {
        var queryValue = ""
        composeTestRule.setContent {
            DLearnTheme {
                AppSearchBar(
                    query = queryValue,
                    onQueryChange = { queryValue = it },
                    onSearch = {},
                    onBackClick = {}
                )
            }
        }

        composeTestRule.onNodeWithText("").performTextInput("Spider")
        assert(queryValue == "Spider")
    }
}
