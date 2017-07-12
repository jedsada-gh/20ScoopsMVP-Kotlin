package tweentyscoops.mvp.kotlin.api

import io.reactivex.observers.DisposableObserver
import retrofit2.Response
import java.net.HttpURLConnection

class BaseSubscriber<T>(val callback: ResponseCallback) : DisposableObserver<Response<T>>() {

    interface ResponseCallback : BaseResponseCallback {
        fun <T> onSuccess(t: T)
        fun onError(message: String?)
    }

    override fun onNext(t: Response<T>) {
        when (t.code()) {
            HttpURLConnection.HTTP_OK -> callback.onSuccess(t.body())
            HttpURLConnection.HTTP_UNAUTHORIZED -> callback.onUnAuthorized()
            else -> callback.onError(t.message())
        }
    }

    override fun onError(e: Throwable) {
        callback.onError(e.message)
    }

    override fun onComplete() {
        // TODO : nothings
    }
}