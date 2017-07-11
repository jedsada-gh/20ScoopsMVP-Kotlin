package tweentyscoops.mvp.kotlin

import android.app.Application
import timber.log.Timber
import tweentyscoops.mvp.kotlin.di.*

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        appComponent = DaggerApplicationComponent.builder()
                .androidModule(AndroidModule(this))
                .retrofitModule(RetrofitModule())
                .apiModule(ApiModule())
                .build()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    fun component(): ApplicationComponent = appComponent
}