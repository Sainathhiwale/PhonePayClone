package com.bizanalyst.phonepay_clone.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.adapter.TransactionsAdapter
import com.bizanalyst.phonepay_clone.model.TransactionModel
import java.util.*

class TransactionsFragment : Fragment() {
    private var mContext: Context? = null
    private var mRecyclerview: RecyclerView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun initViews(view: View) {
        mRecyclerview = view.findViewById(R.id.rv_transactions)
        mRecyclerview?.layoutManager = LinearLayoutManager(mContext)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_transactions, container, false)
        initViews(view)
        val transactionList = ArrayList<TransactionModel>()
        transactionList.add(TransactionModel(R.drawable.ic_to_contact, "2 days ago", "Paid to",
            "Swiggy", resources.getString(R.string.rupees) + "250", "Debited from"))
        transactionList.add(TransactionModel(R.drawable.ic_to_contact, "3 days ago", "Paid to",
            "Zomato", resources.getString(R.string.rupees) + "150", "Debited from"))
        transactionList.add(TransactionModel(R.drawable.ic_to_account, "3 days ago", "Cashback from",
            "Mojo Pizza", resources.getString(R.string.rupees) + "50", "Credited to"))
        transactionList.add(TransactionModel(R.drawable.ic_to_contact, "3 days ago", "Paid to",
            "Mojo Pizza", resources.getString(R.string.rupees) + "150", "Debited from"))
        transactionList.add(TransactionModel(R.drawable.ic_to_account, "4 days ago", "Cashback from",
            "Mojo Pizza", resources.getString(R.string.rupees) + "50", "Credited to"))
        transactionList.add(TransactionModel(R.drawable.ic_to_contact, "4 days ago", "Paid to",
            "Mojo Pizza", resources.getString(R.string.rupees) + "150", "Debited from"))
        transactionList.add(TransactionModel(R.drawable.ic_to_contact, "5 days ago", "Paid to",
            "Flipkart", resources.getString(R.string.rupees) + "250", "Debited from"))
        transactionList.add(TransactionModel(R.drawable.ic_to_contact, "5 days ago", "Paid to",
            "Amazon", resources.getString(R.string.rupees) + "150", "Debited from"))
        transactionList.add(TransactionModel(R.drawable.ic_to_contact, "6 days ago", "Paid to",
            "Google Play", resources.getString(R.string.rupees) + "250", "Debited from"))
        transactionList.add(TransactionModel(R.drawable.ic_to_contact, "6 days ago", "Paid to",
            "Amazon", resources.getString(R.string.rupees) + "150", "Debited from"))
        val adapter = TransactionsAdapter(mContext, transactionList)
        mRecyclerview?.adapter = adapter
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(): TransactionsFragment {
            val fragment = TransactionsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}