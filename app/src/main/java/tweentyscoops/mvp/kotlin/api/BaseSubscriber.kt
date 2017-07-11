package tweentyscoops.mvp.kotlin.api

import io.reactivex.observers.DisposableObserver
import retrofit2.Response

class BaseSubscriber<T> : DisposableObserver<Response<T>>() {
    override fun onNext(t: Response<T>) {

    }

    override fun onError(e: Throwable) {

    }

    override fun onComplete() {

    }
}