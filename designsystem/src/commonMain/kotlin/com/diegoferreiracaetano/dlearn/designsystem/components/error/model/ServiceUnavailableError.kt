package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_server
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_service_unavailable_title
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_service_unavailable_description
import org.jetbrains.compose.resources.StringResource

class ServiceUnavailableError : AppErrorData {
    override val title: StringResource = Res.string.error_service_unavailable_title
    override val description: StringResource = Res.string.error_service_unavailable_description
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_server)
}
