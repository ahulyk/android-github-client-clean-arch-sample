package net.hulyk.githubclient.di

import dagger.Module
import dagger.Provides
import net.hulyk.githubclient.repository.RepoRepository
import net.hulyk.githubclient.repository.RepoRepositoryImpl
import net.hulyk.githubclient.service.APIService
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepoRepository(apiService: APIService): RepoRepository {
        return RepoRepositoryImpl(apiService)
    }

}