package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_auth_description
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_auth_title
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_auth
import org.jetbrains.compose.resources.StringResource

/**
 * Error state for authentication or authorization failures (HTTP 401, 403).
 */
class AuthError : AppErrorData {
    override val title: StringResource = Res.string.error_auth_title
    override val description: StringResource = Res.string.error_auth_description
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_auth)
}
