package tweentyscoops.mvp.kotlin.ui.listreposloadmore

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_list_repos_load_more.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.api.model.UserReposDao
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.ui.base.BaseActivity
import tweentyscoops.mvp.kotlin.ui.base.adapter.BaseListAdapter
import tweentyscoops.mvp.kotlin.ui.listreposloadmore.adapter.ListLoadMoreReposAdapter

class ListReposActivity : BaseActivity<ListReposContract.View, ListReposPresenter>(),
        ListReposContract.View, BaseListAdapter.OnLoadMoreListener {

    private var adapter: ListLoadMoreReposAdapter? = null

    override fun layoutToInflate() = R.layout.activity_list_repos_load_more

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
        adapter = ListLoadMoreReposAdapter()
        adapter?.setOnLoadmoreListener(this)
    }

    override fun setupView() {
        list_repos.layoutManager = LinearLayoutManager(this)
        list_repos.adapter = adapter
        list_repos.setHasFixedSize(false)
        presenter.getUserRepos("pondthaitay")
    }

    override fun initialize() {
        adapter?.initItemForLoadmore()
    }

    override fun saveInstanceState(outState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }

    override fun setItemReposToList(t: MutableList<UserReposDao>?) {
        adapter?.setItems(t, true)
    }

    override fun onLoadMore() {
        Logger.d("Load more")
    }
}
