package com.bizanalyst.phonepay_clone.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bizanalyst.phonepay_clone.R;

public class PaymentFragment extends Fragment {

    private Context context;
    private TabLayout mTabLayout;

    public PaymentFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static PaymentFragment newInstance() {
        PaymentFragment fragment = new PaymentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private void initViews(View view) {
        mTabLayout = view.findViewById(R.id.tab_payment);
        mTabLayout.addTab(mTabLayout.newTab().setText("POS"));
        mTabLayout.addTab(mTabLayout.newTab().setText("SCAN QR"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        initViews(view);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    Toast.makeText(context, "POS selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "SCAN QR selected", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return view;
    }

}
