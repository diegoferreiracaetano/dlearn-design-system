package com.diegoferreiracaetano.dlearn.designsystem.components.error.factory

import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AuthError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.ChallengeError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NotFoundError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.ServerError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.TimeoutError
import kotlin.test.Test
import kotlin.test.assertTrue

class AppErrorFactoryTest {

    @Test
    fun whenKtorAuthChallenge403_shouldReturnAuthError() {
        val errorMessage = """
            io.ktor.client.plugins.ClientRequestException: Client request(POST http://192.168.15.3:8081/v1/auth/challenge/resolve) invalid: 403 Forbidden. Text: "{ "success": false, "message": "Código ou tipo de desafio inválido", "validatedToken": null }"
        """.trimIndent()
        
        val error = AppErrorFactory(throwable = Throwable(errorMessage))
        assertTrue(error is AuthError, "Expected AuthError for 403, but got ${error::class.simpleName}")
    }

    @Test
    fun whenKtorAuthChallenge422_shouldReturnAuthError() {
        val errorMessage = """
            Error(message=io.ktor.client.plugins.ClientRequestException: Client request(POST http://192.168.15.3:8081/v1/auth/challenge/resolve) invalid: 422 Unprocessable Entity. Text: "{
                "success": false,
                "message": "Código ou tipo de desafio inválido",
                "validatedToken": null
            }")
        """.trimIndent()
        
        val error = AppErrorFactory(throwable = Throwable(errorMessage))
        assertTrue(error is AuthError, "Expected AuthError for 422, but got ${error::class.simpleName}")
    }

    @Test
    fun whenChallengeRequired428_shouldReturnChallengeError() {
        val errorMessage = "invalid: 428 Precondition Required"
        val error = AppErrorFactory(throwable = Throwable(errorMessage))
        assertTrue(error is ChallengeError, "Expected ChallengeError for 428, but got ${error::class.simpleName}")
    }

    @Test
    fun whenNetworkIsNotAvailable_shouldReturnNoInternetError() {
        val error = AppErrorFactory(isNetworkAvailable = false)
        assertTrue(error is NoInternetError)
    }

    @Test
    fun whenNotFound_shouldReturnNotFoundError() {
        val error = AppErrorFactory(throwable = Throwable("invalid: 404 Not Found"))
        assertTrue(error is NotFoundError)
    }

    @Test
    fun whenServerError_shouldReturnServerError() {
        val error = AppErrorFactory(throwable = Throwable("invalid: 500 Internal Server Error"))
        assertTrue(error is ServerError)
    }
}
