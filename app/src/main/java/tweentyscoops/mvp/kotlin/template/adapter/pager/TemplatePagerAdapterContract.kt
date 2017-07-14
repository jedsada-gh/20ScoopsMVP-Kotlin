package tweentyscoops.mvp.kotlin.template.adapter.pager

import android.support.v4.app.FragmentManager

class TemplatePagerAdapterContract {
    interface Adapter {
        fun getFragmentManager(): FragmentManager?
    }

    interface Presenter {
        fun setAdapter(adapter: Adapter)
        fun getAdapter(): Adapter?
    }
}