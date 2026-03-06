package com.diegoferreiracaetano.dlearn.designsystem.components.banner

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppBannerTest {

    @Test
    fun shouldDisplayTitleAndSubtitle() = runComposeUiTest {
        val title = "Premium Member"
        val subtitle = "New movies are coming for you"

        setContent {
            AppBanner(
                title = title,
                subtitle = subtitle
            )
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(subtitle).assertIsDisplayed()
    }
}
