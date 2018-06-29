package com.bizanalyst.phonepay_clone.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bizanalyst.phonepay_clone.R;

import java.util.ArrayList;
import java.util.Timer;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Context context;
    ViewPager mViewPager;
    ArrayList<String> offerList;
    private LinearLayout dotsLayout;
    private Timer timer;
    private int count = 0;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
