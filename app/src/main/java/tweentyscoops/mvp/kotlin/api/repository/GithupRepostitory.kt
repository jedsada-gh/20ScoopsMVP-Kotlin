package tweentyscoops.mvp.kotlin.api.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import tweentyscoops.mvp.kotlin.api.BaseSubscriber
import tweentyscoops.mvp.kotlin.api.model.UserInfoDao
import tweentyscoops.mvp.kotlin.api.model.UserReposDao

open class GithupRepostitory(private val githubApi: GithubApi) {

    fun observableUserInfo(username: String?): Observable<Response<UserInfoDao>> =
            githubApi.getUnserInfo(username)

    fun observableUserRepos(username: String?): Observable<Response<MutableList<UserReposDao>>> =
            githubApi.getUnserRepos(username)

    fun requestUserInfo(username: String?, callback: BaseSubscriber.ResponseCallback<UserInfoDao>) =
            observableUserInfo(username)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(BaseSubscriber(callback))

    fun requestUserRepos(username: String?, callback: BaseSubscriber.ResponseCallback<MutableList<UserReposDao>>) =
            observableUserRepos(username)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(BaseSubscriber(callback))
}