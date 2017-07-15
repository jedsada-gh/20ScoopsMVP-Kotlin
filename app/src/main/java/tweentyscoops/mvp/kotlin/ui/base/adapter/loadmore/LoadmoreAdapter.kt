package tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore

import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItem
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItemType
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapter
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder
import tweentyscoops.mvp.kotlin.ui.base.adapter.progress.ProgressViewHolder

abstract class LoadmoreAdapter<VH : BaseViewHolder, in A : LoadmoreAdapterContract.Adapter,
        P : LoadmoreAdapterContract.Presenter<A>> : BaseListAdapter<VH, A, P>(),
        LoadmoreAdapterContract.Adapter {

    private var callback: OnLoadMoreListener? = null

    fun setOnLoadmoreListener(callback: OnLoadMoreListener) {
        this.callback = callback
    }

    fun setItems(items: List<BaseItem>?, isNextItemAvailable: Boolean) {
        presenter.setItems(items, isNextItemAvailable)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH? {
        if (viewType == BaseItemType.TYPE_PROGRESS) {
            return ProgressViewHolder(parent) as VH
        }
        return null
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        when (getItemViewType(position)) {
            BaseItemType.TYPE_PROGRESS -> callback?.onLoadMore()
        }
    }
}