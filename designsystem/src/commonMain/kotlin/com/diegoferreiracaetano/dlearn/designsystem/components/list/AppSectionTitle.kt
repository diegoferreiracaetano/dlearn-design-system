package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.app_name
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val SectionTitlePaddingTop = 32.dp
private val SectionTitlePaddingBottom = 8.dp

/**
 * A title component for sections within a list or settings screen.
 * This version accepts a [StringResource] for localized text.
 *
 * @param title The [StringResource] for the title text.
 * @param modifier The [Modifier] to be applied to the title.
 */
@Composable
fun AppSectionTitle(
    title: StringResource,
    modifier: Modifier = Modifier,
) {
    AppSectionTitle(
        title = stringResource(title),
        modifier = modifier,
    )
}

/**
 * A title component for sections within a list or settings screen.
 * This version accepts a raw [String].
 *
 * @param title The string for the title text.
 * @param modifier The [Modifier] to be applied to the title.
 */
@Composable
fun AppSectionTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = SectionTitlePaddingTop, bottom = SectionTitlePaddingBottom),
    )
}

@Preview(showBackground = true)
@Composable
fun AppSectionTitlePreview() {
    DLearnTheme {
        AppSectionTitle(title = "Section Title")
    }
}

@Preview(showBackground = true)
@Composable
fun AppSectionTitleResourcePreview() {
    DLearnTheme {
        AppSectionTitle(title = Res.string.app_name)
    }
}
