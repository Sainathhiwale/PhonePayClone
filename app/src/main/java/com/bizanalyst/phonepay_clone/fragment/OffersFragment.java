package com.bizanalyst.phonepay_clone.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bizanalyst.phonepay_clone.R;
import com.bizanalyst.phonepay_clone.adapter.MerchantsAdapter;
import com.bizanalyst.phonepay_clone.adapter.OffersAdapter;
import com.bizanalyst.phonepay_clone.adapter.OffersViewPagerAdapter;
import com.bizanalyst.phonepay_clone.model.MerchantModel;
import com.bizanalyst.phonepay_clone.model.OffersModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class OffersFragment extends Fragment {

    private Context context;
    private RecyclerView mRvOffers, mRvOfflineMerchants, mRvOnlineMerchants;
    private MerchantsAdapter mAdapter;
    private ViewPager mViewPager;
    private ArrayList<String> offerList;
    private LinearLayout dotsLayout;
    private Timer timer;
    private int count = 0;

    public OffersFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static OffersFragment newInstance() {
        OffersFragment fragment = new OffersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private void initViews(View view) {
        mViewPager= view.findViewById(R.id.view_pager_offers);
        dotsLayout = view.findViewById(R.id.layoutDots);
        mRvOffers = view.findViewById(R.id.rv_bill_pay_offers);
        mRvOfflineMerchants = view.findViewById(R.id.rv_offline_merchants);
        mRvOnlineMerchants = view.findViewById(R.id.rv_online_merchants);
        mRvOfflineMerchants.setNestedScrollingEnabled(false);
        mRvOnlineMerchants.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvOffers.setLayoutManager(layoutManager);
        mRvOfflineMerchants.setLayoutManager(new GridLayoutManager(context, 3));
        mRvOnlineMerchants.setLayoutManager(new GridLayoutManager(context, 3));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offers, container, false);
        initViews(view);
        setUpViewPager();

        ArrayList<MerchantModel> offlineMerchantList = new ArrayList<>();
        offlineMerchantList.add(new MerchantModel("KFC", "Flat",getResources().getString(R.string.rupees) + "50", getResources().getString(R.string.txt_discount_cashback), "Applicable Twice per user"));
        offlineMerchantList.add(new MerchantModel("McDonalds", "Steal Deals From", getResources().getString(R.string.rupees) + "49*", getResources().getString(R.string.txt_discount_onwards), ""));
        offlineMerchantList.add(new MerchantModel("CCD", "Get", getResources().getString(R.string.txt_discount_30_percent), getResources().getString(R.string.txt_discount_cashback), "On 2 purchases every month"));
        offlineMerchantList.add(new MerchantModel("Spencers", "Flat", getResources().getString(R.string.rupees) + "50", getResources().getString(R.string.txt_discount_cashback), "On 2 purchases every month"));
        offlineMerchantList.add(new MerchantModel("Apollo", "Flat", getResources().getString(R.string.rupees) + "50", getResources().getString(R.string.txt_discount_cashback), "On 2 purchases every month"));
        offlineMerchantList.add(new MerchantModel("Metro", "Flat", getResources().getString(R.string.rupees) + "25", getResources().getString(R.string.txt_discount_cashback), "On Transactions of 100 or more"));
        mAdapter = new MerchantsAdapter(context, offlineMerchantList);
        mRvOfflineMerchants.setAdapter(mAdapter);

        ArrayList<MerchantModel> onlineMerchantList = new ArrayList<>();
        onlineMerchantList.add(new MerchantModel("Swiggy", "Get", getResources().getString(R.string.txt_discount_25_percent), getResources().getString(R.string.txt_discount_cashback), "On 1st and 3rd Transactions"));
        onlineMerchantList.add(new MerchantModel("Coolwinks", "Get", getResources().getString(R.string.txt_discount_25_percent), getResources().getString(R.string.txt_discount_cashback), "On 1st ever Purchase"));
        onlineMerchantList.add(new MerchantModel("Faasos", "Get", getResources().getString(R.string.txt_discount_30_percent), getResources().getString(R.string.txt_discount_cashback), "On 1st and 3rd Transactions"));
        onlineMerchantList.add(new MerchantModel("ZopNow", "Upto", getResources().getString(R.string.txt_discount_25_percent), getResources().getString(R.string.txt_discount_cashback), "On 1st and 3rd Transactions"));
        onlineMerchantList.add(new MerchantModel("Box8", "Get", getResources().getString(R.string.txt_discount_30_percent), getResources().getString(R.string.txt_discount_cashback), "On 1st Transaction"));
        onlineMerchantList.add(new MerchantModel("Clovia", "Get", getResources().getString(R.string.txt_discount_10_percent), getResources().getString(R.string.txt_discount_cashback), "On 1st Transaction"));
        mAdapter = new MerchantsAdapter(context, onlineMerchantList);
        mRvOnlineMerchants.setAdapter(mAdapter);

        ArrayList<OffersModel> offersList = new ArrayList<>();
        offersList.add(new OffersModel(R.drawable.ic_bill_green, "Bill Payment", "30% CashBack*"));
        offersList.add(new OffersModel(R.drawable.ic_recharge_green, "Recharge", "20% CashBack*"));
        offersList.add(new OffersModel(R.drawable.ic_lightbulb_green, "Electricity", "15% CashBack*"));
        OffersAdapter adapter = new OffersAdapter(context, offersList);
        mRvOffers.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //timer for auto Sliding
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(() -> {
                    if (count <= 5) {
                        mViewPager.setCurrentItem(count);
                        count++;
                    } else {
                        count = 0;
                        mViewPager.setCurrentItem(count);

                    }
                });
            }
        }, 500, 2000);

        return view;
    }

    private void setUpViewPager() {
        offerList = new ArrayList<>();
        offerList.add("Offer 1");
        offerList.add("Offer 2");
        offerList.add("Offer 3");
        offerList.add("Offer 4");
        offerList.add("Offer 5");
        OffersViewPagerAdapter viewPagerAdapter = new OffersViewPagerAdapter(context, offerList);
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setClipToPadding(false);
        mViewPager.setPadding(40, 0, 40, 20);
        mViewPager.setPageMargin(20);
        addBottomDots(0);
    }

    private void addBottomDots(int currentPage) {
        TextView[] mTxvDotsArray = new TextView[offerList.size()];

        dotsLayout.removeAllViews();
        for (int i = 0; i < mTxvDotsArray.length; i++) {
            mTxvDotsArray[i] = new TextView(context);
            mTxvDotsArray[i].setText(Html.fromHtml("&#8226;"));
            mTxvDotsArray[i].setTextSize(35);
            mTxvDotsArray[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            dotsLayout.addView(mTxvDotsArray[i]);
        }


        if (mTxvDotsArray.length > 0)
            mTxvDotsArray[currentPage].setTextColor(getResources().getColor(R.color.grey_400));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        timer.cancel();
    }
}
