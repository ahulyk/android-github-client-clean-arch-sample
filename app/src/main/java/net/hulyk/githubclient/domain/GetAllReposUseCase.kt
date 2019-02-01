package net.hulyk.githubclient.domain

import net.hulyk.githubclient.domain.base.BaseUseCase
import net.hulyk.githubclient.domain.base.Result
import net.hulyk.githubclient.domain.base.apiCallToResult
import net.hulyk.githubclient.repository.RepoRepository
import net.hulyk.githubclient.service.model.RepoDto
import javax.inject.Inject

class GetAllReposUseCase @Inject constructor(private val repoRepository: RepoRepository) : BaseUseCase<String, List<RepoDto>>() {

    override suspend fun executeActual(parameters: String): Result<List<RepoDto>> = apiCallToResult {
        repoRepository.getAllRepos(parameters)
    }

}