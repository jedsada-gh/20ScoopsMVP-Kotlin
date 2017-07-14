package tweentyscoops.mvp.kotlin.template.activity

import android.os.Bundle
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.ui.base.BaseActivity

class TemplateActivity : BaseActivity<TemplateContract.View, TemplatePresenter>(),
        TemplateContract.View {

    override fun layoutToInflate() = 0

    override fun doInjection(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun bindView() {

    }

    override fun setupInstance() {

    }

    override fun setupView() {

    }

    override fun initialize() {

    }

    override fun saveInstanceState(outState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }
}