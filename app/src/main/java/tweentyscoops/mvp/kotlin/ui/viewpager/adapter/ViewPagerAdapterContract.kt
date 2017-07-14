package tweentyscoops.mvp.kotlin.ui.viewpager.adapter

import android.support.v4.app.FragmentManager

class ViewPagerAdapterContract {
    interface Adapter {
        fun getFragmentManager(): FragmentManager?
    }

    interface Presenter {
        fun setAdapter(adapter: Adapter)
        fun getAdapter(): Adapter?
    }
}