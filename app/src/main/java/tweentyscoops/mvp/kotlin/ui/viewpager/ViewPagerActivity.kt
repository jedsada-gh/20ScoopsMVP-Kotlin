package tweentyscoops.mvp.kotlin.ui.viewpager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_pager.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.ui.viewpager.adapter.ViewPagerAdapter

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        view_pager.adapter = ViewPagerAdapter(supportFragmentManager)
    }
}
