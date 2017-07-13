package tweentyscoops.mvp.kotlin.ui.base.adapter

import android.support.v7.widget.RecyclerView
import javax.inject.Inject

abstract class BaseListAdapter<VH : BaseViewHolder, A : BaseListAdapterContract.Adapter,
        P : BaseListAdapterContract.Presenter<A>> : RecyclerView.Adapter<VH>(),
        BaseListAdapterContract.Adapter {

    @Inject lateinit var presenter: P
    @Inject lateinit var adapter: A

    protected interface OnLoadMoreListener {
        fun onLoadMore()
    }

    init {
        presenter.setAdapter(adapter)
    }

    fun getItems(): MutableList<BaseItem> = presenter.getItems()

    fun getItem(pos: Int): BaseItem = presenter.getItem(pos)

    fun hasItems() = presenter.hasItems()

    fun setItems(items: MutableList<BaseItem>) = presenter.setItems(items)

    fun addItem(item: BaseItem) = presenter.addItem(item)

    fun removeItem(index: Int) = presenter.removeItem(index)

    fun removeAllItems() = presenter.removeAllItems()
}