package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppListTest {

    @Test
    fun shouldDisplayContentItemsWhenRendered() = runComposeUiTest {
        val items = listOf("Item 1", "Item 2", "Item 3")
        setContent {
            AppList {
                items(items) { item ->
                    Text(text = item)
                }
            }
        }

        onNodeWithText("Item 1").assertIsDisplayed()
        onNodeWithText("Item 2").assertIsDisplayed()
        onNodeWithText("Item 3").assertIsDisplayed()
    }

    @Test
    fun shouldDisplayCollapsibleContentWhenProvided() = runComposeUiTest {
        val collapsibleText = "Header Content"
        setContent {
            AppList(
                collapsibleContent = { Text(text = collapsibleText) }
            ) {
                items(1) {
                    Text(text = "Body")
                }
            }
        }

        onNodeWithText(collapsibleText).assertIsDisplayed()
    }
}
