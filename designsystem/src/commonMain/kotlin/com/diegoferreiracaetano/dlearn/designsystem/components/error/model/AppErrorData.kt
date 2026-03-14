package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import org.jetbrains.compose.resources.StringResource

/**
 * Interface representing a standardized error state in the application.
 * Each error implementation provides a title, description, and an illustrative image.
 */
interface AppErrorData {
    /** The localized title of the error. */
    val title: StringResource

    /** A detailed localized description of the error and potential solutions. */
    val description: StringResource

    /** The visual representation of the error state. */
    val imageSource: AppImageSource
}
