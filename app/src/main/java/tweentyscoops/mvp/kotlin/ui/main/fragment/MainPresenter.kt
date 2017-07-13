package tweentyscoops.mvp.kotlin.ui.main.fragment

import com.hwangjr.rxbus.RxBus
import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>(),
        MainContract.Presenter<MainContract.View> {

    override fun onViewStart() {
        super.onViewStart()
        RxBus.get().register(this)
    }

    override fun onViewStop() {
        super.onViewStop()
        RxBus.get().unregister(this)
    }

    override fun sendText(message: String?) {
        RxBus.get().post("text", message)
    }
}