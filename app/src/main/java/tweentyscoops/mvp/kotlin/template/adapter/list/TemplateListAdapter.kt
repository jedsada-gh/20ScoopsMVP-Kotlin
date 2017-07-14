package tweentyscoops.mvp.kotlin.template.adapter.list

import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.template.adapter.list.holder.TemplateHolder
import tweentyscoops.mvp.kotlin.template.adapter.list.item.TemplateItem
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder
import tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore.LoadmoreAdapter

class TemplateListAdapter : LoadmoreAdapter<BaseViewHolder, TemplateLisAdapterContract.Adapter,
        TemplateLisAdapterContract.Presenter>(), TemplateLisAdapterContract.Adapter {

    companion object {
        val TEMPLATE_LIST_TYPE = 10
    }

    override fun createPresenter(): TemplateLisAdapterContract.Presenter =
            TemplateLisAdapterPresenter.create()

    override fun getItemCount(): Int = presenter.getItemCount()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder? = when (viewType) {
        TEMPLATE_LIST_TYPE -> TemplateHolder(parent)
        else -> super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val baseItem = presenter.getItem(position)
        when (holder) {
            is TemplateHolder -> holder.onBindData(baseItem as TemplateItem)
        }
    }
}