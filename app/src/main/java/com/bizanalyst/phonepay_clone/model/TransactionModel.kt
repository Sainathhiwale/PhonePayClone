package com.bizanalyst.phonepay_clone.model

data class TransactionModel(
    val image_transaction_type: Int,
    val transaction_date: String?,
    val transaction_type: String?,
    val transaction_merchant: String?,
    val transaction_amount: String?,
    val transaction_credited_debited: String?
)