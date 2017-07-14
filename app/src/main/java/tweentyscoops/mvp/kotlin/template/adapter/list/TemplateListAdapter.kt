package tweentyscoops.mvp.kotlin.template.adapter.list

import android.view.ViewGroup
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapter
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder

class TemplateListAdapter : BaseListAdapter<BaseViewHolder, TemplateLisAdapterContract.Adapter,
        TemplateLisAdapterContract.Presenter>(), TemplateLisAdapterContract.Adapter {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder =
            TemplateViewHolder(parent)

    override fun createPresenter(): TemplateLisAdapterContract.Presenter =
            TemplateLisAdapterPresenter.create()

    override fun getItemCount(): Int = presenter.getItemCount()


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val baseItem = presenter.getItem(position)
        when (holder) {
            is TemplateViewHolder -> holder.onBindData(baseItem as TemplateItem)
        }
    }
}