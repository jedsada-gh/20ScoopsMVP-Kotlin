package tweentyscoops.mvp.kotlin.ui.listreposloadmore

import tweentyscoops.mvp.kotlin.api.BaseSubscriber
import tweentyscoops.mvp.kotlin.api.model.UserReposDao
import tweentyscoops.mvp.kotlin.api.repository.GithupRepostitory
import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class ListReposPresenter @Inject constructor(private val githupRepostitory: GithupRepostitory) :
        BasePresenter<ListReposContract.View>(), ListReposContract.Presenter, BaseSubscriber.ResponseCallback<MutableList<UserReposDao>> {

    override fun onViewStart() {
        super.onViewStart()
    }

    override fun onViewStop() {
        super.onViewStop()
    }

    override fun getUserRepos(username: String) {
        githupRepostitory.requestUserRepos(username, this)
    }

    override fun onSuccess(t: MutableList<UserReposDao>?) {
        getView()?.setItemReposToList(t)
    }

    override fun onError(message: String?) {

    }
}