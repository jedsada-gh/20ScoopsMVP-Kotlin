package tweentyscoops.mvp.kotlin.ui.listrepos

import tweentyscoops.mvp.kotlin.api.model.UserReposDao
import tweentyscoops.mvp.kotlin.ui.base.BaseContract

class ListReposContract {

    interface View : BaseContract.View {
        fun setListRepos(t: MutableList<UserReposDao>?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun getUserRepos(username: String? = null)
    }
}