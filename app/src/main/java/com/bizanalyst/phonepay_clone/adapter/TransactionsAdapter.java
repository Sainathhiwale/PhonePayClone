package com.bizanalyst.phonepay_clone.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bizanalyst.phonepay_clone.R;
import com.bizanalyst.phonepay_clone.model.TransactionModel;

import java.util.ArrayList;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.MyViewHolder> {

    private ArrayList<TransactionModel> transactionList;
    private Context context;

    public TransactionsAdapter(Context context, ArrayList<TransactionModel> transactionList) {
        this.transactionList = transactionList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_transactions, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mImvTransactionType.setImageResource(transactionList.get(position).getImage_transaction_type());
        holder.mTxvTransactionDate.setText(transactionList.get(position).getTransaction_date());
        holder.mTxvTransactionType.setText(transactionList.get(position).getTransaction_type());
        holder.mTxvTransactionMerchant.setText(transactionList.get(position).getTransaction_merchant());
        holder.mTxvTransactionAmount.setText(transactionList.get(position).getTransaction_amount());
        holder.mTxvTransactionCreditedDebited.setText(transactionList.get(position).getTransaction_credited_debited());
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImvTransactionType;
        private TextView mTxvTransactionDate, mTxvTransactionType, mTxvTransactionMerchant, mTxvTransactionAmount, mTxvTransactionCreditedDebited;

        public MyViewHolder(View itemView) {
            super(itemView);

            mImvTransactionType = itemView.findViewById(R.id.imv_transaction_type);
            mTxvTransactionDate = itemView.findViewById(R.id.txv_transaction_date);
            mTxvTransactionType = itemView.findViewById(R.id.txv_transactions_type);
            mTxvTransactionMerchant = itemView.findViewById(R.id.txv_transaction_merchant);
            mTxvTransactionAmount = itemView.findViewById(R.id.txv_transactions_amount);
            mTxvTransactionCreditedDebited = itemView.findViewById(R.id.txv_transaction_credited_debited);
        }
    }
}
