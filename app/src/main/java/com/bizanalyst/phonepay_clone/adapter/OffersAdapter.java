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
import com.bizanalyst.phonepay_clone.model.OffersModel;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.MyViewHolder> {

    private ArrayList<OffersModel> offersList;
    private Context context;

    public OffersAdapter(Context context, ArrayList<OffersModel> offersList) {
        this.offersList = offersList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offers, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mImvOffers.setImageResource(offersList.get(position).getImage());
        holder.mTxvOfferItem.setText(offersList.get(position).getOffer_on());
        holder.mTxvOfferDetails.setText(offersList.get(position).getOffer_details());
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImvOffers;
        private TextView mTxvOfferItem, mTxvOfferDetails;

        public MyViewHolder(View itemView) {
            super(itemView);

            mImvOffers = itemView.findViewById(R.id.imv_offer_list);
            mTxvOfferItem = itemView.findViewById(R.id.txv_offer_on);
            mTxvOfferDetails = itemView.findViewById(R.id.txv_offer_details);
        }
    }
}
