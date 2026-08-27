package com.bizanalyst.phonepay_clone.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bizanalyst.phonepay_clone.R
import com.google.android.material.tabs.TabLayout

class PaymentFragment : Fragment() {
    private var mContext: Context? = null
    private var mTabLayout: TabLayout? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun initViews(view: View) {
        mTabLayout = view.findViewById(R.id.tab_payment)
        mTabLayout?.addTab(mTabLayout!!.newTab().setText("POS"))
        mTabLayout?.addTab(mTabLayout!!.newTab().setText("SCAN QR"))
        mTabLayout?.tabGravity = TabLayout.GRAVITY_FILL
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_payment, container, false)
        initViews(view)
        
        mTabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                if (position == 0) {
                    Toast.makeText(mContext, "POS selected", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(mContext, "SCAN QR selected", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(): PaymentFragment {
            val fragment = PaymentFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}