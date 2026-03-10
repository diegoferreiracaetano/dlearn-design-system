package com.diegoferreiracaetano.dlearn.designsystem.components.error.factory

import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AppErrorData
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AuthError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NotFoundError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.ServerError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.TimeoutError

object AppErrorFactory {

    operator fun invoke(
        throwable: Throwable? = null,
        isNetworkAvailable: Boolean = true
    ): AppErrorData {
        if (!isNetworkAvailable) return NoInternetError()

        val message = throwable?.message ?: ""
        val statusCode = extractStatusCode(message)

        return when {
            isAuthError(statusCode, message) -> AuthError()
            isNotFoundError(statusCode, message) -> NotFoundError()
            isServerError(statusCode, message) -> ServerError()
            isTimeoutError(statusCode, message) -> TimeoutError()
            else -> GenericError()
        }
    }

    private fun isAuthError(statusCode: Int?, message: String) =
        statusCode in 401..403 || message.contains("unauthorized", ignoreCase = true)

    private fun isNotFoundError(statusCode: Int?, message: String) =
        statusCode == 404 || message.contains("not found", ignoreCase = true)

    private fun isServerError(statusCode: Int?, message: String) =
        statusCode in 500..599 || message.contains("server error", ignoreCase = true)

    private fun isTimeoutError(statusCode: Int?, message: String) =
        statusCode == 408 || message.contains("timeout", ignoreCase = true)

    private fun extractStatusCode(message: String): Int? {
        return Regex("(\\d{3})").find(message)?.value?.toIntOrNull()
    }
}
