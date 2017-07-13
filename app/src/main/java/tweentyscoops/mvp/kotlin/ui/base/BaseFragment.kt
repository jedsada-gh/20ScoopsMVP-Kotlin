package tweentyscoops.mvp.kotlin.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.MyApplication
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.ui.exception.MvpNotSetLayoutException
import javax.inject.Inject

abstract class BaseFragment<V : BaseContract.View, P : BaseContract.Presenter<V>> :
        Fragment(), BaseContract.View {

    @Inject
    protected lateinit var presenter: P

    @LayoutRes
    protected abstract fun layoutToInflate(): Int

    protected abstract fun doInjection(appComponent: ApplicationComponent)
    protected abstract fun startView()
    protected abstract fun stopView()
    protected abstract fun bindView(view: View?)
    protected abstract fun setupInstance()
    protected abstract fun setupView()
    protected abstract fun initialize()
    protected abstract fun saveInstanceState(outState: Bundle?)
    protected abstract fun restoreView(savedInstanceState: Bundle?)

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutToInflate() == 0) throw MvpNotSetLayoutException()
        doInjection(MyApplication.appComponent)
        presenter.attachView(this as V)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(layoutToInflate(), container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView(view)
        setupInstance()
        setupView()
        presenter.onViewCreate()
        if (savedInstanceState == null) initialize()
        else restoreView(savedInstanceState)
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

    override fun showProgressDialog() {

    }

    override fun hideProgressDialog() {

    }

    override fun showError(message: String?) {

    }

    override fun showError(message: Int) {

    }

    override fun showMessage(message: String?) {

    }

    override fun showMessage(message: Int) {

    }

    override fun unAuthorizedApi() {

    }
}