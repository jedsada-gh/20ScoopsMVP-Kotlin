package tweentyscoops.mvp.kotlin.ui.listreposloadmore

import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class ListReposPresenter @Inject constructor() : BasePresenter<ListReposContract.View>(),
        ListReposContract.Presenter {

    override fun onViewStart() {
        super.onViewStart()
    }

    override fun onViewStop() {
        super.onViewStop()
    }
}