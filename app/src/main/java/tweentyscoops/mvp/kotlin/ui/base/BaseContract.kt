package tweentyscoops.mvp.kotlin.ui.base

import android.support.annotation.StringRes

open class BaseContract {

    interface UnAuthorizedCallback {
        fun onUnAuthorized()
    }

    interface View {
        fun getPresenter(): Presenter<*>
        fun showProgressDialog()
        fun hideProgressDialog()
        fun showError(message: String)
        fun showError(@StringRes message: Int)
        fun showMessage(message: String)
        fun showMessage(@StringRes message: Int)
        fun unAuthorizedApi()
    }

    interface Presenter<V : BaseContract.View> {
        fun attachView(view: V)
        fun detachView()
        fun getView(): V
        fun onViewCreate()
        fun onViewDestroy()
        fun onViewStart()
        fun onViewStop()
    }
}