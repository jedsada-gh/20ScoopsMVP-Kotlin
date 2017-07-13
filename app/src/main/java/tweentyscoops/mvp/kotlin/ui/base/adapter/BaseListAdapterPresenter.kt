package tweentyscoops.mvp.kotlin.ui.base.adapter

import tweentyscoops.mvp.kotlin.ui.exception.MvpViewNotAttachedException
import java.lang.ref.WeakReference

abstract class BaseListAdapterPresenter<A : BaseListAdapterContract.Adapter> :
        BaseListAdapterContract.Presenter<A> {

    private var adapter: WeakReference<A>? = null
    private var items: MutableList<BaseItem> = mutableListOf()

    override fun setAdapter(adapter: A) {
        this.adapter = WeakReference<A>(adapter)
    }

    override fun getAdapter(): A? {
        if (adapter != null) return adapter?.get()
        throw MvpViewNotAttachedException()
    }

    override fun getItemViewType(pos: Int) = items[pos].type

    override fun getItemCount() = items.size

    override fun hasItems() = !items.isEmpty()

    override fun getItems(): MutableList<BaseItem> = items

    override fun getItem(pos: Int) = items[pos]

    override fun setItems(items: MutableList<BaseItem>) {
        this.items = items
        getAdapter()?.notifyDataSetChanged()
    }

    override fun addItem(item: BaseItem) {
        items.add(item)
        getAdapter()?.notifyItemInserted(getItemCount() - 1)
    }

    override fun removeItem(index: Int) {
        items.removeAt(index)
        getAdapter()?.notifyItemRemoved(index)
    }

    override fun removeAllItems() {
        items.clear()
        getAdapter()?.notifyDataSetChanged()
    }
}