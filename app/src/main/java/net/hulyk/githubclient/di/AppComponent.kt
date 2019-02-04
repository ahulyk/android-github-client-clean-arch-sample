package net.hulyk.githubclient.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import net.hulyk.githubclient.App
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AppModule::class,
            NetModule::class,
            JacksonModule::class,
            RepositoryModule::class,
            ActivityBuilderModule::class,
            ViewModelModule::class,
            AndroidSupportInjectionModule::class]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}