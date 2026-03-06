package com.diegoferreiracaetano.dlearn.designsystem.util

import androidx.compose.runtime.Composable

/**
 * Interface for launching image picking actions.
 */
interface ImagePickerLauncher {
    fun launchCamera()
    fun launchGallery()
}

/**
 * Remembers and provides an [ImagePickerLauncher] for the current platform.
 *
 * @param onImagePicked Callback invoked when an image is successfully selected, providing the image bytes.
 */
@Composable
expect fun rememberImagePickerLauncher(onImagePicked: (ByteArray) -> Unit): ImagePickerLauncher
