package com.bizanalyst.phonepay_clone.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.model.MerchantModel
import com.bizanalyst.phonepay_clone.model.OffersModel

@Composable
fun OffersScreen() {
    val offersList = listOf(
        OffersModel(R.drawable.ic_bill_green, "Bill Payment", "30% CashBack*"),
        OffersModel(R.drawable.ic_recharge_green, "Recharge", "20% CashBack*"),
        OffersModel(R.drawable.ic_lightbulb_green, "Electricity", "15% CashBack*")
    )

    val offlineMerchantList = listOf(
        MerchantModel("KFC", "Flat", "₹50", "Cashback", "Applicable Twice per user"),
        MerchantModel("McDonalds", "Steal Deals From", "₹49*", "Onwards", ""),
        MerchantModel("CCD", "Get", "30%", "Cashback", "On 2 purchases every month"),
        MerchantModel("Spencers", "Flat", "₹50", "Cashback", "On 2 purchases every month"),
        MerchantModel("Apollo", "Flat", "₹50", "Cashback", "On 2 purchases every month"),
        MerchantModel("Metro", "Flat", "₹25", "Cashback", "On Transactions of 100 or more")
    )

    val onlineMerchantList = listOf(
        MerchantModel("Swiggy", "Get", "25%", "Cashback", "On 1st and 3rd Transactions"),
        MerchantModel("Coolwinks", "Get", "25%", "Cashback", "On 1st ever Purchase"),
        MerchantModel("Faasos", "Get", "30%", "Cashback", "On 1st and 3rd Transactions"),
        MerchantModel("ZopNow", "Upto", "25%", "Cashback", "On 1st and 3rd Transactions"),
        MerchantModel("Box8", "Get", "30%", "Cashback", "On 1st Transaction"),
        MerchantModel("Clovia", "Get", "10%", "Cashback", "On 1st Transaction")
    )

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        item {
            Text(text = "Popular Offers", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(offersList) { offer ->
                    Card(modifier = Modifier.width(150.dp)) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Icon(painter = painterResource(id = offer.image), contentDescription = null, modifier = Modifier.size(24.dp))
                            Text(text = offer.offer_on ?: "", fontWeight = FontWeight.Bold)
                            Text(text = offer.offer_details ?: "", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.txt_offline_merchants), style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            MerchantGrid(offlineMerchantList)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.txt_online_merchants), style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            MerchantGrid(onlineMerchantList)
        }
    }
}

@Composable
fun MerchantGrid(merchants: List<MerchantModel>) {
    Column {
        merchants.chunked(3).forEach { rowMerchants ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                rowMerchants.forEach { merchant ->
                    Card(modifier = Modifier.weight(1f).padding(vertical = 4.dp)) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = merchant.merchant_name ?: "", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodySmall)
                            Text(text = "${merchant.discount_type} ${merchant.discount_amount}", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
                repeat(3 - rowMerchants.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
