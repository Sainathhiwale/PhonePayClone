package com.bizanalyst.phonepay_clone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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

@Composable
fun AccountScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Profile Section
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = Color.Gray
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = stringResource(id = R.string.txt_name_initials),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = stringResource(id = R.string.txt_mobile_number), fontWeight = FontWeight.Bold)
                Text(text = stringResource(id = R.string.txt_user_name), color = Color.Gray)
            }
        }

        HorizontalDivider(color = Color.LightGray)

        AccountMenuItem(stringResource(id = R.string.txt_bhim_upi_id), Icons.Default.PersonPin)
        
        Spacer(modifier = Modifier.height(8.dp).fillMaxWidth().background(Color(0xFFEEEEEE)))

        AccountMenuItem(stringResource(id = R.string.txt_bank_account), Icons.Default.AccountBalance)
        HorizontalDivider(color = Color.LightGray)
        AccountMenuItem(stringResource(id = R.string.txt_wallets), Icons.Default.Wallet)
        HorizontalDivider(color = Color.LightGray)
        AccountMenuItem(stringResource(id = R.string.txt_saved_cards), Icons.Default.CreditCard)

        Spacer(modifier = Modifier.height(8.dp).fillMaxWidth().background(Color(0xFFEEEEEE)))

        AccountMenuItem(stringResource(id = R.string.txt_manage_autopay), Icons.Default.Autorenew)
        
        Spacer(modifier = Modifier.height(8.dp).fillMaxWidth().background(Color(0xFFEEEEEE)))

        AccountMenuItem(stringResource(id = R.string.txt_invite_and_earn), Icons.Default.CardGiftcard)
        HorizontalDivider(color = Color.LightGray)
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Language, contentDescription = null, tint = Color.Gray)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = stringResource(id = R.string.txt_language), modifier = Modifier.weight(1f))
            Text(text = stringResource(id = R.string.txt_english), color = Color.Blue, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun AccountMenuItem(title: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Color.Gray)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title)
    }
}
