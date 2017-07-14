package tweentyscoops.mvp.kotlin.template.adapter.list

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterContract

class TemplateLisAdapterContract {

    interface Adapter : BaseListAdapterContract.Adapter {

    }

    interface Presenter : BaseListAdapterContract.Presenter<Adapter> {

    }
}