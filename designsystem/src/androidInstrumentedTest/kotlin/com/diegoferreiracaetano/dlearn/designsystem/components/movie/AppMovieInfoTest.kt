package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppMovieInfoTest {

    @Test
    fun shouldDisplayFullMetadataInHorizontalLayout() = runComposeUiTest {
        setContent {
            AppMovieInfo(
                title = "Inception",
                year = "2010",
                duration = "148 min",
                contentRating = "PG-13",
                genre = "Sci-Fi",
                type = "Movie",
                isPremium = true,
                isVerticalLayout = false
            )
        }

        onNodeWithText("Inception").assertExists()
        onNodeWithText("2010").assertExists()
        onNodeWithText("148 min").assertExists()
        onNodeWithText("PG-13").assertExists()
        onNodeWithText("Sci-Fi  |  Movie").assertExists()
        // Assuming "Premium" for isPremium = true
        onNodeWithText("Premium").assertExists()
    }

    @Test
    fun shouldDisplayCompactMetadataInVerticalLayout() = runComposeUiTest {
        setContent {
            AppMovieInfo(
                title = "Inception",
                year = "2010",
                duration = "148 min",
                contentRating = "PG-13",
                genre = "Sci-Fi",
                type = "Movie",
                isPremium = true,
                isVerticalLayout = true
            )
        }

        onNodeWithText("Inception").assertExists()
        onNodeWithText("Sci-Fi  •  2010").assertExists()
    }
}
