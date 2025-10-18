package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import platform.UIKit.UIViewController

/**
 * A Swift-friendly wrapper for the CircularImage composable.
 * This recreates the logic to accept a plain String for contentDescription.
 */
@Composable
private fun CircularImageWrapper(
    resource: DrawableResource,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier) {
        Image(
            painter = painterResource(resource),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .heightIn(max = 200.dp) // Using default max size
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
        )
    }
}

object CircularImageUIViewController {
    operator fun invoke(
        resource: DrawableResource,
        contentDescription: String? = null,
        modifier: Modifier = Modifier
    ): UIViewController {
        return ComposeUIViewController {
            CircularImageWrapper(
                resource = resource,
                contentDescription = contentDescription,
                modifier = modifier
            )
        }
    }
}
