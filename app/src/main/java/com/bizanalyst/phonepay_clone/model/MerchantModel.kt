package com.bizanalyst.phonepay_clone.model;

public class MerchantModel {

    private String merchant_name, discount_type, discount_amount, discount_medium, discount_description;

    public MerchantModel(String merchant_name, String discount_type, String discount_amount, String discount_medium, String discount_description) {
        this.merchant_name = merchant_name;
        this.discount_type = discount_type;
        this.discount_amount = discount_amount;
        this.discount_medium = discount_medium;
        this.discount_description = discount_description;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public String getDiscount_medium() {
        return discount_medium;
    }

    public String getDiscount_description() {
        return discount_description;
    }
}