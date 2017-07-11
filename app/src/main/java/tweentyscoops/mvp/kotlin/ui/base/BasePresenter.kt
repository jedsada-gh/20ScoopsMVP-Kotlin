package tweentyscoops.mvp.kotlin.ui.base

import tweentyscoops.mvp.kotlin.api.BaseResponseCallback
import tweentyscoops.mvp.kotlin.ui.exception.MvpViewNotAttachedException
import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V>,
        BaseResponseCallback {

    private var viewRef: WeakReference<V>? = null

    override fun attachView(view: V) {
        this.viewRef = WeakReference<V>(view)
    }

    override fun detachView() {
        viewRef?.clear()
        viewRef = null
    }

    override fun getView(): V? = if (viewRef == null) throw MvpViewNotAttachedException()
    else viewRef?.get()

    override fun onViewCreate() {

    }

    override fun onViewDestroy() {

    }

    override fun onViewStart() {

    }

    override fun onViewStop() {

    }

    override fun onUnAuthorized() {
        viewRef?.get()?.hideProgressDialog()
        viewRef?.get()?.unAuthorizedApi()
    }
}