package tweentyscoops.mvp.kotlin.di.module

import android.app.Application
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import tweentyscoops.mvp.kotlin.configuration.Config
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {

    companion object {
        const val TIME_OUT = 60L
    }

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache =
            Cache(application.cacheDir, (10 * 1024 * 1024).toLong())

    @Provides
    fun provideLogger(): HttpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Timber.d(it); })

    @Provides
    @Singleton
    fun provideOkHttpClient(config: Config, logger: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        if (config.isDebug()) {
            logger.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logger)
        }
//        okHttpClientBuilder.addInterceptor { chain ->
//            val original = chain.request()
//            val requestBuilder = original.newBuilder()
//            if (config.userToken() != null) requestBuilder.header("Authorization", config.userToken())
//            requestBuilder.header("device", config.deviceType())
//            requestBuilder.header("app_version", config.version())
//            requestBuilder.method(original.method(), original.body())
//            val request = requestBuilder.build()
//            chain.proceed(request)
//        }
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(config: Config, gson: Gson, okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(config.endPoint())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build()
}
