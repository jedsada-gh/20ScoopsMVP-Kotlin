package tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItem
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItemType
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterPresenter
import tweentyscoops.mvp.kotlin.ui.base.adapter.progress.ProgressItem

abstract class LoadmoreAdapterPresenter<in A : LoadmoreAdapterContract.Adapter> :
        BaseListAdapterPresenter<A>(), LoadmoreAdapterContract.Presenter<A> {

    private var isNextItemAvailable: Boolean = false

    override fun setItems(items: MutableList<BaseItem>, isNextItemAvailable: Boolean) {
        super.setItems(items)
        this.isNextItemAvailable = this.isNextItemAvailable
    }

    override fun getItemViewType(pos: Int) = when (pos >= super.getItemCount()) {
        true -> BaseItemType.TYPE_PROGRESS
        else -> super.getItemViewType(pos)
    }

    override fun getItemCount(): Int {
        val count = super.getItemCount()
        if (isNextItemAvailable) count.inc()
        return count
    }

    override fun getItem(pos: Int) = when (pos >= super.getItemCount()) {
        true -> ProgressItem()
        else -> super.getItem(pos)
    }
}