package com.bizanalyst.phonepay_clone.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.model.TransactionModel

@Composable
fun TransactionsScreen() {
    // This is where your data is defined (previously in Fragment or ViewModel)
    val transactions = listOf(
        TransactionModel(R.drawable.ic_to_contact, "2 days ago", "Paid to", "Swiggy", "₹250", "Debited from"),
        TransactionModel(R.drawable.ic_to_contact, "3 days ago", "Paid to", "Zomato", "₹150", "Debited from"),
        TransactionModel(R.drawable.ic_to_account, "3 days ago", "Cashback from", "Mojo Pizza", "₹50", "Credited to"),
        TransactionModel(R.drawable.ic_to_contact, "3 days ago", "Paid to", "Mojo Pizza", "₹150", "Debited from"),
        TransactionModel(R.drawable.ic_to_account, "4 days ago", "Cashback from", "Mojo Pizza", "₹50", "Credited to"),
        TransactionModel(R.drawable.ic_to_contact, "4 days ago", "Paid to", "Mojo Pizza", "₹150", "Debited from"),
        TransactionModel(R.drawable.ic_to_contact, "5 days ago", "Paid to", "Flipkart", "₹250", "Debited from"),
        TransactionModel(R.drawable.ic_to_contact, "5 days ago", "Paid to", "Amazon", "₹150", "Debited from"),
        TransactionModel(R.drawable.ic_to_contact, "6 days ago", "Paid to", "Google Play", "₹250", "Debited from"),
        TransactionModel(R.drawable.ic_to_contact, "6 days ago", "Paid to", "Amazon", "₹150", "Debited from")
    )

    // LazyColumn handles the "binding" by passing each model to TransactionItem
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(transactions) { transaction ->
            TransactionItem(transaction)
            HorizontalDivider(color = Color.LightGray, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}

@Composable
fun TransactionItem(transaction: TransactionModel) {
    // This function replaces the old ViewHolder 'bind' method
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = transaction.image_transaction_type),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = transaction.transaction_merchant ?: "", fontWeight = FontWeight.Bold)
            Text(text = "${transaction.transaction_type} • ${transaction.transaction_date}", style = MaterialTheme.typography.bodySmall)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = transaction.transaction_amount ?: "", fontWeight = FontWeight.Bold)
            Text(text = transaction.transaction_credited_debited ?: "", style = MaterialTheme.typography.bodySmall)
        }
    }
}
