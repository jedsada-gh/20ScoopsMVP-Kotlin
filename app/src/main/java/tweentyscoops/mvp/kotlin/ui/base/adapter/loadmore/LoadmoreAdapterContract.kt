package tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItem
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterContract

class LoadmoreAdapterContract {

    interface Adapter : BaseListAdapterContract.Adapter {

    }

    interface Presenter<in A : BaseListAdapterContract.Adapter> : BaseListAdapterContract.Presenter<A> {
        fun setItems(items: MutableList<BaseItem>, isNextItemAvailable: Boolean)
    }
}