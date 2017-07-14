package tweentyscoops.mvp.kotlin.ui.main

import tweentyscoops.mvp.kotlin.api.model.UserInfoDao
import tweentyscoops.mvp.kotlin.ui.base.BaseContract

class MainContract {

    interface View : BaseContract.View {
        fun userInfoData(userInfo: UserInfoDao?)
        fun updateText(message: String?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun requestUserInfo(username: String?)
    }
}