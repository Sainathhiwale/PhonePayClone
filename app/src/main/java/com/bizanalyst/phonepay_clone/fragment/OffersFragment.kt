package com.bizanalyst.phonepay_clone.fragment

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.adapter.MerchantsAdapter
import com.bizanalyst.phonepay_clone.adapter.OffersAdapter
import com.bizanalyst.phonepay_clone.adapter.OffersViewPagerAdapter
import com.bizanalyst.phonepay_clone.model.MerchantModel
import com.bizanalyst.phonepay_clone.model.OffersModel
import java.util.*

class OffersFragment : Fragment() {
    private var mContext: Context? = null
    private var mRvOffers: RecyclerView? = null
    private var mRvOfflineMerchants: RecyclerView? = null
    private var mRvOnlineMerchants: RecyclerView? = null
    private var mAdapter: MerchantsAdapter? = null
    private var mViewPager: ViewPager? = null
    private var offerList: ArrayList<String>? = null
    private var dotsLayout: LinearLayout? = null
    private var timer: Timer? = null
    private var count = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_offers, container, false)
        initViews(view)
        setUpViewPager()

        val offlineMerchantList = ArrayList<MerchantModel>()
        offlineMerchantList.add(MerchantModel("KFC", "Flat", resources.getString(R.string.rupees) + "50", resources.getString(R.string.txt_discount_cashback), "Applicable Twice per user"))
        offlineMerchantList.add(MerchantModel("McDonalds", "Steal Deals From", resources.getString(R.string.rupees) + "49*", resources.getString(R.string.txt_discount_onwards), ""))
        offlineMerchantList.add(MerchantModel("CCD", "Get", resources.getString(R.string.txt_discount_30_percent), resources.getString(R.string.txt_discount_cashback), "On 2 purchases every month"))
        offlineMerchantList.add(MerchantModel("Spencers", "Flat", resources.getString(R.string.rupees) + "50", resources.getString(R.string.txt_discount_cashback), "On 2 purchases every month"))
        offlineMerchantList.add(MerchantModel("Apollo", "Flat", resources.getString(R.string.rupees) + "50", resources.getString(R.string.txt_discount_cashback), "On 2 purchases every month"))
        offlineMerchantList.add(MerchantModel("Metro", "Flat", resources.getString(R.string.rupees) + "25", resources.getString(R.string.txt_discount_cashback), "On Transactions of 100 or more"))
        mAdapter = MerchantsAdapter(mContext, offlineMerchantList)
        mRvOfflineMerchants?.adapter = mAdapter

        val onlineMerchantList = ArrayList<MerchantModel>()
        onlineMerchantList.add(MerchantModel("Swiggy", "Get", resources.getString(R.string.txt_discount_25_percent), resources.getString(R.string.txt_discount_cashback), "On 1st and 3rd Transactions"))
        onlineMerchantList.add(MerchantModel("Coolwinks", "Get", resources.getString(R.string.txt_discount_25_percent), resources.getString(R.string.txt_discount_cashback), "On 1st ever Purchase"))
        onlineMerchantList.add(MerchantModel("Faasos", "Get", resources.getString(R.string.txt_discount_30_percent), resources.getString(R.string.txt_discount_cashback), "On 1st and 3rd Transactions"))
        onlineMerchantList.add(MerchantModel("ZopNow", "Upto", resources.getString(R.string.txt_discount_25_percent), resources.getString(R.string.txt_discount_cashback), "On 1st and 3rd Transactions"))
        onlineMerchantList.add(MerchantModel("Box8", "Get", resources.getString(R.string.txt_discount_30_percent), resources.getString(R.string.txt_discount_cashback), "On 1st Transaction"))
        onlineMerchantList.add(MerchantModel("Clovia", "Get", resources.getString(R.string.txt_discount_10_percent), resources.getString(R.string.txt_discount_cashback), "On 1st Transaction"))
        mAdapter = MerchantsAdapter(mContext, onlineMerchantList)
        mRvOnlineMerchants?.adapter = mAdapter

        val offersList = ArrayList<OffersModel>()
        offersList.add(OffersModel(R.drawable.ic_bill_green, "Bill Payment", "30% CashBack*"))
        offersList.add(OffersModel(R.drawable.ic_recharge_green, "Recharge", "20% CashBack*"))
        offersList.add(OffersModel(R.drawable.ic_lightbulb_green, "Electricity", "15% CashBack*"))
        val adapter = OffersAdapter(mContext, offersList)
        mRvOffers?.adapter = adapter

        mViewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                addBottomDots(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        //timer for auto Sliding
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                activity?.runOnUiThread {
                    if (count <= 5) {
                        mViewPager?.currentItem = count
                        count++
                    } else {
                        count = 0
                        mViewPager?.currentItem = count
                    }
                }
            }
        }, 500, 2000)

        return view
    }

    private fun initViews(view: View) {
        mViewPager = view.findViewById(R.id.view_pager_offers)
        dotsLayout = view.findViewById(R.id.layoutDots)
        mRvOffers = view.findViewById(R.id.rv_bill_pay_offers)
        mRvOfflineMerchants = view.findViewById(R.id.rv_offline_merchants)
        mRvOnlineMerchants = view.findViewById(R.id.rv_online_merchants)
        mRvOfflineMerchants?.isNestedScrollingEnabled = false
        mRvOnlineMerchants?.isNestedScrollingEnabled = false
        val layoutManager = LinearLayoutManager(mContext)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mRvOffers?.layoutManager = layoutManager
        mRvOfflineMerchants?.layoutManager = GridLayoutManager(mContext, 3)
        mRvOnlineMerchants?.layoutManager = GridLayoutManager(mContext, 3)
    }

    private fun setUpViewPager() {
        offerList = ArrayList()
        offerList?.add("Offer 1")
        offerList?.add("Offer 2")
        offerList?.add("Offer 3")
        offerList?.add("Offer 4")
        offerList?.add("Offer 5")
        val viewPagerAdapter = OffersViewPagerAdapter(mContext, offerList)
        mViewPager?.adapter = viewPagerAdapter
        mViewPager?.clipToPadding = false
        mViewPager?.setPadding(40, 0, 40, 20)
        mViewPager?.pageMargin = 20
        addBottomDots(0)
    }

    private fun addBottomDots(currentPage: Int) {
        offerList?.let {
            val mTxvDotsArray = arrayOfNulls<TextView>(it.size)
            dotsLayout?.removeAllViews()
            for (i in mTxvDotsArray.indices) {
                mTxvDotsArray[i] = TextView(mContext)
                mTxvDotsArray[i]?.text = Html.fromHtml("&#8226;")
                mTxvDotsArray[i]?.textSize = 35f
                mTxvDotsArray[i]?.setTextColor(resources.getColor(android.R.color.darker_gray))
                dotsLayout?.addView(mTxvDotsArray[i])
            }
            if (mTxvDotsArray.isNotEmpty()) {
                mTxvDotsArray[currentPage]?.setTextColor(resources.getColor(R.color.grey_400))
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        timer?.cancel()
    }

    companion object {
        @JvmStatic
        fun newInstance(): OffersFragment {
            val fragment = OffersFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}