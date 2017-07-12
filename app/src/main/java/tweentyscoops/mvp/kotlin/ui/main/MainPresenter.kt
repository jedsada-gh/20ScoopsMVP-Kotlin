package tweentyscoops.mvp.kotlin.ui.main

import tweentyscoops.mvp.kotlin.api.BaseSubscriber
import tweentyscoops.mvp.kotlin.api.repository.GithupRepostitory
import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(val githubRepos: GithupRepostitory) :
        BasePresenter<MainContract.View>(), MainContract.Presenter<MainContract.View>,
        BaseSubscriber.ResponseCallback {

    override fun test() {
        githubRepos.requestUserInfo("pondthaitay", this)
    }

    override fun <T> onSuccess(t: T) {
        getView()?.test()
    }

    override fun onError(message: String?) {

    }
}