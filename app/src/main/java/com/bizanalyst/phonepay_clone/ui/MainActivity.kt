package com.bizanalyst.phonepay_clone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.ui.screens.*
import com.bizanalyst.phonepay_clone.ui.theme.PhonePayCloneTheme

sealed class Screen(val route: String, val resourceId: Int, val icon: ImageVector) {
    object Home : Screen("home", R.string.title_home, Icons.Default.Home)
    object Offers : Screen("offers", R.string.title_offers, Icons.Default.LocalOffer)
    object Payment : Screen("payment", R.string.title_payment, Icons.Default.Payment)
    object Account : Screen("account", R.string.title_my_account, Icons.Default.AccountCircle)
    object Transactions : Screen("transactions", R.string.title_transactions, Icons.Default.History)
}

val items = listOf(
    Screen.Home,
    Screen.Offers,
    Screen.Payment,
    Screen.Account,
    Screen.Transactions
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhonePayCloneTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.GroupAdd, contentDescription = "Invite")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Offers.route) { OffersScreen() }
            composable(Screen.Payment.route) { PaymentScreen() }
            composable(Screen.Account.route) { AccountScreen() }
            composable(Screen.Transactions.route) { TransactionsScreen() }
        }
    }
}

