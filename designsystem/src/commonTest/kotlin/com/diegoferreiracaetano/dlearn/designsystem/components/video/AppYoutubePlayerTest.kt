package com.diegoferreiracaetano.dlearn.designsystem.components.video

import kotlin.test.Test
import kotlin.test.assertTrue

class AppYoutubePlayerUnitTest {

    @Test
    fun testVideoIdIsValid() {
        val videoId = "dQw4w9WgXcQ"
        assertTrue(videoId.isNotBlank(), "Video ID should not be blank")
        assertTrue(videoId.length >= 11, "Standard YouTube IDs are at least 11 characters")
    }
}
