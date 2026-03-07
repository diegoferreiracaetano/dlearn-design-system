package com.diegoferreiracaetano.dlearn.designsystem.components.error.factory

import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AppErrorData
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError

/**
 * Factory for creating [AppErrorData] instances based on connectivity and exceptions.
 * This object centralizes the logic for mapping technical error signals into user-friendly states.
 */
object AppErrorFactory {

    /**
     * Maps the provided [throwable] and [isNetworkAvailable] status to an [AppErrorData] implementation.
     *
     * @param throwable The [Throwable] caught during an operation.
     * @param isNetworkAvailable The current network availability state.
     * @return An instance of [AppErrorData] representing the appropriate error state.
     */
    operator fun invoke(
        throwable: Throwable? = null,
        isNetworkAvailable: Boolean = true
    ): AppErrorData {
        if (!isNetworkAvailable) return NoInternetError()

        // This is a placeholder for actual Throwable mapping logic.
        // In a real scenario, you might check for specific Exception types or 
        // custom properties (like status codes) within the throwable.
        return when (throwable) {
            // Example mappings if you had specific Exception types:
            // is UnauthorizedException -> AuthError()
            // is ResourceNotFoundException -> NotFoundError()
            // is InternalServerErrorException -> ServerError()
            else -> GenericError()
        }
    }
}
