package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.movie.MovieItem
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class CarouselTest {

    private val sampleMovie = MovieItem(
        id = "1",
        title = "Item 1",
        year = "2021",
        duration = "148 min",
        contentRating = "PG-13",
        genre = "Action",
        type = "Movie",
        isPremium = true,
        imageSource = AppImageSource.Url(""),
        rating = 4.5
    )

    @Test
    fun shouldDisplayTitleAndItemsWhenRendered() = runComposeUiTest {
        val title = "Featured"
        val items = listOf(
            sampleMovie.copy(id = "1", title = "Item 1"),
            sampleMovie.copy(id = "2", title = "Item 2")
        )
        
        setContent {
            Carousel(title = title, items = items)
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText("Item 1").assertIsDisplayed()
        onNodeWithText("Item 2").assertIsDisplayed()
    }

    @Test
    fun shouldTriggerOnClickWhenItemIsClicked() = runComposeUiTest {
        var clickedItem: MovieItem? = null
        val items = listOf(
            sampleMovie.copy(title = "Clickable Item")
        )
        
        setContent {
            Carousel(
                title = "Carousel",
                items = items,
                onMovieClick = { clickedItem = it }
            )
        }

        onNodeWithText("Clickable Item").performClick()

        assertTrue(clickedItem?.title == "Clickable Item", "The onClick callback should have been triggered with the correct item")
    }
}
