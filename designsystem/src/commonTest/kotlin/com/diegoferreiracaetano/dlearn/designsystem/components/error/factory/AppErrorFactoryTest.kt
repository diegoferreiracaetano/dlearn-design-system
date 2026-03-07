package com.diegoferreiracaetano.dlearn.designsystem.components.error.factory

import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.GenericError
import com.diegoferreiracaetano.dlearn.designsystem.components.error.model.NoInternetError
import kotlin.test.Test
import kotlin.test.assertTrue

class AppErrorFactoryTest {

    @Test
    fun whenNetworkIsNotAvailable_shouldReturnNoInternetError() {
        val error = AppErrorFactory(isNetworkAvailable = false)
        assertTrue(error is NoInternetError)
    }

    @Test
    fun whenThrowableIsProvided_shouldReturnGenericError() {
        val error = AppErrorFactory(throwable = Throwable("Some error"))
        assertTrue(error is GenericError)
    }

    @Test
    fun whenThrowableIsNull_shouldReturnGenericError() {
        val error = AppErrorFactory(throwable = null)
        assertTrue(error is GenericError)
    }
}
