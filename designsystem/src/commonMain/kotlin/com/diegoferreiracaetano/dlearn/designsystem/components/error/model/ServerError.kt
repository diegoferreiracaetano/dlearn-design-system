package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_server

/**
 * Error state for internal server errors (HTTP 5xx).
 */
class ServerError : AppErrorData {
    override val title = "Erro no Servidor"
    override val description = "Algo deu errado do nosso lado. Por favor, tente novamente mais tarde."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_server)
}
