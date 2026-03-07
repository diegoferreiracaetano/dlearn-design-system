package com.diegoferreiracaetano.dlearn.designsystem.components.error.factory

import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.AuthError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NotFoundError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.ServerError
import kotlin.test.Test
import kotlin.test.assertTrue

class AppErrorFactoryTest {

    @Test
    fun whenNetworkIsNotAvailable_shouldReturnNoInternetError() {
        val error = AppErrorFactory(isNetworkAvailable = false)
        assertTrue(error is NoInternetError)
    }

    @Test
    fun whenStatusCodeIs401_shouldReturnAuthError() {
        val error = AppErrorFactory(statusCode = 401)
        assertTrue(error is AuthError)
    }

    @Test
    fun whenStatusCodeIs403_shouldReturnAuthError() {
        val error = AppErrorFactory(statusCode = 403)
        assertTrue(error is AuthError)
    }

    @Test
    fun whenStatusCodeIs404_shouldReturnNotFoundError() {
        val error = AppErrorFactory(statusCode = 404)
        assertTrue(error is NotFoundError)
    }

    @Test
    fun whenStatusCodeIs500_shouldReturnServerError() {
        val error = AppErrorFactory(statusCode = 500)
        assertTrue(error is ServerError)
    }

    @Test
    fun whenStatusCodeIs503_shouldReturnServerError() {
        val error = AppErrorFactory(statusCode = 503)
        assertTrue(error is ServerError)
    }

    @Test
    fun whenStatusCodeIsUnknown_shouldReturnGenericError() {
        val error = AppErrorFactory(statusCode = 999)
        assertTrue(error is GenericError)
    }

    @Test
    fun whenStatusCodeIsNull_shouldReturnGenericError() {
        val error = AppErrorFactory(statusCode = null)
        assertTrue(error is GenericError)
    }
}
