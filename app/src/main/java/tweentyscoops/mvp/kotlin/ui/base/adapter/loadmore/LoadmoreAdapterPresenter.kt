package tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore

import timber.log.Timber
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItem
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItemType
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapterPresenter
import tweentyscoops.mvp.kotlin.ui.base.adapter.progress.ProgressItem

abstract class LoadmoreAdapterPresenter<in A : LoadmoreAdapterContract.Adapter> :
        BaseListAdapterPresenter<A>(), LoadmoreAdapterContract.Presenter<A> {

    private var isNextItemAvailable: Boolean = false

    override fun setItems(items: List<BaseItem>?, isNextItemAvailable: Boolean) {
        super.setItems(items)
        this.isNextItemAvailable = this.isNextItemAvailable
    }

    override fun getItemViewType(pos: Int) = when (pos >= super.getItemCount()) {
        true -> {
            Timber.d("true $pos")
            BaseItemType.TYPE_PROGRESS
        }
        else -> {
            Timber.d("false $pos")
            super.getItemViewType(pos)
        }
    }

    override fun getItemCount(): Int {
        var count = super.getItemCount()
        if (isNextItemAvailable) count++
        return count
    }

    override fun getItem(pos: Int) = when (pos >= super.getItemCount()) {
        true -> ProgressItem()
        else -> super.getItem(pos)
    }
}