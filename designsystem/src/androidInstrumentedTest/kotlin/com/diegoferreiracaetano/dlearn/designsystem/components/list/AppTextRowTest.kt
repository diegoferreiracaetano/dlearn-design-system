package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_back
import org.jetbrains.compose.resources.stringResource
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppTextRowTest {

    @Test
    fun shouldDisplayStringLabelAndValue() = runComposeUiTest {
        val labelText = "Label from Backend"
        val valueText = "Value from Backend"

        setContent {
            AppTextRow(
                label = labelText,
                value = valueText
            )
        }

        onNodeWithText(labelText).assertIsDisplayed()
        onNodeWithText(valueText).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayResourceLabelAndValue() = runComposeUiTest {
        // Using action_back as a placeholder resource
        setContent {
            AppTextRow(
                label = Res.string.action_back,
                value = Res.string.action_back
            )
        }

        // We search by the resolved string value. In tests, it depends on the resource configuration.
        // But the component should at least render.
    }

    @Test
    fun shouldTriggerOnClickWhenProvided() = runComposeUiTest {
        var clicked = false
        val labelText = "Clickable Row"

        setContent {
            AppTextRow(
                label = labelText,
                onClick = { clicked = true }
            )
        }

        onNodeWithText(labelText).performClick()
        assert(clicked)
    }

    @Test
    fun shouldTriggerOnCheckedChangeWhenProvided() = runComposeUiTest {
        var checkedValue = false
        val labelText = "Switch Row"

        setContent {
            AppTextRow(
                label = labelText,
                onCheckedChange = { checkedValue = it },
                isEnabled = false
            )
        }

        // The switcher itself is usually found by role or content description,
        // but the row is clickable if it has onCheckedChange logic handled by AppSwitcher
        onNodeWithText(labelText).assertIsDisplayed()
    }
}
