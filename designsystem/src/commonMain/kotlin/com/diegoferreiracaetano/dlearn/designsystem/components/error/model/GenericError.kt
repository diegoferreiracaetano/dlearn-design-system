package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_generic
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_generic_title
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_generic_description
import org.jetbrains.compose.resources.StringResource

/**
 * Fallback error state for any other unexpected failures.
 */
class GenericError : AppErrorData {
    override val title: StringResource = Res.string.error_generic_title
    override val description: StringResource = Res.string.error_generic_description
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_generic)
}
