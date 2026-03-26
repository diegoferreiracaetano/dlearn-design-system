package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_auth
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_challenge_title
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.error_challenge_description
import org.jetbrains.compose.resources.StringResource

/**
 * Error state for security challenges like OTP, Biometrics, SMS, etc. (HTTP 428).
 */
class ChallengeError : AppErrorData {
    override val title: StringResource = Res.string.error_challenge_title
    override val description: StringResource = Res.string.error_challenge_description
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_auth)
}
