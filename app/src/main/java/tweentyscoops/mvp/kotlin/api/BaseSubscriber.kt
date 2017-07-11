package tweentyscoops.mvp.kotlin.api

import io.reactivex.observers.DisposableObserver
import retrofit2.Response

class BaseSubscriber<T> : DisposableObserver<Response<T>>() {
    override fun onNext(t: Response<T>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(e: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}