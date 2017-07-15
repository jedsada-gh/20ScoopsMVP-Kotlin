package tweentyscoops.mvp.kotlin.ui.listreposloadmore.adapter

import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.api.model.UserReposDao
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItemType
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder
import tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore.LoadmoreAdapter

class ListLoadMoreReposAdapter : LoadmoreAdapter<BaseViewHolder, ListLoadMoreReposAdapterContract.Adapter,
        ListLoadMoreReposAdapterContract.Presenter>() {

    fun initItemForLoadmore() = presenter.setItems(mutableListOf(), true)

    override fun getItemCount(): Int = presenter.getItemCount()

    override fun createPresenter(): ListLoadMoreReposAdapterContract.Presenter =
            LisLoadMoreReposAdapterPresenter.create()

    override fun getItemViewType(position: Int): Int = presenter.getItemViewType(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder? = when (viewType) {
        BaseItemType.TYPE_NORMAL -> ListLoadMoreReposViewHolder(parent)
        else -> super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = presenter.getItem(position)
        when (holder) {
            is ListLoadMoreReposViewHolder -> holder.onBindData(item as UserReposDao)
        }
    }
}