package tweentyscoops.mvp.kotlin.ui.main

import com.google.gson.Gson
import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter(@Inject var gson: Gson) : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun test() {

    }

    override fun onViewCreate() {
        super.onViewCreate()
    }

    override fun onViewDestroy() {
        super.onViewDestroy()
    }

    override fun onViewStart() {
        super.onViewStart()
    }

    override fun onViewStop() {
        super.onViewStop()
    }
}