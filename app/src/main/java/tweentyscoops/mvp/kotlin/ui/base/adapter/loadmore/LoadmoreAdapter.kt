package tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapter
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterContract
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder

abstract class LoadmoreAdapter<VH : BaseViewHolder, A : BaseListAdapterContract.Adapter,
        P : LoadmoreAdapterContract.Presenter<A>> : BaseListAdapter<VH, A, P>() {

}