package tweentyscoops.mvp.kotlin.template.adapter.list

import tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore.LoadmoreAdapterContract

class TemplateLisAdapterContract {

    interface Adapter : LoadmoreAdapterContract.Adapter {

    }

    interface Presenter : LoadmoreAdapterContract.Presenter<Adapter> {

    }
}