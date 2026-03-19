package com.diegoferreiracaetano.dlearn.designsystem.components.error.factory

import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AppErrorData
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AuthError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NotFoundError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.ServerError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.ServiceUnavailableError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.TimeoutError

object AppErrorFactory {

    private const val HTTP_UNAUTHORIZED = 401
    private const val HTTP_FORBIDDEN = 403
    private const val HTTP_NOT_FOUND = 404
    private const val HTTP_TIMEOUT = 408
    private const val HTTP_INTERNAL_SERVER_ERROR = 500
    private const val HTTP_GATEWAY_TIMEOUT = 504
    private const val HTTP_SERVICE_UNAVAILABLE = 503

    private const val MSG_UNAUTHORIZED = "unauthorized"
    private const val MSG_NOT_FOUND = "not found"
    private const val MSG_SERVICE_UNAVAILABLE = "service unavailable"
    private const val MSG_INDISPONIVEL = "indisponível"
    private const val MSG_CONNECT_EXCEPTION = "ConnectException"
    private const val MSG_SERVER_ERROR = "server error"
    private const val MSG_TIMEOUT = "timeout"
    private const val MSG_TIMED_OUT = "timed out"

    operator fun invoke(
        throwable: Throwable? = null,
        isNetworkAvailable: Boolean = true
    ): AppErrorData {
        if (!isNetworkAvailable) return NoInternetError()

        val errorText = throwable?.let { "${it::class.simpleName} ${it.message}" } ?: ""
        val statusCode = extractStatusCode(errorText)

        return when {
            isAuthError(statusCode, errorText) -> AuthError()
            isNotFoundError(statusCode, errorText) -> NotFoundError()
            isServiceUnavailableError(statusCode, errorText) -> ServiceUnavailableError()
            isServerError(statusCode, errorText) -> ServerError()
            isTimeoutError(statusCode, errorText) -> TimeoutError()
            else -> GenericError()
        }
    }

    private fun isAuthError(statusCode: Int?, text: String) =
        statusCode in HTTP_UNAUTHORIZED..HTTP_FORBIDDEN || text.contains(MSG_UNAUTHORIZED, ignoreCase = true)

    private fun isNotFoundError(statusCode: Int?, text: String) =
        statusCode == HTTP_NOT_FOUND || text.contains(MSG_NOT_FOUND, ignoreCase = true)

    private fun isServiceUnavailableError(statusCode: Int?, text: String) =
        statusCode == HTTP_SERVICE_UNAVAILABLE ||
                text.contains(MSG_SERVICE_UNAVAILABLE, ignoreCase = true) ||
                text.contains(MSG_INDISPONIVEL, ignoreCase = true) ||
                text.contains(MSG_CONNECT_EXCEPTION, ignoreCase = true)

    private fun isServerError(statusCode: Int?, text: String) =
        statusCode in HTTP_INTERNAL_SERVER_ERROR..HTTP_GATEWAY_TIMEOUT || text.contains(MSG_SERVER_ERROR, ignoreCase = true)

    private fun isTimeoutError(statusCode: Int?, text: String) =
        statusCode == HTTP_TIMEOUT || text.contains(MSG_TIMEOUT, ignoreCase = true) || text.contains(MSG_TIMED_OUT, ignoreCase = true)

    private fun extractStatusCode(text: String): Int? {
        return Regex("(\\d{3})").find(text)?.value?.toIntOrNull()
    }
}
