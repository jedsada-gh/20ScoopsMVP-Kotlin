package tweentyscoops.mvp.kotlin.template.fragment

import tweentyscoops.mvp.kotlin.ui.base.BasePresenter
import javax.inject.Inject

class TemplatePresenter @Inject constructor() : BasePresenter<TemplateContract.View>(),
        TemplateContract.Presenter<TemplateContract.View> {
}