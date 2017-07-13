package tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterPresenter

abstract class LoadmoreAdapterPresenter<A : LoadmoreAdapterContract.Adapter> :
        BaseListAdapterPresenter<A>(), LoadmoreAdapterContract.Presenter<A> {

}