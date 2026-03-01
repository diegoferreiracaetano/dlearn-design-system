package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.dlearn_logo
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppImageTest {

    @Test
    fun shouldDisplayAppImageWhenRendered() = runComposeUiTest {
        val testTag = "AppImage"
        setContent {
            AppImage(
                imageResource = Res.drawable.dlearn_logo,
                modifier = Modifier.testTag(testTag)
            )
        }

        onNodeWithTag(testTag).assertIsDisplayed()
    }
}
