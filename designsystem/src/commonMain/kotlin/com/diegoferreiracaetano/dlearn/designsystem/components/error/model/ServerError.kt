package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_server_description
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_server_title
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_server
import org.jetbrains.compose.resources.StringResource

/**
 * Error state for internal server errors (HTTP 5xx).
 */
class ServerError : AppErrorData {
    override val title: StringResource = Res.string.error_server_title
    override val description: StringResource = Res.string.error_server_description
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_server)
}
