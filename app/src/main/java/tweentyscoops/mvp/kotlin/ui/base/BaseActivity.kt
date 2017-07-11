package tweentyscoops.mvp.kotlin.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import tweentyscoops.mvp.kotlin.ui.exception.MvpNotSetLayoutException
import tweentyscoops.mvp.kotlin.ui.exception.MvpPresenterNotCreateException
import javax.inject.Inject

abstract class BaseActivity<out P : BaseContract.Presenter<*>> : AppCompatActivity(),
        BaseContract.View {

    @Inject
    private var presenter: P? = null

    @LayoutRes
    protected abstract fun layoutToInflate(): Int

    protected abstract fun createPresenter(): P
    protected abstract fun startView()
    protected abstract fun stopView()
    protected abstract fun bindView()
    protected abstract fun setupInstance()
    protected abstract fun setupView()
    protected abstract fun initialize()
    protected abstract fun saveInstanceState(outState: Bundle)
    protected abstract fun restoreView(savedInstanceState: Bundle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutToInflate() == 0) throw MvpNotSetLayoutException()
        setContentView(layoutToInflate())
        presenter = createPresenter()
        presenter?.attachView(this)
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
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    @Suppress("UNCHECKED_CAST")
    override fun getPresenter(): P {
        if (presenter != null) return presenter as P
        throw MvpPresenterNotCreateException()
    }

    override fun showProgressDialog() {

    }

    override fun hideProgressDialog() {

    }

    override fun showError(errorMessage: String) {

    }

    override fun showError(@StringRes errorMessage: Int) {

    }

    override fun showMessage(message: String) {

    }

    override fun showMessage(@StringRes message: Int) {

    }

    override fun unAuthorizedApi() {

    }
}