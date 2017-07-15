package tweentyscoops.mvp.kotlin.ui.base.adapter

import java.lang.ref.WeakReference

abstract class BaseListAdapterPresenter<in A : BaseListAdapterContract.Adapter> :
        BaseListAdapterContract.Presenter<A> {

    private var adapter: WeakReference<A>? = null
    private var items: MutableList<BaseItem> = mutableListOf()

    override fun setAdapter(adapter: A) {
        this.adapter = WeakReference<A>(adapter)
    }

    override fun getItemViewType(pos: Int): Int = items[pos].type

    override fun getItemCount(): Int = items.size

    override fun hasItems(): Boolean = !items.isEmpty()

    override fun getItems(): MutableList<BaseItem> = items

    override fun getItem(pos: Int): BaseItem = items[pos]

    override fun setItems(items: List<BaseItem>?) {
        //TODO : fix to safe change to mutablelist
        this.items = items!!.toMutableList()
        adapter?.get()?.notifyDataSetChanged()
    }

    override fun addItem(item: BaseItem) {
        items.add(item)
        adapter?.get()?.notifyItemInserted(getItemCount() - 1)
    }

    override fun removeItem(index: Int) {
        items.removeAt(index)
        adapter?.get()?.notifyItemRemoved(index)
    }

    override fun removeAllItems() {
        items.clear()
        adapter?.get()?.notifyDataSetChanged()
    }
}