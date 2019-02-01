package net.hulyk.githubclient.domain.base

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T> {

    data class Success<T>(val data: T) : Result<T>()
    data class NetworkError(val exception: Throwable) : Result<Nothing>()
    data class Error(val exception: Throwable) : Result<Nothing>()

}