package tweentyscoops.mvp.kotlin.ui.base

import tweentyscoops.mvp.kotlin.ui.exception.MvpViewNotAttachedException
import java.lang.ref.WeakReference


abstract class BasePresenter<V : BaseContract.View> : BaseContract.UnAuthorizedCallback,
        BaseContract.Presenter<V> {

    private var view: WeakReference<V>? = null

    override fun onUnAuthorized() {
        view?.get()?.hideProgressDialog()
        view?.get()?.unAuthorizedApi()
    }

    override fun attachView(view: V) {
        this.view = WeakReference<V>(view)
    }

    override fun detachView() {
        this.view = null
    }

    override fun getView(): V = when (view) {
        null -> throw MvpViewNotAttachedException()
        else -> view?.get()!!
    }

    override fun onViewCreate() {

    }

    override fun onViewDestroy() {

    }

    override fun onViewStart() {

    }

    override fun onViewStop() {

    }
}