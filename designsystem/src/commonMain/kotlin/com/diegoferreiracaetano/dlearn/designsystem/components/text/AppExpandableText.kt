package com.diegoferreiracaetano.dlearn.designsystem.components.text

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_less
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_more
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

object AppExpandableTextTags {
    const val TEXT_CONTAINER = "AppExpandableText_Container"
}

/**
 * A text component that truncates long text and provides a "More" link to expand it.
 *
 * @param text The full text to be displayed.
 * @param modifier The modifier to be applied to the layout.
 * @param maxLines The maximum number of lines to show when collapsed.
 * @param expandText The [StringResource] to show for the expansion link.
 * @param expandTextColor The color of the expansion link.
 * @param collapseText The [StringResource] to show for the collapse link.
 * @param collapseTextColor The color of the collapse link.
 * @param textAlign The alignment of the text.
 * @param testTag Optional tag for testing identification.
 */
@Composable
fun AppExpandableText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 3,
    expandText: StringResource = Res.string.action_more,
    expandTextColor: Color = MaterialTheme.colorScheme.primary,
    collapseText: StringResource = Res.string.action_less,
    collapseTextColor: Color = MaterialTheme.colorScheme.primary,
    textAlign: TextAlign = TextAlign.Start,
    testTag: String = AppExpandableTextTags.TEXT_CONTAINER
) {
    val expandTextString = " " + stringResource(expandText)
    val collapseTextString = " " + stringResource(collapseText)
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableStateOf(0) }

    Box(modifier = modifier
        .fillMaxWidth()
        .animateContentSize()
        .clickable(enabled = clickable) {
            isExpanded = !isExpanded
        }
        .testTag(testTag)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = buildAnnotatedString {
                if (clickable && !isExpanded) {
                    if (lastCharIndex > 0) {
                        val adjustedText = text
                            .substring(0, lastCharIndex)
                            .dropLast(expandTextString.length + 3) // +3 for "..."
                            .dropLastWhile { it.isWhitespace() || it == '.' }
                        
                        append(adjustedText)
                        append("...")
                        withStyle(
                            style = SpanStyle(
                                color = expandTextColor,
                                fontWeight = FontWeight.SemiBold
                            )
                        ) {
                            append(expandTextString)
                        }
                    } else {
                        append(text)
                    }
                } else if (clickable && isExpanded) {
                    append(text)
                    withStyle(
                        style = SpanStyle(
                            color = collapseTextColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append(collapseTextString)
                    }
                } else {
                    append(text)
                }
            },
            maxLines = if (isExpanded) Int.MAX_VALUE else maxLines,
            onTextLayout = { textLayoutResult: TextLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = textLayoutResult.getLineEnd(maxLines - 1)
                }
            },
            style = MaterialTheme.typography.bodyMedium,
            textAlign = textAlign,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview
@Composable
fun AppExpandableTextPreview() {
    DLearnTheme {
        AppExpandableText(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        )
    }
}
