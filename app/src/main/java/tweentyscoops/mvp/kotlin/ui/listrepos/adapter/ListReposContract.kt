package tweentyscoops.mvp.kotlin.ui.listrepos.adapter

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterContract

class ListReposContract {

    interface Adapter : BaseListAdapterContract.Adapter {

    }

    interface Presenter : BaseListAdapterContract.Presenter<Adapter>{

    }
}