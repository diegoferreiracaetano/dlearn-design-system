package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_placeholder
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppImageCircularTest {

    @Test
    fun shouldDisplayCircularImageWhenRendered() = runComposeUiTest {
        val contentDescription = "Circular Profile Image"
        setContent {
            AppImageCircular(
                source = AppImageSource.Resource(Res.drawable.profile_placeholder),
                contentDescription = contentDescription,
            )
        }

        onNodeWithContentDescription(contentDescription).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayPlaceholderWhenSourceIsNull() = runComposeUiTest {
        val contentDescription = "Placeholder Image"
        setContent {
            AppImageCircular(
                source = null,
                contentDescription = contentDescription,
            )
        }

        onNodeWithContentDescription(contentDescription).assertIsDisplayed()
    }
}
