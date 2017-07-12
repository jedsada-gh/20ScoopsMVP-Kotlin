package tweentyscoops.mvp.kotlin.ui.main

import com.google.gson.Gson
import com.hwangjr.rxbus.RxBus
import tweentyscoops.mvp.kotlin.api.BaseSubscriber
import tweentyscoops.mvp.kotlin.api.model.UserInfoDao
import tweentyscoops.mvp.kotlin.api.repository.GithupRepostitory
import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(val gson: Gson, val githubRepos: GithupRepostitory) :
        BasePresenter<MainContract.View>(), MainContract.Presenter<MainContract.View>,
        BaseSubscriber.ResponseCallback {

    override fun requestUserInfo(username: String?) {
        githubRepos.requestUserInfo(username, this)
    }

    override fun <T> onSuccess(t: T) {
        val userInfo = t as? UserInfoDao
        getView()?.userInfoData(userInfo)
    }

    override fun onError(message: String?) {

    }

    override fun onViewStart() {
        RxBus.get().register(this)
    }

    override fun onViewStop() {
        super.onViewStop()
        RxBus.get().unregister(this)
    }
}