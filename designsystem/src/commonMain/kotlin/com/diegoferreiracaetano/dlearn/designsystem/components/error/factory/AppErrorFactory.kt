package com.diegoferreiracaetano.dlearn.designsystem.components.error.factory

import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AppError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AuthError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NotFoundError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.ServerError

/**
 * Factory for creating [AppError] instances based on connectivity and status codes.
 * This object centralizes the logic for mapping technical error signals into user-friendly states.
 */
object AppErrorFactory {

    /**
     * Maps the provided [statusCode] and [isNetworkAvailable] status to an [AppError] implementation.
     *
     * @param statusCode The HTTP status code received from a request.
     * @param isNetworkAvailable The current network availability state.
     * @return An instance of [AppError] representing the appropriate error state.
     */
    operator fun invoke(
        statusCode: Int? = null,
        isNetworkAvailable: Boolean = true
    ): AppError {
        if (!isNetworkAvailable) return NoInternetError()

        return when (statusCode) {
            401, 403 -> AuthError()
            404 -> NotFoundError()
            in 500..599 -> ServerError()
            else -> GenericError()
        }
    }
}
