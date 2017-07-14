package tweentyscoops.mvp.kotlin.ui.listrepos.adapter

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterPresenter

class ListReposPresenter : BaseListAdapterPresenter<ListReposContract.Adapter>(), ListReposContract.Presenter {

    companion object {
        fun create() = ListReposPresenter()
    }
}