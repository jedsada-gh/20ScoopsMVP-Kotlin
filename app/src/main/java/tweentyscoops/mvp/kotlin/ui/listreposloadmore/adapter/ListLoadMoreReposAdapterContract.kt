package tweentyscoops.mvp.kotlin.ui.listreposloadmore.adapter

import tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore.LoadmoreAdapterContract

class ListLoadMoreReposAdapterContract {

    interface  Adapter : LoadmoreAdapterContract.Adapter {

    }

    interface Presenter : LoadmoreAdapterContract.Presenter<Adapter> {

    }
}