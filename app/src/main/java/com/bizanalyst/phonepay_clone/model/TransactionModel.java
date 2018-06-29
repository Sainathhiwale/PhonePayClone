package com.bizanalyst.phonepay_clone.model;

public class TransactionModel {
    private int image_transaction_type;
    private String transaction_date, transaction_type, transaction_merchant, transaction_amount, transaction_credited_debited;

    public TransactionModel(int image_transaction_type, String transaction_date, String transaction_type, String transaction_merchant, String transaction_amount, String transaction_credited_debited) {
        this.image_transaction_type = image_transaction_type;
        this.transaction_date = transaction_date;
        this.transaction_type = transaction_type;
        this.transaction_merchant = transaction_merchant;
        this.transaction_amount = transaction_amount;
        this.transaction_credited_debited = transaction_credited_debited;
    }

    public int getImage_transaction_type() {
        return image_transaction_type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public String getTransaction_merchant() {
        return transaction_merchant;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public String getTransaction_credited_debited() {
        return transaction_credited_debited;
    }
}
