package com.diegoferreiracaetano.dlearn.designsystem.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.UIKit.UIImage
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerCameraDevice
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerSourceType
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.UIKit.UIViewController
import platform.UIKit.UIApplication
import platform.Foundation.NSData
import platform.Foundation.create
import platform.posix.memcpy
import platform.darwin.NSObject

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun rememberImagePickerLauncher(onImagePicked: (ByteArray) -> Unit): ImagePickerLauncher {
    val delegate = remember {
        object : NSObject(), UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {
            override fun imagePickerController(
                picker: UIImagePickerController,
                didFinishPickingMediaWithInfo: Map<Any?, *>
            ) {
                val image = didFinishPickingMediaWithInfo[platform.UIKit.UIImagePickerControllerOriginalImage] as? UIImage
                image?.let {
                    val data = platform.UIKit.UIImageJPEGRepresentation(it, 0.99)
                    data?.let { nsData ->
                        val bytes = ByteArray(nsData.length.toInt())
                        nsData.bytes?.let { pointer ->
                            memcpy(bytes.refTo(0), pointer, nsData.length)
                        }
                        onImagePicked(bytes)
                    }
                }
                picker.dismissViewControllerAnimated(true, null)
            }

            override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
                picker.dismissViewControllerAnimated(true, null)
            }
        }
    }

    return remember {
        object : ImagePickerLauncher {
            override fun launchCamera() {
                val picker = UIImagePickerController()
                picker.sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeCamera
                picker.delegate = delegate
                UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(picker, true, null)
            }

            override fun launchGallery() {
                val picker = UIImagePickerController()
                picker.sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypePhotoLibrary
                picker.delegate = delegate
                UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(picker, true, null)
            }
        }
    }
}

@OptIn(ExperimentalForeignApi::class)
private fun ByteArray.refTo(index: Int) = usePinned { it.addressOf(index) }
