package tweentyscoops.mvp.kotlin.ui.base.adapter

import android.support.v7.widget.RecyclerView

@Suppress("LeakingThis")
abstract class BaseListAdapter<VH : BaseViewHolder, in A : BaseListAdapterContract.Adapter,
        P : BaseListAdapterContract.Presenter<A>> : RecyclerView.Adapter<VH>(),
        BaseListAdapterContract.Adapter {

    interface OnLoadMoreListener {
        fun onLoadMore()
    }

    protected var presenter: P

    init {
        presenter = createPresenter()
        @Suppress("UNCHECKED_CAST")
        presenter.setAdapter(this as A)
    }

    abstract fun createPresenter(): P

    fun getItems(): MutableList<BaseItem> = presenter.getItems()
    fun getItem(pos: Int): BaseItem = presenter.getItem(pos)
    fun hasItems() = presenter.hasItems()
    fun setItems(items: List<BaseItem>?) = presenter.setItems(items)
    fun addItem(item: BaseItem) = presenter.addItem(item)
    fun removeItem(index: Int) = presenter.removeItem(index)
    fun removeAllItems() = presenter.removeAllItems()
}