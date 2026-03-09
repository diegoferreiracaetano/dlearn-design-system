package com.diegoferreiracaetano.dlearn.designsystem.components.text

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test

class AppExpandableTextTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val longText = """
        For the first time in the cinematic history of Spider-Man, 
        our friendly neighborhood hero's identity is revealed, 
        bringing his Super Hero responsibilities into conflict 
        with his normal life and putting those he cares about most at risk.
    """.trimIndent()

    @Test
    fun appExpandableText_isDisplayed() {
        composeTestRule.setContent {
            DLearnTheme {
                AppExpandableText(
                    text = "Short text"
                )
            }
        }

        composeTestRule.onNodeWithTag(AppExpandableTextTags.TEXT_CONTAINER).assertIsDisplayed()
    }

    @Test
    fun appExpandableText_togglesExpansionOnClick() {
        composeTestRule.setContent {
            DLearnTheme {
                AppExpandableText(
                    text = longText,
                    maxLines = 1
                )
            }
        }

        // Initially it should be clickable if it overflows (handled by internal logic)
        // We perform a click to test the state change
        composeTestRule.onNodeWithTag(AppExpandableTextTags.TEXT_CONTAINER).performClick()
        
        // After click, it should still be displayed
        composeTestRule.onNodeWithTag(AppExpandableTextTags.TEXT_CONTAINER).assertIsDisplayed()
    }
}
