package tweentyscoops.mvp.kotlin.ui.listreposloadmore

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_repos_load_more.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.ui.base.BaseActivity
import tweentyscoops.mvp.kotlin.ui.listreposloadmore.adapter.ListLoadMoreReposAdapter

class ListReposActivity : BaseActivity<ListReposContract.View, ListReposPresenter>(),
        ListReposContract.View {

    override fun layoutToInflate() = R.layout.activity_list_repos_load_more

    override fun doInjection(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun bindView() {
        val adapter = ListLoadMoreReposAdapter()
        list_repos.layoutManager = LinearLayoutManager(this)
        list_repos.adapter = adapter
        list_repos.setHasFixedSize(false)
    }

    override fun setupInstance() {

    }

    override fun setupView() {

    }

    override fun initialize() {

    }

    override fun saveInstanceState(outState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }
}
