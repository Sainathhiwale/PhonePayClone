package com.bizanalyst.phonepay_clone.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.bizanalyst.phonepay_clone.R
import com.bizanalyst.phonepay_clone.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private var mToolbar: Toolbar? = null
    private var mTxvToolbarTitle: TextView? = null
    private var mBottomNavigationView: BottomNavigationView? = null
    private var homeFragment: HomeFragment? = null
    private var accountFragment: AccountFragment? = null
    private var offersFragment: OffersFragment? = null
    private var paymentFragment: PaymentFragment? = null
    private var transactionsFragment: TransactionsFragment? = null

    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        val itemId = item.itemId
        when (itemId) {
            R.id.navigation_home -> {
                mTxvToolbarTitle?.setText(R.string.app_name)
                homeFragment?.let { setUpFragment(it) }
                true
            }
            R.id.navigation_offers -> {
                mTxvToolbarTitle?.setText(R.string.title_offers)
                offersFragment?.let { setUpFragment(it) }
                true
            }
            R.id.navigation_payment -> {
                mTxvToolbarTitle?.setText(R.string.title_payment)
                paymentFragment?.let { setUpFragment(it) }
                true
            }
            R.id.navigation_account -> {
                mTxvToolbarTitle?.setText(R.string.title_my_account)
                accountFragment?.let { setUpFragment(it) }
                true
            }
            R.id.navigation_transactions -> {
                mTxvToolbarTitle?.setText(R.string.title_transactions)
                transactionsFragment?.let { setUpFragment(it) }
                true
            }
            else -> false
        }
    }

    fun initViews() {
        setContentView(R.layout.activity_main)
        mToolbar = findViewById(R.id.toolbar)
        mTxvToolbarTitle = findViewById(R.id.txv_toolbar_title)
        mBottomNavigationView = findViewById(R.id.navigation)
        homeFragment = HomeFragment.newInstance()
        accountFragment = AccountFragment.newInstance()
        offersFragment = OffersFragment.newInstance()
        paymentFragment = PaymentFragment.newInstance()
        transactionsFragment = TransactionsFragment.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()

        setSupportActionBar(mToolbar)
        supportActionBar?.title = ""
        mTxvToolbarTitle?.setText(R.string.app_name)

        mBottomNavigationView?.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        mBottomNavigationView?.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED

        val buildBeginTransaction = supportFragmentManager.beginTransaction()
        homeFragment?.let { buildBeginTransaction.replace(R.id.container_home, it) }
        buildBeginTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        return when (itemId) {
            R.id.menu_invite -> {
                Toast.makeText(this, "Invite and Earn", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_notification -> {
                Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
        fragmentTransaction.replace(R.id.container_home, fragment)
        fragmentTransaction.commit()
    }
}