package tweentyscoops.mvp.kotlin.template.adapter.list

import tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore.LoadmoreAdapterPresenter

class TemplateLisAdapterPresenter : LoadmoreAdapterPresenter<TemplateLisAdapterContract.Adapter>(),
        TemplateLisAdapterContract.Presenter {

    companion object {
        fun create() = TemplateLisAdapterPresenter()
    }
}
