package tweentyscoops.mvp.kotlin.di

import dagger.Component
import tweentyscoops.mvp.kotlin.di.module.AndroidModule
import tweentyscoops.mvp.kotlin.di.module.ApiModule
import tweentyscoops.mvp.kotlin.di.module.RetrofitModule
import tweentyscoops.mvp.kotlin.template.fragment.TemplateFragment
import tweentyscoops.mvp.kotlin.ui.listrepos.ListReposActivity
import tweentyscoops.mvp.kotlin.ui.main.MainActivity
import tweentyscoops.mvp.kotlin.template.activity.TemplateActivity
import tweentyscoops.mvp.kotlin.ui.main.fragment.MainFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class, RetrofitModule::class, ApiModule::class))
interface ApplicationComponent {
    fun inject(templateActivity: TemplateActivity)
    fun inject(templateFragment: TemplateFragment)
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(listReposActivity: ListReposActivity)
}