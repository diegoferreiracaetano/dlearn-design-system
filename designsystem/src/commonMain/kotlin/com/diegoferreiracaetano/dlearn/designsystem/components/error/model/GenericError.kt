package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_generic

/**
 * Fallback error state for any other unexpected failures.
 */
class GenericError : AppErrorData {
    override val title = "Erro Inesperado"
    override val description = "Ocorreu um erro inesperado. Por favor, tente novamente."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_generic)
}
