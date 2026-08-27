package com.bizanalyst.phonepay_clone.model

data class MerchantModel(
    val merchant_name: String?,
    val discount_type: String?,
    val discount_amount: String?,
    val discount_medium: String?,
    val discount_description: String?
)