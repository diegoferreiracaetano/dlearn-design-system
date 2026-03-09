package com.diegoferreiracaetano.dlearn.designsystem.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.AppDialog
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.camera
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_image_picker_camera
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_image_picker_gallery
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile_image_picker_title
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.util.rememberImagePickerLauncher
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ProfileImageSize = 120.dp
private val EditButtonSize = 40.dp
private val EditIconSize = 20.dp
private val VerticalSpacing = 8.dp
private const val DESCRIPTION_ALPHA = 0.7f

/**
 * Constants used for test tags in [AppProfileHeader].
 */
object AppProfileHeaderTags {
    const val TAG_IMAGE = "AppProfileHeader_Image"
    const val TAG_EDIT_BUTTON = "AppProfileHeader_EditButton"
    const val TAG_NAME = "AppProfileHeader_Name"
    const val TAG_EMAIL = "AppProfileHeader_Email"
}

/**
 * A profile header component that displays a large circular image with an edit button,
 * followed by the user's name and email centered.
 * This version accepts [StringResource] for name and email.
 *
 * @param name The user's name.
 * @param email The user's email or identifier.
 * @param modifier The [Modifier] to be applied to the header.
 * @param imageSource The source of the profile image (URL or Resource).
 * @param onEditClick Callback invoked when the edit button is clicked.
 * @param onImagePicked Callback invoked when a new image is selected (camera or gallery).
 */
@Composable
fun AppProfileHeader(
    name: StringResource,
    email: StringResource,
    modifier: Modifier = Modifier,
    imageSource: AppImageSource? = AppImageSource.Resource(Res.drawable.profile),
    onEditClick: (() -> Unit)? = null,
    onImagePicked: ((ByteArray) -> Unit)? = null
) {
    AppProfileHeader(
        name = stringResource(name),
        email = stringResource(email),
        modifier = modifier,
        imageSource = imageSource,
        onEditClick = onEditClick,
        onImagePicked = onImagePicked
    )
}

/**
 * A profile header component that displays a large circular image with an edit button,
 * followed by the user's name and email centered.
 * This version accepts raw [String] for name and email.
 *
 * @param name The user's name.
 * @param email The user's email or identifier.
 * @param modifier The [Modifier] to be applied to the header.
 * @param imageSource The source of the profile image (URL or Resource).
 * @param onEditClick Callback invoked when the edit button is clicked.
 * @param onImagePicked Callback invoked when a new image is selected (camera or gallery).
 */
@Composable
fun AppProfileHeader(
    name: String,
    email: String,
    modifier: Modifier = Modifier,
    imageSource: AppImageSource? = AppImageSource.Resource(Res.drawable.profile),
    onEditClick: (() -> Unit)? = null,
    onImagePicked: ((ByteArray) -> Unit)? = null
) {
    var showPickerOptions by remember { mutableStateOf(false) }
    val imagePicker = onImagePicked?.let { rememberImagePickerLauncher(it) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            AppImageCircular(
                modifier = Modifier
                    .size(ProfileImageSize)
                    .testTag(AppProfileHeaderTags.TAG_IMAGE),
                source = imageSource,
                contentDescription = null
            )

            if (onImagePicked != null || onEditClick != null) {
                Box(
                    modifier = Modifier
                        .offset(x = (-4).dp, y = (-4).dp)
                        .size(EditButtonSize)
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                        .clickable {
                            if (onImagePicked != null) {
                                showPickerOptions = true
                            } else {
                                onEditClick?.invoke()
                            }
                        }
                        .testTag(AppProfileHeaderTags.TAG_EDIT_BUTTON),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(EditIconSize)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(VerticalSpacing * 2))

        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.testTag(AppProfileHeaderTags.TAG_NAME)
        )

        Spacer(modifier = Modifier.height(VerticalSpacing))

        Text(
            text = email,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = DESCRIPTION_ALPHA),
            modifier = Modifier.testTag(AppProfileHeaderTags.TAG_EMAIL)
        )
    }

    if (showPickerOptions && imagePicker != null) {
        AppDialog(
            onDismissRequest = { showPickerOptions = false },
            title = stringResource(Res.string.profile_image_picker_title),
            confirmButtonText = stringResource(Res.string.profile_image_picker_camera),
            imageSource = AppImageSource.Resource(Res.drawable.camera),
            onConfirmClick = {
                imagePicker.launchCamera()
                showPickerOptions = false
            },
            dismissButtonText = stringResource(Res.string.profile_image_picker_gallery),
            onDismissClick = {
                imagePicker.launchGallery()
                showPickerOptions = false
            }
        )
    }
}

@Preview
@Composable
private fun AppProfileHeaderPreview() {
    DLearnTheme(darkTheme = true) {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            AppProfileHeader(
                name = "Tiffany",
                email = "Tiffanyjearsey@gmail.com",
                onImagePicked = {}
            )
        }
    }
}
