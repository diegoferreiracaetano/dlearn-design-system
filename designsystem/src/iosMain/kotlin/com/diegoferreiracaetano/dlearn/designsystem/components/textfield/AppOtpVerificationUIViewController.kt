package com.diegoferreiracaetano.dlearn.designsystem.components.textfield

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

object AppOtpVerificationUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier,
        otpText: String,
        otpCount: Int = 6,
        isError: Boolean = false,
        errorText: String? = null,
        onOtpTextChange: (text: String, isComplete: Boolean) -> Unit,
        onResendClick: () -> Unit
    ): UIViewController {
        return ComposeUIViewController {
            AppOtpVerification(
                modifier = modifier,
                otpText = otpText,
                otpCount = otpCount,
                isError = isError,
                errorText = errorText,
                onOtpTextChange = onOtpTextChange,
                onResendClick = onResendClick
            )
        }
    }
}
