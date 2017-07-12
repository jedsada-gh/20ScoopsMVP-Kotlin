package tweentyscoops.mvp.kotlin.template.activity

import android.os.Bundle
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.ui.base.BaseActivity

class TemplateActivity : BaseActivity<TemplateContract.View, TemplateContract.Presenter>() {
    override fun layoutToInflate(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doInjection(appComponent: ApplicationComponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setupInstance() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setupView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveInstanceState(outState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun restoreView(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}