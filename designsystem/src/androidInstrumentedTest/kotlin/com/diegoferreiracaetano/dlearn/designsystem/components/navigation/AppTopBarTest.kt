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
import kotlin.test.assertTrue

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
    fun shouldDisplaySubtitleWhenProvided() = runComposeUiTest {
        val title = "Home"
        val subtitle = "Online"
        setContent {
            AppTopBar(title = title, subtitle = subtitle)
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(subtitle).assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnBackWhenBackButtonIsClicked() = runComposeUiTest {
        var backClicked = false
        setContent {
            AppTopBar(onBack = { backClicked = true })
        }

        onNodeWithContentDescription("Voltar", ignoreCase = true).performClick()

        assertTrue(backClicked)
    }

    @Test
    fun shouldTriggerOnMenuClickWhenMenuButtonIsClicked() = runComposeUiTest {
        var menuClicked = false
        setContent {
            AppTopBar(onMenuClick = { menuClicked = true })
        }

        onNodeWithContentDescription("Menu", ignoreCase = true).performClick()

        assertTrue(menuClicked)
    }

    @Test
    fun shouldTriggerOnProfileClickWhenProfileIconIsClicked() = runComposeUiTest {
        var profileClicked = false
        setContent {
            AppTopBar(onProfileClick = { profileClicked = true })
        }

        onNodeWithContentDescription("Perfil", ignoreCase = true).performClick()

        assertTrue(profileClicked)
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
