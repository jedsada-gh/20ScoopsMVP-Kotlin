package tweentyscoops.mvp.kotlin.ui.main.fragment

import tweentyscoops.mvp.kotlin.ui.base.BaseContract

class MainContract {

    interface View : BaseContract.View {

    }

    interface Presenter : BaseContract.Presenter<View> {
        fun sendText(message: String?)
    }
}