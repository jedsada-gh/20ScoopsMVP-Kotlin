package tweentyscoops.mvp.kotlin.ui.base.adapter

class BaseListAdapterContract {
    interface Adapter {
        fun notifyDataSetChanged()
        fun notifyItemInserted(index: Int)
        fun notifyItemRemoved(index: Int)
    }

    interface Presenter<in A : BaseListAdapterContract.Adapter> {
        fun setAdapter(adapter: A)
        fun getItemViewType(pos: Int): Int
        fun getItemCount(): Int
        fun hasItems(): Boolean
        fun getItems(): MutableList<BaseItem>
        fun getItem(pos: Int): BaseItem
        fun setItems(items: MutableList<BaseItem>)
        fun addItem(item: BaseItem)
        fun removeItem(index: Int)
        fun removeAllItems()
    }
}