package tweentyscoops.mvp.kotlin

import android.app.Application
import android.os.Build
import android.os.StrictMode
import timber.log.Timber
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.di.DaggerApplicationComponent
import tweentyscoops.mvp.kotlin.di.module.AndroidModule
import tweentyscoops.mvp.kotlin.di.module.ApiModule
import tweentyscoops.mvp.kotlin.di.module.RetrofitModule

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDependenciesInjection()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())
            val threadPolicyBuilder = StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                threadPolicyBuilder.penaltyDeathOnNetwork()
            StrictMode.setThreadPolicy(threadPolicyBuilder.build())
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    private fun initDependenciesInjection() {
        appComponent = DaggerApplicationComponent.builder()
                .retrofitModule(RetrofitModule())
                .apiModule(ApiModule())
                .androidModule(AndroidModule(this))
                .build()
    }
}