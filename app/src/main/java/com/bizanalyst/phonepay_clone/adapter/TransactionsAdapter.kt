package com.bizanalyst.phonepay_clone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.model.TransactionModel
import java.util.*

class TransactionsAdapter(private val context: Context?, private val transactionList: ArrayList<TransactionModel>) : RecyclerView.Adapter<TransactionsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_transactions, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val transaction = transactionList[position]
        holder.mImvTransactionType.setImageResource(transaction.image_transaction_type)
        holder.mTxvTransactionDate.text = transaction.transaction_date
        holder.mTxvTransactionType.text = transaction.transaction_type
        holder.mTxvTransactionMerchant.text = transaction.transaction_merchant
        holder.mTxvTransactionAmount.text = transaction.transaction_amount
        holder.mTxvTransactionCreditedDebited.text = transaction.transaction_credited_debited
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mImvTransactionType: ImageView = itemView.findViewById(R.id.imv_transaction_type)
        val mTxvTransactionDate: TextView = itemView.findViewById(R.id.txv_transaction_date)
        val mTxvTransactionType: TextView = itemView.findViewById(R.id.txv_transactions_type)
        val mTxvTransactionMerchant: TextView = itemView.findViewById(R.id.txv_transaction_merchant)
        val mTxvTransactionAmount: TextView = itemView.findViewById(R.id.txv_transactions_amount)
        val mTxvTransactionCreditedDebited: TextView = itemView.findViewById(R.id.txv_transaction_credited_debited)
    }
}