package com.bizanalyst.phonepay_clone.adapter;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bizanalyst.phonepay_clone.R;

import java.util.ArrayList;

public class OffersViewPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<String> offersList;

    public OffersViewPagerAdapter(Context context, ArrayList<String> offersList) {
        this.context = context;
        this.offersList = offersList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_offers_viewpager, container, false);
        TextView txvOffer = view.findViewById(R.id.txv_lay_1);
        txvOffer.setText(offersList.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return offersList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
