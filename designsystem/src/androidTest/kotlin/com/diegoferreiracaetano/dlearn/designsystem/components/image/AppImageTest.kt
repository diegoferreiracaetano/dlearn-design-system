package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.placeholder
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppImageTest {

    @Test
    fun shouldDisplayImageWhenRendered() = runComposeUiTest {
        val contentDescription = "App Image"
        setContent {
            AppImage(
                source = AppImageSource.Resource(Res.drawable.placeholder),
                contentDescription = contentDescription
            )
        }

        onNodeWithContentDescription(contentDescription).assertIsDisplayed()
    }
}
