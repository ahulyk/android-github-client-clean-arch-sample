package net.hulyk.githubclient.di

import com.toastme.di.annotation.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.hulyk.githubclient.feature.MainActivity
import net.hulyk.githubclient.feature.MainModule

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

}