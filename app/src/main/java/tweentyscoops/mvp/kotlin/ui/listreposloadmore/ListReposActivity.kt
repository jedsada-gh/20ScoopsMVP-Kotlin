package tweentyscoops.mvp.kotlin.ui.listreposloadmore

import android.os.Bundle
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.ui.base.BaseActivity

class ListReposActivity : BaseActivity<ListReposContract.View, ListReposPresenter>(),
        ListReposContract.View {
    override fun layoutToInflate(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doInjection(appComponent: ApplicationComponent) {
        appComponent.inject(this)
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
