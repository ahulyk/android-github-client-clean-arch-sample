package net.hulyk.githubclient.domain.usecase

import net.hulyk.githubclient.domain.Result

abstract class BaseUseCase<P, R> {

    protected abstract suspend fun executeActual(parameters: P): Result<R>

    suspend operator fun invoke(parameters: P) = executeActual(parameters)

}

suspend operator fun <R> BaseUseCase<Unit, R>.invoke() = this(Unit)

suspend fun <T> apiCallToResult(call: suspend () -> T): Result<T> = try {
    Result.Success(call.invoke())
} catch (e: Exception) {
    Result.Error(e)
}