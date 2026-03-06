package com.diegoferreiracaetano.dlearn.designsystem.components.banner

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppBannerTest {

    @Test
    fun shouldDisplayTitleAndDescription() = runComposeUiTest {
        val title = "Premium Member"
        val description = "New movies are coming for you"

        setContent {
            AppBanner(
                title = title,
                description = description
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(description).assertIsDisplayed()
    }
}
