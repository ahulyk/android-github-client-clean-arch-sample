package net.hulyk.githubclient.di

import android.content.Context
import dagger.Binds
import dagger.Module
import net.hulyk.githubclient.App
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindContext(context: App): Context

}