package com.bizanalyst.phonepay_clone.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.widget.Toast

@Composable
fun PaymentScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val titles = listOf("POS", "SCAN QR")
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedTab) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { 
                        selectedTab = index 
                        Toast.makeText(context, "$title selected", Toast.LENGTH_SHORT).show()
                    },
                    text = { Text(text = title) }
                )
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            if (selectedTab == 0) {
                Text(text = "POS Content", modifier = Modifier.padding(16.dp))
            } else {
                Text(text = "SCAN QR Content", modifier = Modifier.padding(16.dp))
            }
        }
    }
}
