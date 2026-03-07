package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_not_found

/**
 * Error state for when a requested resource is not found (HTTP 404).
 */
class NotFoundError : AppErrorData {
    override val title = "Recurso não Encontrado"
    override val description = "O recurso que você está procurando não existe."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_not_found)
}
