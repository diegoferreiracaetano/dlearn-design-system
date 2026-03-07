package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_no_internet

/**
 * Error state for when no internet connection is detected.
 */
class NoInternetError : AppErrorData {
    override val title = "Sem Conexão com a Internet"
    override val description = "Por favor, verifique sua conexão com a internet e tente novamente."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_no_internet)
}
