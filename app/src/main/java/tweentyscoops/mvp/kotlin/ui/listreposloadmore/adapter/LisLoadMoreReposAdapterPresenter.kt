package tweentyscoops.mvp.kotlin.ui.listreposloadmore.adapter

import tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore.LoadmoreAdapterPresenter

class LisLoadMoreReposAdapterPresenter : LoadmoreAdapterPresenter<ListLoadMoreReposAdapterContract.Adapter>(),
        ListLoadMoreReposAdapterContract.Presenter {

    companion object {
        fun create(): ListLoadMoreReposAdapterContract.Presenter = LisLoadMoreReposAdapterPresenter()
    }
}