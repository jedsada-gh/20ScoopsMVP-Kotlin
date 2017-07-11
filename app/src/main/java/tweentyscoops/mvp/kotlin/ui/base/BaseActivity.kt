package tweentyscoops.mvp.kotlin.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import tweentyscoops.mvp.kotlin.MyApplication
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.extensions.toast
import tweentyscoops.mvp.kotlin.ui.exception.MvpNotSetLayoutException

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<in V : BaseContract.View, out P : BasePresenter<in V>> :
        AppCompatActivity(), BaseContract.View {

    //    @Inject
    private lateinit var presenter: P

    @LayoutRes
    protected abstract fun layoutToInflate(): Int

    abstract fun doInjection(appComponent: ApplicationComponent)
    protected abstract fun startView()
    protected abstract fun stopView()
    protected abstract fun bindView()
    protected abstract fun setupInstance()
    protected abstract fun setupView()
    protected abstract fun initialize()
    protected abstract fun saveInstanceState(outState: Bundle?)
    protected abstract fun restoreView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutToInflate() == 0) throw MvpNotSetLayoutException()
        setContentView(layoutToInflate())
        doInjection((application as MyApplication).component())
        presenter.attachView(this as V)
        bindView()
        setupInstance()
        setupView()
        getPresenter().onViewCreate()
        if (savedInstanceState == null) initialize()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        restoreView(savedInstanceState)
    }

    override fun getPresenter(): P = presenter

    override fun showProgressDialog() {

    }

    override fun hideProgressDialog() {

    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun showError(@StringRes message: Int) {
        toast(message)
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun showMessage(@StringRes message: Int) {
        toast(message)
    }

    override fun unAuthorizedApi() {

    }
}