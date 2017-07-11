package tweentyscoops.mvp.kotlin.ui.base

class BaseContract {

    interface View {

    }

    interface Presenter<V : BaseContract.View> {

    }
}