package com.bizanalyst.phonepay_clone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bizanalyst.phonepay_clone.R
import java.util.*

class OffersViewPagerAdapter(private val context: Context?, private val offersList: ArrayList<String>?) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout_offers_viewpager, container, false)
        val txvOffer = view.findViewById<TextView>(R.id.txv_lay_1)
        txvOffer.text = offersList?.get(position)
        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return offersList?.size ?: 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}