package tweentyscoops.mvp.kotlin.ui.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_test.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.extensions.inflate
import tweentyscoops.mvp.kotlin.extensions.text

class FragmentTest : Fragment() {

    companion object {
        fun newInstance(number: Int): FragmentTest {
            val fragment = FragmentTest()
            val bundle = Bundle()
            bundle.putInt("number", number)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            container?.inflate(R.layout.fragment_test)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_number text "Number : ${arguments.getInt("number", 0)}"
    }
}
