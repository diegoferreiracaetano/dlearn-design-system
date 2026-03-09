package com.diegoferreiracaetano.dlearn.designsystem.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.profile
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ContentSpacing = 16.dp
private val ProfileImageSize = 64.dp
private val ActionBoxSize = 40.dp
private val ActionIconSize = 20.dp
private const val ACTION_BACKGROUND_ALPHA = 0.1f
private const val CONTAINER_BACKGROUND_ALPHA = 0.3f
private const val DESCRIPTION_ALPHA = 0.7f

/**
 * Constants used for test tags in [AppProfileRow].
 */
object AppProfileRowTags {
    const val TAG_EDIT_BUTTON = "AppProfileRow_EditButton"
}

/**
 * A profile row component that displays user information with an image and an edit button.
 * This version accepts [StringResource] for name and email.
 *
 * @param name The user's name.
 * @param email The user's email or identifier.
 * @param modifier The [Modifier] to be applied to the row.
 * @param imageSource The source of the profile image (URL or Resource).
 * @param onEditClick Callback when the edit icon is clicked.
 */
@Composable
fun AppProfileRow(
    name: StringResource,
    email: StringResource,
    modifier: Modifier = Modifier,
    imageSource: AppImageSource? = AppImageSource.Resource(Res.drawable.profile),
    onEditClick: (() -> Unit)? = null
) {
    AppProfileRow(
        name = stringResource(name),
        email = stringResource(email),
        modifier = modifier,
        imageSource = imageSource,
        onEditClick = onEditClick
    )
}

/**
 * A profile row component that displays user information with an image and an edit button.
 * This version accepts raw [String] for name and email.
 *
 * @param name The user's name.
 * @param email The user's email or identifier.
 * @param modifier The [Modifier] to be applied to the row.
 * @param imageSource The source of the profile image (URL or Resource).
 * @param onEditClick Callback when the edit icon is clicked.
 */
@Composable
fun AppProfileRow(
    name: String,
    email: String,
    modifier: Modifier = Modifier,
    imageSource: AppImageSource? = AppImageSource.Resource(Res.drawable.profile),
    onEditClick: (() -> Unit)? = null
) {
    AppProfileRow(
        title = name,
        description = email,
        modifier = modifier,
        image = {
            AppImageCircular(
                modifier = Modifier.size(ProfileImageSize),
                source = imageSource,
                contentDescription = null
            )
        },
        action = {
            onEditClick?.let { onClick ->
                Box(
                    modifier = Modifier
                        .size(ActionBoxSize)
                        .background(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = ACTION_BACKGROUND_ALPHA),
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                        .clickable { onClick() }
                        .testTag(AppProfileRowTags.TAG_EDIT_BUTTON),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(ActionIconSize)
                    )
                }
            }
        }
    )
}

/**
 * A generic profile row component that displays user information with slots for image and action.
 *
 * @param title The title text.
 * @param description The description text.
 * @param modifier The [Modifier] to be applied to the row.
 * @param image Optional slot for the image.
 * @param action Optional slot for the action.
 * @param containerColor Optional background color.
 * @param contentColor Optional content color.
 */
@Composable
fun AppProfileRow(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    image: @Composable (RowScope.() -> Unit)? = null,
    action: @Composable (RowScope.() -> Unit)? = null,
    containerColor: Color? = null,
    contentColor: Color? = null
) {
    val finalContainerColor = containerColor ?: MaterialTheme.colorScheme.surfaceVariant.copy(alpha = CONTAINER_BACKGROUND_ALPHA)
    val finalContentColor = contentColor ?: MaterialTheme.colorScheme.onSurface

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = finalContainerColor,
            contentColor = finalContentColor
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            image?.invoke(this)

            if (image != null) {
                Spacer(modifier = Modifier.width(ContentSpacing))
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = finalContentColor
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = finalContentColor.copy(alpha = DESCRIPTION_ALPHA)
                )
            }

            action?.invoke(this)
        }
    }
}

@Preview
@Composable
private fun AppProfileRowPreview() {
    DLearnTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            AppProfileRow(
                name = "John Doe",
                email = "john.doe@example.com",
                onEditClick = {}
            )
        }
    }
}
