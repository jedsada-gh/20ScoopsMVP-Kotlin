package tweentyscoops.mvp.kotlin.api.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import tweentyscoops.mvp.kotlin.api.BaseSubscriber
import tweentyscoops.mvp.kotlin.api.model.UserInfoDao

open class GithupRepostitory(private val githubApi: GithubApi) {

    fun observableUserInfo(username: String?): Observable<Response<UserInfoDao>> =
            githubApi.getUnserInfo(username)

    fun requestUserInfo(username: String?, callback: BaseSubscriber.ResponseCallback) {
        observableUserInfo(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(BaseSubscriber<UserInfoDao>(callback))
    }
}