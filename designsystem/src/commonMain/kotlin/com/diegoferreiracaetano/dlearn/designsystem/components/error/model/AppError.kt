package com.diegoferreiracaetano.dlearn.designsystem.components.error.model

import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_auth
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_generic
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_no_internet
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_not_found
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_error_server

/**
 * Interface representing a standardized error state in the application.
 * Each error implementation provides a title, description, and an illustrative image.
 */
interface AppError {
    /** The localized title of the error. */
    val title: String

    /** A detailed localized description of the error and potential solutions. */
    val description: String

    /** The visual representation of the error state. */
    val imageSource: AppImageSource
}

/**
 * Error state for when no internet connection is detected.
 */
class NoInternetError : AppError {
    override val title = "Sem Conexão com a Internet"
    override val description = "Por favor, verifique sua conexão com a internet e tente novamente."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_no_internet)
}

/**
 * Error state for when a requested resource is not found (HTTP 404).
 */
class NotFoundError : AppError {
    override val title = "Recurso não Encontrado"
    override val description = "O recurso que você está procurando não existe."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_not_found)
}

/**
 * Error state for authentication or authorization failures (HTTP 401, 403).
 */
class AuthError : AppError {
    override val title = "Erro de Autenticação"
    override val description = "Você não tem autorização para acessar este recurso."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_auth)
}

/**
 * Error state for internal server errors (HTTP 5xx).
 */
class ServerError : AppError {
    override val title = "Erro no Servidor"
    override val description = "Algo deu errado do nosso lado. Por favor, tente novamente mais tarde."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_server)
}

/**
 * Fallback error state for any other unexpected failures.
 */
class GenericError : AppError {
    override val title = "Erro Inesperado"
    override val description = "Ocorreu um erro inesperado. Por favor, tente novamente."
    override val imageSource = AppImageSource.Resource(Res.drawable.ic_error_generic)
}
