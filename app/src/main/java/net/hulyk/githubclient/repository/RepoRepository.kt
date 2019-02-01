package net.hulyk.githubclient.repository

import net.hulyk.githubclient.service.model.RepoDto

interface RepoRepository {

    suspend fun getAllRepos(orgName: String): List<RepoDto>

}