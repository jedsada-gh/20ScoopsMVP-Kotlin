package tweentyscoops.mvp.kotlin.ui.viewpager.adapter

import java.lang.ref.WeakReference

class ViewPagerAdapterPresenter : ViewPagerAdapterContract.Presenter {

    companion object {
        fun create() = ViewPagerAdapterPresenter()
    }

    var adapterWrf: WeakReference<ViewPagerAdapterContract.Adapter>? = null

    override fun setAdapter(adapter: ViewPagerAdapterContract.Adapter) {
        adapterWrf = WeakReference<ViewPagerAdapterContract.Adapter>(adapter)
    }

    override fun getAdapter(): ViewPagerAdapterContract.Adapter? = adapterWrf?.get()
}