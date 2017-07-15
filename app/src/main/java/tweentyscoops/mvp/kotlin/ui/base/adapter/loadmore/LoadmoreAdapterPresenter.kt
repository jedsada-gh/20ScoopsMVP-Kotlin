package tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore

import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItem
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItemType
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterPresenter
import tweentyscoops.mvp.kotlin.ui.base.adapter.progress.ProgressItem

abstract class LoadmoreAdapterPresenter<in A : LoadmoreAdapterContract.Adapter> :
        BaseListAdapterPresenter<A>(), LoadmoreAdapterContract.Presenter<A> {

    private var isNextItemAvailable: Boolean = false

    override fun setItems(items: List<BaseItem>?, isNextItemAvailable: Boolean) {
        super.setItems(items)
        this.isNextItemAvailable = isNextItemAvailable
    }

    override fun getItemViewType(pos: Int): Int = when (pos >= super.getItemCount()) {
        true -> BaseItemType.TYPE_PROGRESS
        else -> super.getItemViewType(pos)
    }

    override fun getItemCount(): Int {
        var count = super.getItemCount()
        if (isNextItemAvailable) count++
        return count
    }

    override fun getItem(pos: Int): BaseItem = when (pos >= super.getItemCount()) {
        true -> ProgressItem()
        else -> super.getItem(pos)
    }
}