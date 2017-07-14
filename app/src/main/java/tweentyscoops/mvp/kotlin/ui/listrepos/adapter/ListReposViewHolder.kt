package tweentyscoops.mvp.kotlin.ui.listrepos.adapter

import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_repos.view.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.api.model.UserRepos
import tweentyscoops.mvp.kotlin.extensions.text
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseViewHolder

class ListReposViewHolder(viewGroup: ViewGroup?) : BaseViewHolder(viewGroup, R.layout.item_repos) {
    fun onBindData(item: UserRepos) {
        itemView.tv_name text item.name
        itemView.tv_language text item.language
        itemView.tv_fork text "Fork : ${item.fork?.toString()}"
        itemView.tv_git_url text item.gitUrl
    }
}