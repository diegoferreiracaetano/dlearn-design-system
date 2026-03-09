package com.diegoferreiracaetano.dlearn.designsystem.components.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.carousel.AppCarousel
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ContentSpacing = 12.dp
private val UserImageSize = 48.dp
private const val DESCRIPTION_ALPHA = 0.7f

/**
 * A user row component typically used in lists or carousels to display name and role/description.
 * This version accepts [StringResource] for name and role.
 *
 * @param name The user's name.
 * @param role The user's role or description.
 * @param modifier The [Modifier] to be applied to the row.
 * @param imageSource The source of the profile image.
 * @param onClick Callback when the row is clicked.
 */
@Composable
fun AppUserRow(
    name: StringResource,
    role: StringResource,
    modifier: Modifier = Modifier,
    imageSource: AppImageSource? = null,
    onClick: (() -> Unit)? = null
) {
    AppUserRow(
        name = stringResource(name),
        role = stringResource(role),
        modifier = modifier,
        imageSource = imageSource,
        onClick = onClick
    )
}

/**
 * A user row component typically used in lists or carousels to display name and role/description.
 * This version accepts raw [String] for name and role.
 *
 * @param name The user's name.
 * @param role The user's role or description.
 * @param modifier The [Modifier] to be applied to the row.
 * @param imageSource The source of the profile image.
 * @param onClick Callback when the row is clicked.
 */
@Composable
fun AppUserRow(
    name: String,
    role: String,
    modifier: Modifier = Modifier,
    imageSource: AppImageSource? = null,
    onClick: (() -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
            .padding(vertical = 8.dp)
    ) {
        AppImageCircular(
            modifier = Modifier.size(UserImageSize),
            source = imageSource,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(ContentSpacing))

        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = role,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = DESCRIPTION_ALPHA)
            )
        }
    }
}

@Preview
@Composable
private fun AppUserRowPreview() {
    DLearnTheme {
        AppUserRow(
            name = "Jon Watts",
            role = "Directors",
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun AppUserRowCarouselPreview() {
    val names = listOf("Jon Watts", "Chris McKenna", "Erik Sommers")
    val roles = listOf("Directors", "Writers", "Writers")

    DLearnTheme {
        AppCarousel(
            itemCount = names.size,
            isPager = false,
            contentPadding = PaddingValues(16.dp),
            spacing = 16.dp
        ) { index ->
            AppUserRow(
                name = names[index],
                role = roles[index],
                onClick = {}
            )
        }
    }
}
