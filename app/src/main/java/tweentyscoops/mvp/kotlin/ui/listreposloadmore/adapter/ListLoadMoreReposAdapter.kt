package tweentyscoops.mvp.kotlin.ui.listreposloadmore.adapter

import android.view.ViewGroup
import com.orhanobut.logger.Logger
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseItemType
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder
import tweentyscoops.mvp.kotlin.ui.base.adapter.loadmore.LoadmoreAdapter

class ListLoadMoreReposAdapter : LoadmoreAdapter<BaseViewHolder, ListLoadMoreReposAdapterContract.Adapter,
        ListLoadMoreReposAdapterContract.Presenter>() {

    override fun getItemCount(): Int {
        return presenter.getItemCount()
    }

    override fun createPresenter(): ListLoadMoreReposAdapterContract.Presenter {
        return LisLoadMoreReposAdapterPresenter.create()
    }

    override fun getItemViewType(position: Int): Int {
        Logger.d("HI")
        Logger.d(presenter.getItemCount().toString())
        Logger.d(presenter.getItemViewType(position).toString())
        return presenter.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder? {
        when (viewType) {
            BaseItemType.TYPE_NORMAL -> ListLoadMoreReposViewHolder(parent)
        }
        return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }
}