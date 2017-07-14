package tweentyscoops.mvp.kotlin.template.adapter.list

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterPresenter

class TemplateLisAdapterPresenter : BaseListAdapterPresenter<TemplateLisAdapterContract.Adapter>(),
        TemplateLisAdapterContract.Presenter {

    companion object {
        fun create() = TemplateLisAdapterPresenter()
    }
}