package tweentyscoops.mvp.kotlin.di

import dagger.Component
import tweentyscoops.mvp.kotlin.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class, RetrofitModule::class, ApiModule::class))
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}