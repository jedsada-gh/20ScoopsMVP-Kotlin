package tweentyscoops.mvp.kotlin.ui.main

import com.google.gson.Gson
import com.hwangjr.rxbus.RxBus
import com.hwangjr.rxbus.annotation.Subscribe
import com.hwangjr.rxbus.annotation.Tag
import com.hwangjr.rxbus.thread.EventThread
import tweentyscoops.mvp.kotlin.api.BaseSubscriber
import tweentyscoops.mvp.kotlin.api.model.UserInfoDao
import tweentyscoops.mvp.kotlin.api.repository.GithupRepostitory
import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(val gson: Gson, val githubRepos: GithupRepostitory) :
        BasePresenter<MainContract.View>(), MainContract.Presenter,
        BaseSubscriber.ResponseCallback<UserInfoDao> {

    override fun requestUserInfo(username: String?) {
        githubRepos.requestUserInfo(username, this)
    }

    override fun onViewStart() {
        super.onViewStart()
        RxBus.get().register(this)
    }

    override fun onViewStop() {
        super.onViewStop()
        RxBus.get().unregister(this)
    }

    override fun onSuccess(t: UserInfoDao?) {
        getView()?.userInfoData(t)
    }

    override fun onError(message: String?) {
        getView()?.showError(message)
    }

    @Subscribe(thread = EventThread.MAIN_THREAD, tags = arrayOf(Tag("text")))
    fun heardText(message: String?) {
        getView()?.updateText(message)
    }
}