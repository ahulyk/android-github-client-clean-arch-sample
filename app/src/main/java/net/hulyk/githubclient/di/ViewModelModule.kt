package net.hulyk.githubclient.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import net.hulyk.githubclient.viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}