package com.diegoferreiracaetano.dlearn.designsystem.components.error.factory

import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AuthError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NotFoundError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.ServerError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.TimeoutError
import kotlin.test.Test
import kotlin.test.assertTrue

class AppErrorFactoryTest {

    @Test
    fun whenNetworkIsNotAvailable_shouldReturnNoInternetError() {
        val error = AppErrorFactory(isNetworkAvailable = false)
        assertTrue(error is NoInternetError)
    }

    @Test
    fun whenAuthErrorInRange_shouldReturnAuthError() {
        val codes = listOf(401, 402, 403)
        codes.forEach { code ->
            val error = AppErrorFactory(throwable = Throwable("$code Error"))
            assertTrue(error is AuthError, "Failed for code $code")
        }
    }

    @Test
    fun whenAuthErrorByMessage_shouldReturnAuthError() {
        val error = AppErrorFactory(throwable = Throwable("Unauthorized access"))
        assertTrue(error is AuthError)
    }

    @Test
    fun whenNotFound_shouldReturnNotFoundError() {
        val error = AppErrorFactory(throwable = Throwable("404 Not Found"))
        assertTrue(error is NotFoundError)
    }

    @Test
    fun whenServerErrorInRange_shouldReturnServerError() {
        val codes = listOf(500, 502, 504, 599)
        codes.forEach { code ->
            val error = AppErrorFactory(throwable = Throwable("$code Internal Error"))
            assertTrue(error is ServerError, "Failed for code $code")
        }
    }

    @Test
    fun whenTimeoutByCode_shouldReturnTimeoutError() {
        val error = AppErrorFactory(throwable = Throwable("408 Request Timeout"))
        assertTrue(error is TimeoutError)
    }

    @Test
    fun whenTimeoutByMessage_shouldReturnTimeoutError() {
        val error = AppErrorFactory(throwable = Throwable("Connection timed out"))
        assertTrue(error is TimeoutError)
    }

    @Test
    fun whenGenericThrowable_shouldReturnGenericError() {
        val error = AppErrorFactory(throwable = Throwable("Some random error"))
        assertTrue(error is GenericError)
    }

    @Test
    fun whenThrowableIsNull_shouldReturnGenericError() {
        val error = AppErrorFactory(throwable = null)
        assertTrue(error is GenericError)
    }
}
