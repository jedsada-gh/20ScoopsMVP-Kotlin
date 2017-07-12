package tweentyscoops.mvp.kotlin.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import tweentyscoops.mvp.kotlin.MyApplication
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.extensions.toast
import tweentyscoops.mvp.kotlin.ui.exception.MvpNotSetLayoutException
import javax.inject.Inject

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> :
        AppCompatActivity(), BaseContract.View {

    @Inject
    protected lateinit var presenter: P

    @LayoutRes
    protected abstract fun layoutToInflate(): Int

    protected abstract fun doInjection(appComponent: ApplicationComponent)
    protected abstract fun startView()
    protected abstract fun stopView()
    protected abstract fun bindView()
    protected abstract fun setupInstance()
    protected abstract fun setupView()
    protected abstract fun initialize()
    protected abstract fun saveInstanceState(outState: Bundle?)
    protected abstract fun restoreView(savedInstanceState: Bundle?)

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutToInflate() == 0) throw MvpNotSetLayoutException()
        setContentView(layoutToInflate())
        doInjection((application as MyApplication).component())
        presenter.attachView(this as V)
        bindView()
        setupInstance()
        setupView()
        presenter.onViewCreate()
        if (savedInstanceState == null) initialize()
    }

    override fun onStart() {
        super.onStart()
        startView()
        presenter.onViewStart()
    }

    override fun onStop() {
        super.onStop()
        stopView()
        presenter.onViewStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroy()
        presenter.detachView()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        restoreView(savedInstanceState)
    }

    override fun showProgressDialog() {

    }

    override fun hideProgressDialog() {

    }

    override fun showError(message: String?) {
        toast(message)
    }

    override fun showError(@StringRes message: Int) {
        toast(message)
    }

    override fun showMessage(message: String?) {
        toast(message)
    }

    override fun showMessage(@StringRes message: Int) {
        toast(message)
    }

    override fun unAuthorizedApi() {

    }
}