package tweentyscoops.mvp.kotlin.ui.listrepos

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_repos.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.api.model.UserReposDao
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.ui.base.BaseActivity
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapter
import tweentyscoops.mvp.kotlin.ui.listrepos.adapter.ListReposAdapter

class ListReposActivity : BaseActivity<ListReposContract.View, ListReposPresenter>(),
        ListReposContract.View, BaseListAdapter.OnLoadMoreListener {

    override fun onLoadMore() {

    }

    override fun setListRepos(t: MutableList<UserReposDao>?) {
        adapterListRepos?.setItems(t)
    }

    private var adapterListRepos: ListReposAdapter? = null

    override fun layoutToInflate() = R.layout.activity_list_repos

    override fun doInjection(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun bindView() {

    }

    override fun setupInstance() {
        adapterListRepos = ListReposAdapter()
    }

    override fun setupView() {
        list_repos.layoutManager = LinearLayoutManager(this@ListReposActivity)
        list_repos.adapter = adapterListRepos
        list_repos.setHasFixedSize(false)
        presenter.getUserRepos()
    }

    override fun initialize() {

    }

    override fun saveInstanceState(outState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }
}