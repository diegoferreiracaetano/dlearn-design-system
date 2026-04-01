package com.diegoferreiracaetano.dlearn.designsystem.components.html

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.navigation.AppTopBar
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
 * - <p>: Paragraph (adds spacing)
 * - <h1>, <h2>, <h3>: Headings
 *
 * @param html The HTML string to be rendered.
 * @param modifier The [Modifier] to be applied to the text.
 * @param style The [TextStyle] to be applied as the base style.
 * @param color The base color for the text. If [Color.Unspecified], uses the default from [style].
 * @param linkColor The color to be used for <a> tags. Defaults to the theme's primary color.
 * @param headingColor The color to be used for headings. Defaults to onSurface.
 * @param onLinkClick Optional callback for when a link (<a> tag) is clicked. 
 * If provided, overrides default URI handling.
 */
@Composable
fun AppHtmlText(
    html: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color: Color = Color.Unspecified,
    linkColor: Color = MaterialTheme.colorScheme.primary,
    headingColor: Color = MaterialTheme.colorScheme.onSurface,
    onLinkClick: ((String) -> Unit)? = null
) {
    val h1Size = MaterialTheme.typography.headlineLarge.fontSize
    val h2Size = MaterialTheme.typography.headlineMedium.fontSize
    val h3Size = MaterialTheme.typography.titleLarge.fontSize

    val annotatedString = remember(html, linkColor, headingColor, h1Size, h2Size, h3Size, onLinkClick) {
        HtmlParser.parse(
            html = html,
            styleConfig = HtmlStyleConfig(
                linkColor = linkColor,
                headingColor = headingColor,
                h1Size = h1Size,
                h2Size = h2Size,
                h3Size = h3Size,
                onLinkClick = onLinkClick
            )
        )
    }

    Text(
        text = annotatedString,
        modifier = modifier,
        style = style.copy(
            lineHeight = style.fontSize * 1.4
        ),
        color = color
    )
}

internal data class HtmlStyleConfig(
    val linkColor: Color,
    val headingColor: Color,
    val h1Size: TextUnit,
    val h2Size: TextUnit,
    val h3Size: TextUnit,
    val onLinkClick: ((String) -> Unit)? = null
)

internal object HtmlParser {

    private val tagRegex = Regex("<(/?)([a-zA-Z0-9]+)([^>]*)>")

    fun parse(
        html: String,
        styleConfig: HtmlStyleConfig
    ): AnnotatedString {
        return buildAnnotatedString {
            val stack = mutableListOf<String>()
            var lastIndex = 0

            tagRegex.findAll(html).forEach { match ->
                val (closingSlash, tag, attrs) = match.destructured
                val tagName = tag.lowercase()

                val text = html.substring(lastIndex, match.range.first)
                append(decodeHtml(text))

                if (closingSlash.isEmpty()) {
                    handleOpenTag(tagName, attrs, stack, styleConfig)
                } else {
                    handleCloseTag(tagName, stack)
                }

                lastIndex = match.range.last + 1
            }

            if (lastIndex < html.length) {
                append(decodeHtml(html.substring(lastIndex)))
            }

            repeat(stack.size) { pop() }
        }
    }

    private fun AnnotatedString.Builder.handleOpenTag(
        tagName: String,
        attrs: String,
        stack: MutableList<String>,
        styleConfig: HtmlStyleConfig
    ) {
        when (tagName) {
            "br" -> append("\n")
            "b", "strong" -> pushStyleAndTrack(tagName, SpanStyle(fontWeight = FontWeight.Bold), stack)
            "i", "em" -> pushStyleAndTrack(tagName, SpanStyle(fontStyle = FontStyle.Italic), stack)
            "u" -> pushStyleAndTrack(tagName, SpanStyle(textDecoration = TextDecoration.Underline), stack)
            "s", "strike" -> pushStyleAndTrack(
                tagName,
                SpanStyle(textDecoration = TextDecoration.LineThrough),
                stack
            )
            "p" -> if (length > 0) append("\n")
            "a" -> handleAnchorTag(attrs, stack, styleConfig)
            "h1" -> handleHeadingTag(tagName, styleConfig.h1Size, styleConfig.headingColor, stack)
            "h2" -> handleHeadingTag(tagName, styleConfig.h2Size, styleConfig.headingColor, stack)
            "h3" -> handleHeadingTag(tagName, styleConfig.h3Size, styleConfig.headingColor, stack)
        }
    }

    private fun AnnotatedString.Builder.handleAnchorTag(
        attrs: String,
        stack: MutableList<String>,
        styleConfig: HtmlStyleConfig
    ) {
        val href = extractHref(attrs)
        if (href != null) {
            val linkStyles = TextLinkStyles(
                style = SpanStyle(
                    color = styleConfig.linkColor,
                    textDecoration = TextDecoration.Underline
                )
            )
            val link = if (styleConfig.onLinkClick != null) {
                LinkAnnotation.Clickable(
                    tag = href,
                    styles = linkStyles,
                    linkInteractionListener = { styleConfig.onLinkClick.invoke(href) }
                )
            } else {
                LinkAnnotation.Url(
                    url = href,
                    styles = linkStyles
                )
            }
            pushLink(link)
        } else {
            pushStyle(SpanStyle(color = styleConfig.linkColor, textDecoration = TextDecoration.Underline))
        }
        stack.add("a")
    }

    private fun AnnotatedString.Builder.handleHeadingTag(
        tagName: String,
        fontSize: TextUnit,
        headingColor: Color,
        stack: MutableList<String>
    ) {
        append("\n")
        pushStyleAndTrack(
            tagName,
            SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = fontSize,
                color = headingColor
            ),
            stack
        )
    }

    private fun AnnotatedString.Builder.handleCloseTag(
        tagName: String,
        stack: MutableList<String>
    ) {
        closeTag(tagName, stack)
        if (tagName in listOf("p", "h1", "h2", "h3")) {
            append("\n")
        }
    }

    private fun AnnotatedString.Builder.pushStyleAndTrack(
        tag: String,
        style: SpanStyle,
        stack: MutableList<String>
    ) {
        pushStyle(style)
        stack.add(tag)
    }

    private fun AnnotatedString.Builder.closeTag(
        tag: String,
        stack: MutableList<String>
    ) {
        while (stack.isNotEmpty()) {
            val last = stack.removeAt(stack.lastIndex)
            pop()
            if (last == tag) break
        }
    }

    private fun extractHref(attrs: String): String? {
        val match = Regex("href\\s*=\\s*['\"](.*?)['\"]").find(attrs)
        return match?.groupValues?.get(1)
    }

    private fun decodeHtml(text: String): String {
        return text
            .replace("&nbsp;", " ")
            .replace("&amp;", "&")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
    }
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
                        "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Eget ornare quam vel facilisis feugiat amet sagittis arcu, tortor. </p>" +
                        "<h3>Changes to the Service and/or Terms:</h3>" +
                        "<p><s><u>Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Eget ornare quam vel facilisis feugiat amet sagittis arcu, tortor. " +
                        "Sapien, consequat ultrices morbi orci semper sit nulla.</u></s></p>"
            )

            AppHtmlText(
                html = "Check our <a href='https://google.com'>Privacy Policy</a> for more details.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppPrivacyPolicyPreview() {
    DLearnTheme(darkTheme = true) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = "Privacy Policy",
                    onBack = {}
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                AppHtmlText(
                    html = """
                        <h3>Terms</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Eget ornare quam vel facilisis feugiat amet sagittis arcu, tortor. Sapien, consequat ultrices morbi orci semper sit nulla. Leo auctor ut etiam est, amet aliquet ut vivamus. Odio vulputate est id tincidunt fames.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Eget ornare quam vel facilisis feugiat amet sagittis arcu, tortor. Sapien, consequat ultrices morbi orci semper sit nulla. Leo auctor ut etiam est, amet aliquet ut vivamus. Odio vulputate est id tincidunt fames.</p>
                        <h3>Changes to the Service and/or Terms:</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Eget ornare quam vel facilisis feugiat amet sagittis arcu, tortor. Sapien, consequat ultrices morbi orci semper sit nulla. Leo auctor ut etiam est, amet aliquet ut vivamus. Odio vulputate est id tincidunt fames.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Eget ornare quam vel facilisis feugiat amet sagittis arcu, tortor. Sapien, consequat ultrices morbi orci semper sit nulla. Leo auctor ut etiam est, amet aliquet ut vivamus. Odio vulputate est id tincidunt fames.</p>
                    """.trimIndent(),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
