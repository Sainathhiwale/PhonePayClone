package com.bizanalyst.phonepay_clone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.model.MerchantModel
import java.util.*

class MerchantsAdapter(private val context: Context?, private val merchantList: ArrayList<MerchantModel>) : RecyclerView.Adapter<MerchantsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_merchants, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val merchant = merchantList[position]
        holder.mTxvMerchantName.text = merchant.merchant_name
        holder.mTxvDiscountType.text = merchant.discount_type
        holder.mTxvDiscountAmount.text = merchant.discount_amount
        holder.mTxvDiscountMedium.text = merchant.discount_medium
        holder.mTxvDiscountDescription.text = merchant.discount_description
    }

    override fun getItemCount(): Int {
        return merchantList.size
    }

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTxvMerchantName: TextView = itemView.findViewById(R.id.txv_merchant_name)
        val mTxvDiscountType: TextView = itemView.findViewById(R.id.txv_discount_type)
        val mTxvDiscountAmount: TextView = itemView.findViewById(R.id.txv_discount_amount)
        val mTxvDiscountMedium: TextView = itemView.findViewById(R.id.txv_discount_medium)
        val mTxvDiscountDescription: TextView = itemView.findViewById(R.id.txv_discount_description)
    }
}