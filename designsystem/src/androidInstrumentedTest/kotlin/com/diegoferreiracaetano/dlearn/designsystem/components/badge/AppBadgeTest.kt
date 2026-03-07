package com.diegoferreiracaetano.dlearn.designsystem.components.badge

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppBadgeTest {

    @Test
    fun ratingBadge_shouldDisplayRatingText() = runComposeUiTest {
        val rating = "4.5"
        setContent {
            AppBadge(
                text = rating,
                type = AppBadgeType.RATING
            )
        }

        onNodeWithText(rating).assertExists()
    }

    @Test
    fun tagBadge_shouldDisplayText() = runComposeUiTest {
        val tagText = "Premium"
        setContent {
            AppBadge(
                text = tagText,
                type = AppBadgeType.TAG
            )
        }

        onNodeWithText(tagText).assertExists()
    }

    @Test
    fun outlineBadge_shouldDisplayText() = runComposeUiTest {
        val ageRating = "PG-13"
        setContent {
            AppBadge(
                text = ageRating,
                type = AppBadgeType.OUTLINE
            )
        }

        onNodeWithText(ageRating).assertExists()
    }
}
