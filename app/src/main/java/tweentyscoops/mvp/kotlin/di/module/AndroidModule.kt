package tweentyscoops.mvp.kotlin.di.module

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import tweentyscoops.mvp.kotlin.MyApplication
import tweentyscoops.mvp.kotlin.configuration.BuildConfiguration
import tweentyscoops.mvp.kotlin.configuration.Config
import javax.inject.Singleton

@Module
class AndroidModule(var application: MyApplication) {

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
    fun provideSharedPreferences(): SharedPreferences =
            application.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideConfig(): Config = BuildConfiguration("pondthaitay")
}