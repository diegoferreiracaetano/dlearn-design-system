package com.diegoferreiracaetano.dlearn.designsystem.components.profile

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_image_picker_camera
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_image_picker_gallery
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_image_picker_title
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.getString
import org.junit.Rule
import org.junit.Test
import kotlinx.coroutines.runBlocking
import kotlin.test.assertTrue

class AppProfileHeaderTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val testName = "Tiffany"
    private val testEmail = "tiffany@example.com"

    @Test
    fun shouldDisplayProfileInformationCorrectly() {
        composeTestRule.setContent {
            DLearnTheme {
                AppProfileHeader(
                    name = testName,
                    email = testEmail
                )
            }
        }

        composeTestRule.onNodeWithText(testName).assertIsDisplayed()
        composeTestRule.onNodeWithText(testEmail).assertIsDisplayed()
        composeTestRule.onNodeWithTag(AppProfileHeaderTags.TAG_IMAGE).assertIsDisplayed()
    }

    @Test
    fun shouldShowDialogWhenEditButtonClicked() {
        composeTestRule.setContent {
            DLearnTheme {
                AppProfileHeader(
                    name = testName,
                    email = testEmail,
                    onImagePicked = { }
                )
            }
        }

        val dialogTitle = runBlocking { getString(Res.string.profile_image_picker_title) }

        composeTestRule.onNodeWithTag(AppProfileHeaderTags.TAG_EDIT_BUTTON)
            .assertIsDisplayed()
            .performClick()

        composeTestRule.onNodeWithText(dialogTitle).assertIsDisplayed()
    }

    @Test
    fun shouldInvokeOnEditClickWhenOnImagePickedIsNull() {
        var editClicked = false
        composeTestRule.setContent {
            DLearnTheme {
                AppProfileHeader(
                    name = testName,
                    email = testEmail,
                    onEditClick = { editClicked = true },
                    onImagePicked = null
                )
            }
        }

        composeTestRule.onNodeWithTag(AppProfileHeaderTags.TAG_EDIT_BUTTON)
            .assertIsDisplayed()
            .performClick()

        assertTrue(editClicked)
    }

    @Test
    fun shouldShowPickerOptionsCorrectly() {
        composeTestRule.setContent {
            DLearnTheme {
                AppProfileHeader(
                    name = testName,
                    email = testEmail,
                    onImagePicked = { }
                )
            }
        }

        val cameraText = runBlocking { getString(Res.string.profile_image_picker_camera) }
        val galleryText = runBlocking { getString(Res.string.profile_image_picker_gallery) }

        composeTestRule.onNodeWithTag(AppProfileHeaderTags.TAG_EDIT_BUTTON).performClick()

        composeTestRule.onNodeWithText(cameraText).assertIsDisplayed()
        composeTestRule.onNodeWithText(galleryText).assertIsDisplayed()
    }

    @Test
    fun shouldNotDisplayEditButtonWhenCallbacksAreNull() {
        composeTestRule.setContent {
            DLearnTheme {
                AppProfileHeader(
                    name = testName,
                    email = testEmail,
                    onEditClick = null,
                    onImagePicked = null
                )
            }
        }

        composeTestRule.onNodeWithTag(AppProfileHeaderTags.TAG_EDIT_BUTTON).assertDoesNotExist()
    }
}
