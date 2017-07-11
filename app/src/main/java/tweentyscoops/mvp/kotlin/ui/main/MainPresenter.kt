package tweentyscoops.mvp.kotlin.ui.main

import com.google.gson.Gson
import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(var gson: Gson) : BasePresenter<MainContract.View>(),
        MainContract.Presenter<MainContract.View> {

    override fun test() {
        getView()?.test()
    }
}