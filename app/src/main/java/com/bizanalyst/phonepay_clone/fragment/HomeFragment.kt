package com.bizanalyst.phonepay_clone.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bizanalyst.phonepay_clone.R
import java.util.*

class HomeFragment : Fragment() {
    private var mContext: Context? = null
    var mViewPager: ViewPager? = null
    var offerList: ArrayList<String>? = null
    private var dotsLayout: LinearLayout? = null
    private var timer: Timer? = null
    private var count = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}