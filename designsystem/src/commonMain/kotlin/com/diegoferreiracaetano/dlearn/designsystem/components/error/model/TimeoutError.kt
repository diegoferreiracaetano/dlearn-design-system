package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_timeout_description
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_timeout_title
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_server
import org.jetbrains.compose.resources.StringResource

/**
 * Error state for when a request times out.
 */
class TimeoutError : AppErrorData {
    override val title: StringResource = Res.string.error_timeout_title
    override val description: StringResource = Res.string.error_timeout_description
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_server)
}
