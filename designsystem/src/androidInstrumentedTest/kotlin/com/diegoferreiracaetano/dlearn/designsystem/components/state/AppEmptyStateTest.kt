package com.diegoferreiracaetano.dlearn.designsystem.components.state

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppEmptyStateTest {

    @Test
    fun shouldDisplayTitleAndDescription() = runComposeUiTest {
        val title = "No Results"
        val description = "Try searching for something else"

        setContent {
            AppEmptyState(
                title = title,
                description = description
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(description).assertIsDisplayed()
    }
}
