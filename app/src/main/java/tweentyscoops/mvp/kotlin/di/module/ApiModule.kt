package tweentyscoops.mvp.kotlin.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import tweentyscoops.mvp.kotlin.api.repository.GithubApi
import tweentyscoops.mvp.kotlin.api.repository.GithupRepostitory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGithubAPI(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)

    @Provides
    @Singleton
    fun provideGithubRepos(githubApi: GithubApi): GithupRepostitory = GithupRepostitory(githubApi)
}
