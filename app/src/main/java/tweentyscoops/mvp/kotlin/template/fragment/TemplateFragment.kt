package tweentyscoops.mvp.kotlin.template.fragment

import android.os.Bundle
import android.view.View
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.ui.base.BaseFragment

class TemplateFragment : BaseFragment<TemplateContract.View, TemplatePresenter>(),
        TemplateContract.View {

    companion object {
        fun newInstance(bundle: Bundle?): TemplateFragment {
            val fragment = TemplateFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun layoutToInflate(): Int = 0

    override fun doInjection(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun bindView(view: View?) {

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