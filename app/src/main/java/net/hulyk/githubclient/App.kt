package net.hulyk.githubclient

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import net.hulyk.githubclient.di.DaggerAppComponent
import timber.log.Timber

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
//        setupRxMainThreadScheduler()
        setupTimber()
    }

//    private fun setupRxMainThreadScheduler() {
//        val asyncMainThreadScheduler = AndroidSchedulers.from(Looper.getMainLooper(), true)
//        RxAndroidPlugins.setInitMainThreadSchedulerHandler { asyncMainThreadScheduler }
//        RxAndroidPlugins.setMainThreadSchedulerHandler { asyncMainThreadScheduler }
//    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}