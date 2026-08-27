package com.bizanalyst.phonepay_clone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.model.OffersModel
import java.util.*

class OffersAdapter(private val context: Context?, private val offersList: ArrayList<OffersModel>) : RecyclerView.Adapter<OffersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_offers, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val offer = offersList[position]
        holder.mImvOffers.setImageResource(offer.image)
        holder.mTxvOfferItem.text = offer.offer_on
        holder.mTxvOfferDetails.text = offer.offer_details
    }

    override fun getItemCount(): Int {
        return offersList.size
    }

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mImvOffers: ImageView = itemView.findViewById(R.id.imv_offer_list)
        val mTxvOfferItem: TextView = itemView.findViewById(R.id.txv_offer_on)
        val mTxvOfferDetails: TextView = itemView.findViewById(R.id.txv_offer_details)
    }
}