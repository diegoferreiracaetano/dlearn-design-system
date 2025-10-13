package com.diegoferreiracaetano.dlearn.designsystem.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import dlearn.designsystem.generated.resources.Res
import dlearn.designsystem.generated.resources.dlearn_logo
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CircularImage(
    resource: DrawableResource,
    contentDescription: StringResource? = null,
    modifier: Modifier = Modifier,
    maxSize: Dp = 200.dp
) {
    BoxWithConstraints(
        modifier = modifier
    ) {

        Image(
            painter = painterResource(resource),
            contentDescription = contentDescription?.let { stringResource( it) },
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .heightIn(max = maxSize)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
        )
    }
}

@Preview
@Composable
fun PreviewCircularImage() {
    DLearnTheme {
        Column {
            CircularImage(
                resource = Res.drawable.dlearn_logo,
                modifier = Modifier.weight(0.4f)
            )
        }
    }
}