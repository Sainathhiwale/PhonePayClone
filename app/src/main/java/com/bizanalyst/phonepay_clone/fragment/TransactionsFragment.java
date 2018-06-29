package com.bizanalyst.phonepay_clone.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bizanalyst.phonepay_clone.R;
import com.bizanalyst.phonepay_clone.adapter.TransactionsAdapter;
import com.bizanalyst.phonepay_clone.model.TransactionModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class TransactionsFragment extends Fragment {
    private Context context;
    private RecyclerView mRecyclerview;

    public TransactionsFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static TransactionsFragment newInstance() {
        TransactionsFragment fragment = new TransactionsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private void initViews(View view) {
        mRecyclerview = view.findViewById(R.id.rv_transactions);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);
        initViews(view);

        ArrayList<TransactionModel> transactionList = new ArrayList<>();
        transactionList.add(new TransactionModel(R.drawable.ic_to_contact, "2 days ago", "Paid to",
                "Swiggy", getResources().getString(R.string.rupees) + "250", "Debited from"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_contact, "3 days ago", "Paid to",
                "Zomato", getResources().getString(R.string.rupees) + "150", "Debited from"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_account, "3 days ago", "Cashback from",
                "Mojo Pizza", getResources().getString(R.string.rupees) + "50", "Credited to"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_contact, "3 days ago", "Paid to",
                "Mojo Pizza", getResources().getString(R.string.rupees) + "150", "Debited from"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_account, "4 days ago", "Cashback from",
                "Mojo Pizza", getResources().getString(R.string.rupees) + "50", "Credited to"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_contact, "4 days ago", "Paid to",
                "Mojo Pizza", getResources().getString(R.string.rupees) + "150", "Debited from"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_contact, "5 days ago", "Paid to",
                "Flipkart", getResources().getString(R.string.rupees) + "250", "Debited from"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_contact, "5 days ago", "Paid to",
                "Amazon", getResources().getString(R.string.rupees) + "150", "Debited from"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_contact, "6 days ago", "Paid to",
                "Google Play", getResources().getString(R.string.rupees) + "250", "Debited from"));
        transactionList.add(new TransactionModel(R.drawable.ic_to_contact, "6 days ago", "Paid to",
                "Amazon", getResources().getString(R.string.rupees) + "150", "Debited from"));
        TransactionsAdapter adapter = new TransactionsAdapter(context, transactionList);
        mRecyclerview.setAdapter(adapter);
        return view;
    }

}
