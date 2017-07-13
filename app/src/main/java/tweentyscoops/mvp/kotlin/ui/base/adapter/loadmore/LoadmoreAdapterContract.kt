package tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterContract

class LoadmoreAdapterContract {

    interface Adapter : BaseListAdapterContract.Adapter {

    }

    interface Presenter<A : BaseListAdapterContract.Adapter> : BaseListAdapterContract.Presenter<A> {

    }
}