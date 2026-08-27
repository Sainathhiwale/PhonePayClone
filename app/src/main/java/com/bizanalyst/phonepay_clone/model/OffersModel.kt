package com.bizanalyst.phonepay_clone.model;

public class OffersModel {

    private int image;
    private String offer_on;
    private String offer_details;

    public OffersModel(int image, String offer_on, String offer_details) {
        this.image = image;
        this.offer_on = offer_on;
        this.offer_details = offer_details;
    }

    public int getImage() {
        return image;
    }

    public String getOffer_on() {
        return offer_on;
    }

    public String getOffer_details() {
        return offer_details;
    }

}