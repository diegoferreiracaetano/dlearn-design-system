package com.diegoferreiracaetano.dlearn.designsystem.components.html

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HtmlParserTest {

    @Test
    fun parse_boldTag_returnsAnnotatedStringWithBold() {
        val html = "Hello <b>World</b>"
        val result = HtmlParser.parse(html, Color.Blue)

        assertEquals("Hello World", result.text)
        val spanStyle = result.spanStyles.find { it.item.fontWeight == FontWeight.Bold }
        assertTrue(spanStyle != null, "Should have bold style")
    }

    @Test
    fun parse_italicTag_returnsAnnotatedStringWithItalic() {
        val html = "Hello <i>World</i>"
        val result = HtmlParser.parse(html, Color.Blue)

        assertEquals("Hello World", result.text)
        val spanStyle = result.spanStyles.find { it.item.fontStyle == FontStyle.Italic }
        assertTrue(spanStyle != null, "Should have italic style")
    }

    @Test
    fun parse_underlinedTag_returnsAnnotatedStringWithUnderline() {
        val html = "Hello <u>World</u>"
        val result = HtmlParser.parse(html, Color.Blue)

        assertEquals("Hello World", result.text)
        val spanStyle = result.spanStyles.find { it.item.textDecoration == TextDecoration.Underline }
        assertTrue(spanStyle != null, "Should have underline style")
    }

    @Test
    fun parse_linkTag_returnsAnnotatedStringWithColorAndUnderline() {
        val html = "Hello <a href='url'>World</a>"
        val linkColor = Color.Red
        val result = HtmlParser.parse(html, linkColor)

        assertEquals("Hello World", result.text)
        val spanStyle = result.spanStyles.find { it.item.color == linkColor && it.item.textDecoration == TextDecoration.Underline }
        assertTrue(spanStyle != null, "Should have link style with color and underline")
    }

    @Test
    fun parse_breakTag_returnsAnnotatedStringWithNewLine() {
        val html = "Hello<br>World"
        val result = HtmlParser.parse(html, Color.Blue)

        assertEquals("Hello\nWorld", result.text)
    }

    @Test
    fun parse_nestedTags_appliesMultipleStyles() {
        val html = "<b><i>Bold Italic</i></b>"
        val result = HtmlParser.parse(html, Color.Blue)

        assertEquals("Bold Italic", result.text)
        val bold = result.spanStyles.find { it.item.fontWeight == FontWeight.Bold }
        val italic = result.spanStyles.find { it.item.fontStyle == FontStyle.Italic }
        
        assertTrue(bold != null, "Should have bold style")
        assertTrue(italic != null, "Should have italic style")
    }
}
