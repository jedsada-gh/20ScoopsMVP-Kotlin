package tweentyscoops.mvp.kotlin.ui.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.api.model.UserInfoDao
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.extensions.hide
import tweentyscoops.mvp.kotlin.extensions.loadImage
import tweentyscoops.mvp.kotlin.extensions.title
import tweentyscoops.mvp.kotlin.extensions.toast
import tweentyscoops.mvp.kotlin.ui.base.BaseActivity

class MainActivity : BaseActivity<MainContract.View, MainPresenter>(), MainContract.View {

    override fun userInfoData(userInfo: UserInfoDao?) {
        toast(userInfo?.name!!)
    }

    override fun layoutToInflate() = R.layout.activity_main

    override fun doInjection(appComponent: ApplicationComponent) = appComponent.inject(this)

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun bindView() {
        presenter.requestUserInfo("pondthaitay")
    }

    override fun setupInstance() {

    }

    override fun setupView() {
        tv_result title "Test Title"
        tv_result.hide()
        img_test loadImage "http://ainhoaweb.es/wp-content/uploads/2016/01/Gatos-y-perros-graciosos-26.jpg"
    }

    override fun initialize() {

    }

    override fun saveInstanceState(outState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }
}