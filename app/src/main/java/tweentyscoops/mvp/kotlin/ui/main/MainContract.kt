package tweentyscoops.mvp.kotlin.ui.main

import tweentyscoops.mvp.kotlin.ui.base.BaseContract

class MainContract {

    interface View : BaseContract.View {
        fun test()
    }

    interface Presenter<V : View> : BaseContract.Presenter<V> {
        fun test()
    }
}