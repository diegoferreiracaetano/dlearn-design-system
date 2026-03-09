package com.diegoferreiracaetano.dlearn.designsystem.components.profile

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

class AppProfileRowTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appProfileRow_displaysNameAndEmail() {
        val name = "John Doe"
        val email = "john.doe@example.com"

        composeTestRule.setContent {
            DLearnTheme {
                AppProfileRow(
                    name = name,
                    email = email
                )
            }
        }

        composeTestRule.onNodeWithText(name).assertIsDisplayed()
        composeTestRule.onNodeWithText(email).assertIsDisplayed()
    }

    @Test
    fun appProfileRow_callsOnEditClick_whenClicked() {
        var clicked = false
        val name = "John Doe"

        composeTestRule.setContent {
            DLearnTheme {
                AppProfileRow(
                    name = name,
                    email = "john.doe@example.com",
                    onEditClick = { clicked = true }
                )
            }
        }

        composeTestRule.onNodeWithTag(AppProfileRowTags.TAG_EDIT_BUTTON).performClick()
        assertTrue(clicked)
    }
}
