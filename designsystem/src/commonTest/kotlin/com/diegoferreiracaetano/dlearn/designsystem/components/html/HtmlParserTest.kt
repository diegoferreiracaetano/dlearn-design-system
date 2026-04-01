package com.diegoferreiracaetano.dlearn.designsystem.components.html

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HtmlParserTest {

    private val defaultLinkColor = Color.Blue
    private val defaultHeadingColor = Color.Black
    private val h1Size = 24.sp
    private val h2Size = 20.sp
    private val h3Size = 18.sp

    private val styleConfig = HtmlStyleConfig(
        linkColor = defaultLinkColor,
        headingColor = defaultHeadingColor,
        h1Size = h1Size,
        h2Size = h2Size,
        h3Size = h3Size
    )

    @Test
    fun parse_boldTag_returnsAnnotatedStringWithBold() {
        val html = "Hello <b>World</b>"
        val result = HtmlParser.parse(html, styleConfig)

        assertEquals("Hello World", result.text)
        val spanStyle = result.spanStyles.find { it.item.fontWeight == FontWeight.Bold }
        assertTrue(spanStyle != null, "Should have bold style")
    }

    @Test
    fun parse_italicTag_returnsAnnotatedStringWithItalic() {
        val html = "Hello <i>World</i>"
        val result = HtmlParser.parse(html, styleConfig)

        assertEquals("Hello World", result.text)
        val spanStyle = result.spanStyles.find { it.item.fontStyle == FontStyle.Italic }
        assertTrue(spanStyle != null, "Should have italic style")
    }

    @Test
    fun parse_underlinedTag_returnsAnnotatedStringWithUnderline() {
        val html = "Hello <u>World</u>"
        val result = HtmlParser.parse(html, styleConfig)

        assertEquals("Hello World", result.text)
        val spanStyle = result.spanStyles.find { it.item.textDecoration == TextDecoration.Underline }
        assertTrue(spanStyle != null, "Should have underline style")
    }

    @Test
    fun parse_linkTag_returnsAnnotatedStringWithColorAndUnderline() {
        val html = "Hello <a href='url'>World</a>"
        val linkColor = Color.Red
        val result = HtmlParser.parse(html, styleConfig.copy(linkColor = linkColor))

        assertEquals("Hello World", result.text)

        val linkAnnotation = result.getLinkAnnotations(0, result.length).firstOrNull()?.item
        val style = linkAnnotation?.styles?.style

        val spanStyle = result.spanStyles.find {
            it.item.color == linkColor && it.item.textDecoration == TextDecoration.Underline
        }?.item

        val effectiveStyle = style ?: spanStyle

        assertTrue(effectiveStyle != null, "Should have link style with color and underline")
        assertEquals(linkColor, effectiveStyle.color)
        assertEquals(TextDecoration.Underline, effectiveStyle.textDecoration)
    }

    @Test
    fun parse_breakTag_returnsAnnotatedStringWithNewLine() {
        val html = "Hello<br>World"
        val result = HtmlParser.parse(html, styleConfig)

        assertEquals("Hello\nWorld", result.text)
    }

    @Test
    fun parse_nestedTags_appliesMultipleStyles() {
        val html = "<b><i>Bold Italic</i></b>"
        val result = HtmlParser.parse(html, styleConfig)

        assertEquals("Bold Italic", result.text)
        val bold = result.spanStyles.find { it.item.fontWeight == FontWeight.Bold }
        val italic = result.spanStyles.find { it.item.fontStyle == FontStyle.Italic }

        assertTrue(bold != null, "Should have bold style")
        assertTrue(italic != null, "Should have italic style")
    }

    @Test
    fun parse_h1Tag_appliesHeadingStyle() {
        val html = "<h1>Title</h1>"
        val result = HtmlParser.parse(html, styleConfig)

        assertTrue(result.text.contains("Title"))
        val h1Style = result.spanStyles.find { it.item.fontSize == h1Size }
        assertTrue(h1Style != null, "Should have H1 font size")
    }
}
