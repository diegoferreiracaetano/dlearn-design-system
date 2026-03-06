package com.diegoferreiracaetano.dlearn.designsystem.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.io.ByteArrayOutputStream
import java.io.InputStream

@Composable
actual fun rememberImagePickerLauncher(onImagePicked: (ByteArray) -> Unit): ImagePickerLauncher {
    val context = LocalContext.current

    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val bytes = context.contentResolver.openInputStream(it)?.use { input ->
                input.readBytes()
            }
            bytes?.let { onImagePicked(it) }
        }
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        bitmap?.let {
            val stream = ByteArrayOutputStream()
            it.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            onImagePicked(stream.toByteArray())
        }
    }

    return remember {
        object : ImagePickerLauncher {
            override fun launchCamera() {
                cameraLauncher.launch(null)
            }

            override fun launchGallery() {
                galleryLauncher.launch("image/*")
            }
        }
    }
}
