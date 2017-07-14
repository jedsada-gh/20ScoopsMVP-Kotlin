package tweentyscoops.mvp.kotlin.template.activity

import tweentyscoops.mvp.kotlin.ui.base.BaseContract

class TemplateContract {

    interface View : BaseContract.View {

    }

    interface Presenter : BaseContract.Presenter<View> {

    }
}