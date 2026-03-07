package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.banner
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppMoviePosterTest {

    @Test
    fun shouldDisplayRating() = runComposeUiTest {
        val rating = 4.8
        setContent {
            AppMoviePoster(
                imageSource = AppImageSource.Resource(Res.drawable.banner),
                rating = rating
            )
        }

        onNodeWithText(rating.toString()).assertExists()
    }

    @Test
    fun shouldDisplayInfoBadgesWhenProvided() = runComposeUiTest {
        val primary = "New Release"
        val secondary = "Trending"
        setContent {
            AppMoviePoster(
                imageSource = AppImageSource.Resource(Res.drawable.banner),
                rating = 4.0,
                primaryInfo = primary,
                secondaryInfo = secondary
            )
        }

        onNodeWithText(primary).assertExists()
        onNodeWithText(secondary).assertExists()
    }
}
