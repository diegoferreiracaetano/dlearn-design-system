package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class, ExperimentalMaterial3Api::class)
class AppTopBarTest {

    @Test
    fun shouldDisplayTitleWhenProvided() = runComposeUiTest {
        val title = "Home"
        setContent {
            AppTopBar(title = title)
        }

        onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnBackWhenBackButtonIsClicked() = runComposeUiTest {
        var backClicked = false
        setContent {
            AppTopBar(onBack = { backClicked = true })
        }

        onNodeWithContentDescription("Voltar", ignoreCase = true).performClick()

        assert(backClicked)
    }

    @Test
    fun shouldTriggerOnMenuClickWhenMenuButtonIsClicked() = runComposeUiTest {
        var menuClicked = false
        setContent {
            AppTopBar(onMenuClick = { menuClicked = true })
        }

        onNodeWithContentDescription("Menu", ignoreCase = true).performClick()

        assert(menuClicked)
    }

    @Test
    fun shouldEnterSearchModeWhenSearchIconIsClicked() = runComposeUiTest {
        var searchValue = ""
        setContent {
            AppTopBar(
                onSearchValueChange = { searchValue = it },
                searchValue = searchValue
            )
        }

        // Open search
        onNodeWithContentDescription("Pesquisar", ignoreCase = true).performClick()
        
        // Type in search
        val query = "Kotlin"
        onNodeWithText("Pesquisar...", ignoreCase = true).performTextInput(query)

        assertEquals(query, searchValue)
    }
}
