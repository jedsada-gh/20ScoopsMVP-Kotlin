package tweentyscoops.mvp.kotlin.api.repository

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import tweentyscoops.mvp.kotlin.api.model.UserInfoDao
import tweentyscoops.mvp.kotlin.api.model.UserRepos

interface GithubApi {
    @GET("users/{username}")
    fun getUnserInfo(@Path("username") username: String? = "pondthaitay"):
            Observable<Response<UserInfoDao>>

    @GET("users/{username}/repos")
    fun getUnserRepos(@Path("username") username: String? = "pondthaitay"):
            Observable<Response<MutableList<UserRepos>>>
}