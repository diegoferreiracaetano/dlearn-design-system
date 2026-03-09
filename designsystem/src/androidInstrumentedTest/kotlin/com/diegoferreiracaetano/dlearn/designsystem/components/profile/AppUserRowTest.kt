package com.diegoferreiracaetano.dlearn.designsystem.components.profile

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

class AppUserRowTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appUserRow_displaysNameAndRole() {
        val name = "Jon Watts"
        val role = "Directors"

        composeTestRule.setContent {
            DLearnTheme {
                AppUserRow(
                    name = name,
                    role = role
                )
            }
        }

        composeTestRule.onNodeWithText(name).assertIsDisplayed()
        composeTestRule.onNodeWithText(role).assertIsDisplayed()
    }

    @Test
    fun appUserRow_callsOnClick_whenClicked() {
        var clicked = false
        val name = "Jon Watts"

        composeTestRule.setContent {
            DLearnTheme {
                AppUserRow(
                    name = name,
                    role = "Directors",
                    onClick = { clicked = true }
                )
            }
        }

        composeTestRule.onNodeWithText(name).performClick()
        assertTrue(clicked)
    }
}
