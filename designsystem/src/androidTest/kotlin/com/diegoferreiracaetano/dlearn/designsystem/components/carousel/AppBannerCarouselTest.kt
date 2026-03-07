package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class AppBannerCarouselTest {

    @Test
    fun appBannerCarousel_displaysTitleAndBannerContent() = runComposeUiTest {
        val title = "Highlights"
        val banners = listOf("Banner One", "Banner Two")

        setContent {
            AppBannerCarousel(
                title = title,
                itemCount = banners.size,
            ) { index ->
                BannerCard(
                    title = banners[index],
                    subtitle = "Subtitle",
                    onClick = {},
                )
            }
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText("Banner One").assertExists()
    }
}
