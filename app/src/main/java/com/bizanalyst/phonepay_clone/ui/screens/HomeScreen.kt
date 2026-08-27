package com.bizanalyst.phonepay_clone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bizanalyst.phonepay_clone.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import com.bizanalyst.phonepay_clone.model.OfferBanner


@Composable
fun HomeScreen() {
    val banners = listOf(
        OfferBanner("saveSBI visa card, get 30%*!", Icons.Default.CreditCard),
        OfferBanner("4 free lounges visit with sbi*!", Icons.AutoMirrored.Filled.AirplaneTicket),
        OfferBanner("trade with 0 brokerage *!", Icons.AutoMirrored.Filled.TrendingUp),
        OfferBanner("Health Insurance at 25% * Off!", Icons.AutoMirrored.Filled.AirplaneTicket),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.txt_money_transfers),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeActionItem(stringResource(id = R.string.txt_to_contact), Icons.Default.Person)
                HomeActionItem(stringResource(id = R.string.txt_to_account), Icons.Default.AccountBalance)
                HomeActionItem(stringResource(id = R.string.txt_to_self), Icons.Default.Smartphone)
                HomeActionItem(stringResource(id = R.string.txt_split_bill), Icons.Default.Group)
            }
        }

        Spacer(modifier = Modifier.height(8.dp).fillMaxWidth().background(Color(0xFFEEEEEE)))

        // New Single-Liner Offers Section
        Column(modifier = Modifier.padding(vertical = 12.dp)) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(banners) { banner ->
                    Card(
                        modifier = Modifier.wrapContentWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5)) // Light Purple background
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Icon(
                                imageVector = banner.icon,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = Color(0xFF673AB7)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = banner.title,
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp).fillMaxWidth().background(Color(0xFFEEEEEE)))

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.txt_recharge_pay_bills),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeActionItem(stringResource(id = R.string.txt_mobile), Icons.Default.PhoneAndroid)
                HomeActionItem(stringResource(id = R.string.txt_electricity), Icons.Default.Lightbulb)
                HomeActionItem(stringResource(id = R.string.txt_credit_card), Icons.Default.CreditCard)
                HomeActionItem(stringResource(id = R.string.txt_broadband), Icons.Default.Router)
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp).fillMaxWidth().background(Color(0xFFEEEEEE)))

        // Loans Section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.title_loans),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeActionItem(stringResource(id = R.string.txt_personal_loan), Icons.Default.Payments)
                HomeActionItem(stringResource(id = R.string.txt_mutual_fund_loan), Icons.AutoMirrored.Filled.TrendingUp)
                HomeActionItem(stringResource(id = R.string.txt_gold_loan), Icons.Default.Savings)
                HomeActionItem(stringResource(id = R.string.txt_credit_score), Icons.Default.Speed)
            }
        }

        Spacer(modifier = Modifier.height(8.dp).fillMaxWidth().background(Color(0xFFEEEEEE)))

        // Precious Metals Section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.title_precious_metals),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeActionItem(stringResource(id = R.string.txt_daily_gold), Icons.Default.Paid)
                HomeActionItem(stringResource(id = R.string.txt_buy_gold), Icons.Default.AccountBalanceWallet)
                HomeActionItem(stringResource(id = R.string.txt_daily_silver), Icons.Default.Stars)
                HomeActionItem(stringResource(id = R.string.txt_daily_platinum), Icons.Default.Diamond)
            }
        }

        Spacer(modifier = Modifier.height(8.dp).fillMaxWidth().background(Color(0xFFEEEEEE)))
        
        // Buy on PhonePe section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.txt_buy_on_phonepe),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                HomeActionItem(stringResource(id = R.string.txt_gift_cards), Icons.Default.CardGiftcard)
                Spacer(modifier = Modifier.width(16.dp))
                HomeActionItem(stringResource(id = R.string.txt_red_bus), Icons.Default.DirectionsBus)
            }
        }
    }
}

@Composable
fun HomeActionItem(label: String, icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp)
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.secondaryContainer,
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.padding(12.dp)
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            maxLines = 2
        )
    }
}
