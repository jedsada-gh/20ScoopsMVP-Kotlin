package tweentyscoops.mvp.kotlin.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import tweentyscoops.mvp.kotlin.MyApplication
import tweentyscoops.mvp.kotlin.configuration.BuildConfiguration
import tweentyscoops.mvp.kotlin.configuration.Config
import javax.inject.Singleton


@Module
class AndroidModule {

    private var application: MyApplication? = null

    fun AndroidModule(application: MyApplication) {
        this.application = application
    }

    @Provides
    @Singleton
    fun provideApplicationContext() = application

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun provideConfig(): Config = BuildConfiguration("pondthaitay")
}