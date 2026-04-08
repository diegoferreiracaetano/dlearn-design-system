package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class FullScreenVideoTest {

    @Test
    fun shouldDisplayTitleAndSubtitleWhenRendered() = runComposeUiTest {
        val title = "Awesome Video"
        val subtitle = "Android Development"

        setContent {
            FullScreenVideo(
                title = title,
                subtitle = subtitle,
                onItemClick = {},
                onWatchClick = {},
                onAddToListClick = {}
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(subtitle).assertIsDisplayed()
    }

    @Test
    fun shouldTriggerWatchCallbackWhenWatchButtonIsClicked() = runComposeUiTest {
        var watchClicked = false

        setContent {
            FullScreenVideo(
                title = "Video",
                subtitle = "Sub",
                onItemClick = {},
                onWatchClick = { watchClicked = true },
                onAddToListClick = {}
            )
        }

        onNodeWithTag(FullScreenVideoTags.WATCH_BUTTON).assertIsDisplayed().performClick()

        assertTrue(watchClicked, "Watch callback should be triggered")
    }

    @Test
    fun shouldTriggerAddToListCallbackWhenAddButtonIsClicked() = runComposeUiTest {
        var addToListClicked = false

        setContent {
            FullScreenVideo(
                title = "Video",
                subtitle = "Sub",
                onItemClick = {},
                onWatchClick = {},
                onAddToListClick = { addToListClicked = true }
            )
        }

        onNodeWithTag(FullScreenVideoTags.ADD_TO_LIST_BUTTON).assertIsDisplayed().performClick()

        assertTrue(addToListClicked, "Add to list callback should be triggered")
    }

    @Test
    fun shouldRespectCustomTestTags() = runComposeUiTest {
        val customWatchTag = "home_banner_watch"
        val customAddTag = "home_banner_add_to_list"

        setContent {
            FullScreenVideo(
                title = "Video",
                subtitle = "Sub",
                onItemClick = {},
                onWatchClick = {},
                onAddToListClick = {},
                watchTestTag = customWatchTag,
                addToListTestTag = customAddTag,
            )
        }

        onNodeWithTag(customWatchTag).assertIsDisplayed()
        onNodeWithTag(customAddTag).assertIsDisplayed()
    }
}
