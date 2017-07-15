package tweentyscoops.mvp.kotlin.ui.listreposloadmore.adapter

import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_repos.view.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.api.model.UserReposDao
import tweentyscoops.mvp.kotlin.extensions.text
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder

class ListLoadMoreReposViewHolder(viewGroup: ViewGroup?) : BaseViewHolder(viewGroup, R.layout.item_repos) {
    fun onBindData(item: UserReposDao) {
        itemView.tv_name text item.name
        itemView.tv_language text item.language
        itemView.tv_fork text "Fork : ${item.fork?.toString()}"
        itemView.tv_git_url text item.gitUrl
    }
}