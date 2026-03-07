package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_auth

/**
 * Error state for authentication or authorization failures (HTTP 401, 403).
 */
class AuthError : AppErrorData {
    override val title = "Erro de Autenticação"
    override val description = "Você não tem autorização para acessar este recurso."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_auth)
}
