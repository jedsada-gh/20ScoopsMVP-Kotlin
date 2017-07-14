package tweentyscoops.mvp.kotlin.ui.listrepos

import tweentyscoops.mvp.kotlin.api.model.UserRepos
import tweentyscoops.mvp.kotlin.ui.base.BaseContract

class ListReposContract {

    interface View : BaseContract.View {
        fun setListRepos(t: MutableList<UserRepos>?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun getUserRepos(username: String? = null)
    }
}