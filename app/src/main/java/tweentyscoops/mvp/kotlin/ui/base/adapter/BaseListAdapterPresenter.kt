package tweentyscoops.mvp.kotlin.ui.base.adapter

import com.orhanobut.logger.Logger
import java.lang.ref.WeakReference

abstract class BaseListAdapterPresenter<in A : BaseListAdapterContract.Adapter> :
        BaseListAdapterContract.Presenter<A> {

    private var adapter: WeakReference<A>? = null
    private var items: MutableList<BaseItem> = mutableListOf()

    override fun setAdapter(adapter: A) {
        this.adapter = WeakReference<A>(adapter)
    }

    override fun getItemViewType(pos: Int): Int {
        Logger.d(items[pos].type.toString())
        return items[pos].type
    }

    override fun getItemCount(): Int {
        Logger.d(items.size.toString())
        return items.size
    }

    override fun hasItems() = !items.isEmpty()

    override fun getItems(): MutableList<BaseItem> = items

    override fun getItem(pos: Int) = items[pos]

    override fun setItems(items: List<BaseItem>?) {
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