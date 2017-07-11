package tweentyscoops.mvp.kotlin.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import com.google.gson.Gson
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.extensions.toast
import tweentyscoops.mvp.kotlin.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainContract.View, MainPresenter>() , MainContract.View {

    override fun test() {
        toast("Test")

    }

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var spf: SharedPreferences

    override fun layoutToInflate() = R.layout.activity_main

    override fun doInjection(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun startView() {
        toast("")
        presenter.onViewStop()
    }

    override fun stopView() {

    }

    override fun bindView() {
        presenter.test()
    }

    override fun setupInstance() {

    }

    override fun setupView() {

    }

    override fun initialize() {

    }

    override fun saveInstanceState(outState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }
}