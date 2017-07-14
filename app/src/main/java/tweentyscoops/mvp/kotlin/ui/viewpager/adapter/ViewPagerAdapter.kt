package tweentyscoops.mvp.kotlin.ui.viewpager.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import tweentyscoops.mvp.kotlin.ui.viewpager.FragmentTest
import java.lang.ref.WeakReference

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager),
        ViewPagerAdapterContract.Adapter {

    private var fmWrf: WeakReference<FragmentManager> = WeakReference(fragmentManager)
    var presenter: ViewPagerAdapterContract.Presenter? = ViewPagerAdapterPresenter.create()

    init {
        presenter?.setAdapter(this)
    }

    override fun getFragmentManager() = fmWrf.get()

    override fun getItem(position: Int): Fragment? = FragmentTest.newInstance(position)

    override fun getCount() = 5
}