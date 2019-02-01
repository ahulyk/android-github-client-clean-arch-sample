package net.hulyk.githubclient.repository

import net.hulyk.githubclient.service.APIService
import net.hulyk.githubclient.service.model.RepoDto
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
        private val apiService: APIService
) : RepoRepository {

    override suspend fun getAllRepos(orgName: String) : List<RepoDto> {
        return apiService.getAllRepos(orgName).await()
    }

}