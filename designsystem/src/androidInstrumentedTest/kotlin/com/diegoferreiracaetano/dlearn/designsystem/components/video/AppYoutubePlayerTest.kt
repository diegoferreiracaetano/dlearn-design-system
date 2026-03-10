package com.diegoferreiracaetano.dlearn.designsystem.components.video

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppYoutubePlayerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appYoutubePlayer_isDisplayed() {
        val videoId = "dQw4w9WgXcQ"
        val testTag = "YoutubePlayer"

        composeTestRule.setContent {
            DLearnTheme {
                AppYoutubePlayer(
                    videoId = videoId,
                    modifier = Modifier.testTag(testTag)
                )
            }
        }

        // Verify the player node exists
        composeTestRule.onNodeWithTag(testTag).assertExists()
    }
}
