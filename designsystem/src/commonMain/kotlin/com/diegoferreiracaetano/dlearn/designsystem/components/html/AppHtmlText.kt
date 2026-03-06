package com.diegoferreiracaetano.dlearn.designsystem.components.html

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * AppHtmlText is a component designed to render strings containing basic HTML tags
 * using the project's typography and color scheme.
 *
 * Supported tags:
 * - <b>, <strong>: Bold text
 * - <i>, <em>: Italic text
 * - <u>: Underlined text
 * - <s>, <strike>: Strikethrough text
 * - <a>: Colored and underlined text (links)
 * - <br>: Line break
 * - <h1>, <h2>, <h3>: Headings
 *
 * @param html The HTML string to be rendered.
 * @param modifier The [Modifier] to be applied to the text.
 * @param style The [TextStyle] to be applied as the base style.
 * @param color The base color for the text. If [Color.Unspecified], uses the default from [style].
 * @param linkColor The color to be used for <a> tags. Defaults to the theme's primary color.
 */
@Composable
fun AppHtmlText(
    html: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color: Color = Color.Unspecified,
    linkColor: Color = MaterialTheme.colorScheme.primary
) {
    val h1Size = MaterialTheme.typography.headlineLarge.fontSize
    val h2Size = MaterialTheme.typography.headlineMedium.fontSize
    val h3Size = MaterialTheme.typography.headlineSmall.fontSize

    val annotatedString = remember(html, linkColor, h1Size, h2Size, h3Size) {
        HtmlParser.parse(
            html = html,
            linkColor = linkColor,
            h1Size = h1Size,
            h2Size = h2Size,
            h3Size = h3Size
        )
    }

    Text(
        text = annotatedString,
        modifier = modifier,
        style = style,
        color = color
    )
}

internal object HtmlParser {
    fun parse(
        html: String,
        linkColor: Color,
        h1Size: TextUnit = TextUnit.Unspecified,
        h2Size: TextUnit = TextUnit.Unspecified,
        h3Size: TextUnit = TextUnit.Unspecified
    ): AnnotatedString {
        return buildAnnotatedString {
            var currentIndex = 0
            val tagRegex = Regex("<(/?[a-z1-6]+)([^>]*)>")
            
            val matches = tagRegex.findAll(html)
            val tagStack = mutableListOf<TagInfo>()

            matches.forEach { match ->
                val textBefore = html.substring(currentIndex, match.range.first)
                append(textBefore)

                val tagName = match.groupValues[1].lowercase()
                val isClosing = tagName.startsWith("/")
                val actualTagName = if (isClosing) tagName.substring(1) else tagName

                if (isClosing) {
                    val lastTag = tagStack.lastOrNull { it.name == actualTagName }
                    if (lastTag != null) {
                        // Close tag: pop all styles until this one
                        while (tagStack.isNotEmpty()) {
                            val popped = tagStack.removeAt(tagStack.size - 1)
                            pop()
                            if (popped.name == actualTagName) break
                        }
                    }
                } else {
                    if (actualTagName == "br") {
                        append("\n")
                    } else {
                        val spanStyle = when (actualTagName) {
                            "b", "strong" -> SpanStyle(fontWeight = FontWeight.Bold)
                            "i", "em" -> SpanStyle(fontStyle = FontStyle.Italic)
                            "u" -> SpanStyle(textDecoration = TextDecoration.Underline)
                            "s", "strike" -> SpanStyle(textDecoration = TextDecoration.LineThrough)
                            "a" -> SpanStyle(color = linkColor, textDecoration = TextDecoration.Underline)
                            "h1" -> SpanStyle(fontWeight = FontWeight.Bold, fontSize = h1Size)
                            "h2" -> SpanStyle(fontWeight = FontWeight.Bold, fontSize = h2Size)
                            "h3" -> SpanStyle(fontWeight = FontWeight.Bold, fontSize = h3Size)
                            else -> null
                        }
                        
                        if (spanStyle != null) {
                            pushStyle(spanStyle)
                            tagStack.add(TagInfo(actualTagName, spanStyle))
                        }
                    }
                }
                currentIndex = match.range.last + 1
            }
            
            if (currentIndex < html.length) {
                append(html.substring(currentIndex))
            }
            
            // Close any remaining tags
            repeat(tagStack.size) { pop() }
        }
    }

    private data class TagInfo(val name: String, val style: SpanStyle)
}

@Preview
@Composable
fun AppHtmlTextPreview() {
    DLearnTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AppHtmlText(
                html = "<h3>Terms</h3>" +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Eget ornare quam vel facilisis feugiat amet sagittis arcu, tortor. <br><br>" +
                        "<h3>Changes to the Service and/or Terms:</h3>" +
                        "<s><u>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Eget ornare quam vel facilisis feugiat amet sagittis arcu, tortor. Sapien, consequat ultrices morbi orci semper sit nulla.</u></s>"
            )

            AppHtmlText(
                html = "Check our <a href='https://google.com'>Privacy Policy</a> for more details.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
