package tweentyscoops.mvp.kotlin.ui.listrepos.adapter

import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.api.model.UserRepos
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapter
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder

class ListReposAdapter : BaseListAdapter<BaseViewHolder, ListReposContract.Adapter,
        ListReposContract.Presenter>(), ListReposContract.Adapter {

    init {
        presenter.setItems(mutableListOf())
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        val item = presenter.getItem(position)
        when (holder) {
            is ListReposViewHolder -> holder.onBindData(item as UserRepos)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder =
            ListReposViewHolder(parent)

    override fun getItemCount() = presenter.getItemCount()

    override fun createPresenter() = ListReposPresenter.create()
}