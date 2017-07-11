package tweentyscoops.mvp.kotlin.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class, RetrofitModule::class, ApiModule::class))
interface ApplicationComponent {

}