package tweentyscoops.mvp.kotlin.ui.listrepos

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tweentyscoops.mvp.kotlin.api.BaseSubscriber
import tweentyscoops.mvp.kotlin.api.model.UserRepos
import tweentyscoops.mvp.kotlin.api.repository.GithubApi
import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class ListReposPresenter @Inject constructor(val githubApi: GithubApi) : BasePresenter<ListReposContract.View>(),
        ListReposContract.Presenter<ListReposContract.View>, BaseSubscriber.ResponseCallback<MutableList<UserRepos>> {

    override fun onViewStart() {
        super.onViewStart()
    }

    override fun onViewStop() {
        super.onViewStop()
    }

    override fun getUserRepos(username: String?) {
        githubApi.getUnserRepos().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(BaseSubscriber(this))
    }

    override fun onSuccess(t: MutableList<UserRepos>?) {
        getView()?.setListRepos(t)
    }

    override fun onError(message: String?) {

    }
}