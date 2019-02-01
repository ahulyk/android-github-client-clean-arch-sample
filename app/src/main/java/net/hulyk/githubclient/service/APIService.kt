package net.hulyk.githubclient.service

import io.reactivex.Single
import kotlinx.coroutines.Deferred
import net.hulyk.githubclient.service.model.RepoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("/orgs/kotlin/repos")
    fun getAllReposRx(): Single<List<RepoDto>>

    @GET("/orgs/{org}/repos")
    fun getAllRepos(@Path("org") orgName: String): Deferred<List<RepoDto>>

}

