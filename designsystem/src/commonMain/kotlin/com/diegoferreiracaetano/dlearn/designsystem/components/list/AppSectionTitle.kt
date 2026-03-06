package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

private val SectionTitlePaddingTop = 32.dp
private val SectionTitlePaddingBottom = 8.dp

/**
 * A title component for sections within a list or settings screen.
 *
 * @param title The [StringResource] for the title text.
 * @param modifier The [Modifier] to be applied to the title.
 */
@Composable
fun AppSectionTitle(
    title: StringResource,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(title),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = SectionTitlePaddingTop, bottom = SectionTitlePaddingBottom)
    )
}
