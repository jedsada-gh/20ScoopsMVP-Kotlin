package tweentyscoops.mvp.kotlin.ui.main.fragment

import tweentyscoops.mvp.kotlin.ui.base.BaseContract

class MainContract {

    interface View : BaseContract.View {

    }

    interface Presenter<V : View> : BaseContract.Presenter<V> {
        fun sendText(message: String?)
    }
}