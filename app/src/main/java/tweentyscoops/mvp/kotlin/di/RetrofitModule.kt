package tweentyscoops.mvp.kotlin.di

import android.app.Application
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tweentyscoops.mvp.kotlin.configuration.BuildConfiguration
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {

    companion object {
        const val TIME_OUT = 60
    }

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache =
            Cache(application.cacheDir, (10 * 1024 * 1024).toLong())

    @Provides
    @Singleton
    fun provideOkHttpClient(configuration: BuildConfiguration, cache: Cache,
                            httpClient: OkHttpClient.Builder): OkHttpClient {
        if (configuration.isDebug()) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(httpLoggingInterceptor)
        }

        httpClient.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectionPool(ConnectionPool(0, TIME_OUT.toLong(), TimeUnit.SECONDS))

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            if (configuration.userToken() != null)
                requestBuilder.header("Authorization", configuration.userToken())
            requestBuilder.header("device", configuration.deviceType())
            requestBuilder.header("app_version", configuration.version())
            requestBuilder.method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return httpClient.cache(cache).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(configuration: BuildConfiguration, gson: Gson, httpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(configuration.endPoint())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient)
                    .build()
}
