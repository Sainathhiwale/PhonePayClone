package com.bizanalyst.phonepay_clone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.ExperimentalFoundationApi
import com.bizanalyst.phonepay_clone.model.OfferBanner
import com.bizanalyst.phonepay_clone.model.PromoBanner


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val banners = listOf(
        OfferBanner("saveSBI visa card, get 30%*!", Icons.Default.CreditCard),
        OfferBanner("4 free lounges visit with sbi*!", Icons.AutoMirrored.Filled.AirplaneTicket),
        OfferBanner("trade with 0 brokerage *!", Icons.AutoMirrored.Filled.TrendingUp),
        OfferBanner("Health Insurance at 25% * Off!", Icons.AutoMirrored.Filled.AirplaneTicket),
    )

    val promoBanners = listOf(
        PromoBanner("💡 DID YOU KNOW?", "Paying rent via Credit Card earns reward points", "2.5% processing fee applies*", "Step 1 of 3: Add Landlord Bank Details", 0.33f, "Pay Rent Now"),
        PromoBanner("⚡ PRO TIP", "Pay bills 3 days before the due date to boost your CIBIL score", "0% late payment fee + Up to ₹500 cashback", "Step 2 of 4: Verify Outstanding Balance", 0.50f, "Clear Dues"),
        PromoBanner("⛽ SAVE EXTRA", "Use your fuel-variant card at partnered fuel stations", "1% surcharge waiver on ₹400 - ₹5,000 spends", "Monthly Cap: ₹250 / ₹500 saved", 0.50f, "Find Partner Pumps"),
        PromoBanner("💡 DID YOU KNOW?", "Set up Auto-Pay for electricity and water bills", "Earn 5X reward points on every ₹100 spent", "Setup: Auto-Debit Activation", 1.0f, "Enable Auto-Pay"),
        PromoBanner("🎯 MILESTONE UNLOCK", "Spend ₹15,000 more this quarter to waive annual fees", "Save ₹1,500 + Get a ₹1,000 Gift Voucher", "Quarterly Spends: ₹85,000 / ₹1,00,000", 0.85f, "Track Spends"),
        PromoBanner("📲 TAP & PAY", "Link your RuPay Credit Card directly to UPI", "Zero fee on merchant QR scan payments", "Step 2 of 3: Set UPI PIN", 0.66f, "Link Card to UPI"),
        PromoBanner("🎓 SMART PAY", "Pay school or college fees in flexible 6-month EMIs", "Low interest rate starting at 1.15% per month", "Step 1 of 4: Enter Institute Details", 0.25f, "Convert to EMI"),
        PromoBanner("✈️ TRAVEL PERK", "You have complimentary domestic lounge visits remaining", "Free entry + complimentary food (Normally ₹1,800/visit)", "Quarterly Visits Used: 1 of 2", 0.50f, "Generate QR Pass")
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

        // Promo Banners Section (Horizontal Carousel)
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            val pagerState = rememberPagerState(pageCount = { promoBanners.size })
            
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 40.dp),
                pageSpacing = 12.dp,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                PromoBannerItem(
                    banner = promoBanners[page],
                    isSelected = pagerState.currentPage == page
                )
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
fun PromoBannerItem(banner: PromoBanner, isSelected: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF4D148C)) // PhonePe Dark Purple
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 8.dp, top = 12.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Did you know?",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.LightGray.copy(alpha = 0.8f)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = banner.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.weight(1f, fill = false)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(
                            modifier = Modifier.size(24.dp),
                            shape = CircleShape,
                            color = Color.White
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp),
                                    tint = Color(0xFF4D148C)
                                )
                            }
                        }
                    }
                }
                
                // Building Illustration Placeholder
                Icon(
                    imageVector = Icons.Default.Business,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(start = 8.dp),
                    tint = Color.White.copy(alpha = 0.2f)
                )
            }

            // Bottom Segmented Progress Indicator
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // In a real app, this would be based on the pager state
                // For simplicity in the item, we'll just show the concept
                repeat(4) { index ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(2.dp)
                            .background(
                                if (isSelected && index == 0) Color.White 
                                else Color.White.copy(alpha = 0.3f)
                            )
                    )
                }
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
