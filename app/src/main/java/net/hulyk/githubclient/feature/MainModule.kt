package net.hulyk.githubclient.feature

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.hulyk.githubclient.di.annotation.ViewModelKey

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindBookmarkViewModel(viewModel: MainViewModel): ViewModel

}