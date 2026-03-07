package com.diegoferreiracaetano.dlearn.designsystem.components.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diegoferreiracaetano.dlearn.designsystem.components.feedback.AppFeedback
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.search
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A component to display an empty state with an image, title, and description.
 * This component uses [AppFeedback] as its base.
 *
 * @param title The title text to display.
 * @param description The description text to display.
 * @param modifier The [Modifier] to be applied to the layout.
 * @param imageSource The source of the empty state image (URL or Resource).
 * @param primaryText Text for the primary action button.
 * @param onPrimary Callback for the primary action button.
 * @param secondaryText Text for the secondary action button.
 * @param onSecondary Callback for the secondary action button.
 */
@Composable
fun AppEmptyState(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    imageSource: AppImageSource? = null,
    primaryText: String? = null,
    onPrimary: (() -> Unit)? = null,
    secondaryText: String? = null,
    onSecondary: (() -> Unit)? = null,
) {
    AppFeedback(
        modifier = modifier,
        title = title,
        description = description,
        imageSource = imageSource,
        primaryText = primaryText,
        onPrimary = onPrimary,
        secondaryText = secondaryText,
        onSecondary = onSecondary
    )
}

@Preview
@Composable
fun AppEmptyStatePreview() {
    DLearnTheme(darkTheme = true) {
        AppEmptyState(
            title = "Ainda não há nada aqui!",
            description = "Encontre o que você procura digitando o título, categorias, etc.",
            imageSource = AppImageSource.Resource(Res.drawable.search)
        )
    }
}
