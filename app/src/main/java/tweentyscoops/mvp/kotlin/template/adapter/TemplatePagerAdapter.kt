package tweentyscoops.mvp.kotlin.template.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.lang.ref.WeakReference

class TemplatePagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager),
        TemplatePagerAdapterContract.Adapter {

    private var fmWrf: WeakReference<FragmentManager> = WeakReference(fragmentManager)
    var presenter: TemplatePagerAdapterContract.Presenter? = TemplatePagerAdapterPresenter.create()

    init {
        presenter?.setAdapter(this)
    }

    override fun getFragmentManager() = fmWrf.get()

    override fun getItem(position: Int): Fragment? = null

    override fun getCount() = 0
}