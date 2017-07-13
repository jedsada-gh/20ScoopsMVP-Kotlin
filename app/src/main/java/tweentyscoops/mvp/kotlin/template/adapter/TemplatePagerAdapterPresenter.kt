package tweentyscoops.mvp.kotlin.template.adapter

import java.lang.ref.WeakReference

class TemplatePagerAdapterPresenter : TemplatePagerAdapterContract.Presenter {

    companion object {
        fun create() = TemplatePagerAdapterPresenter()
    }

    var adapterWrf: WeakReference<TemplatePagerAdapterContract.Adapter>? = null

    override fun setAdapter(adapter: TemplatePagerAdapterContract.Adapter) {
        adapterWrf = WeakReference<TemplatePagerAdapterContract.Adapter>(adapter)
    }

    override fun getAdapter(): TemplatePagerAdapterContract.Adapter? = adapterWrf?.get()
}