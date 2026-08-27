package com.bizanalyst.phonepay_clone.ui;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.widget.Toast;

import com.bizanalyst.phonepay_clone.R;
import com.bizanalyst.phonepay_clone.fragment.AccountFragment;
import com.bizanalyst.phonepay_clone.fragment.HomeFragment;
import com.bizanalyst.phonepay_clone.fragment.OffersFragment;
import com.bizanalyst.phonepay_clone.fragment.PaymentFragment;
import com.bizanalyst.phonepay_clone.fragment.TransactionsFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView mTxvToolbarTitle;
    private BottomNavigationView mBottomNavigationView;
    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private OffersFragment offersFragment;
    private PaymentFragment paymentFragment;
    private TransactionsFragment transactionsFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        int itemId = item.getItemId();
        if (itemId == R.id.navigation_home) {
            mTxvToolbarTitle.setText(R.string.app_name);
            setUpFragment(homeFragment);
            return true;
        } else if (itemId == R.id.navigation_offers) {
            mTxvToolbarTitle.setText(R.string.title_offers);
            setUpFragment(offersFragment);
            return true;
        } else if (itemId == R.id.navigation_payment) {
            mTxvToolbarTitle.setText(R.string.title_payment);
            setUpFragment(paymentFragment);
            return true;
        } else if (itemId == R.id.navigation_account) {
            mTxvToolbarTitle.setText(R.string.title_my_account);
            setUpFragment(accountFragment);
            return true;
        } else if (itemId == R.id.navigation_transactions) {
            mTxvToolbarTitle.setText(R.string.title_transactions);
            setUpFragment(transactionsFragment);
            return true;
        }
        return false;
    };

    public void initViews() {
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        mTxvToolbarTitle = findViewById(R.id.txv_toolbar_title);
        mBottomNavigationView = findViewById(R.id.navigation);
        homeFragment = HomeFragment.newInstance();
        accountFragment = AccountFragment.newInstance();
        offersFragment = OffersFragment.newInstance();
        paymentFragment = PaymentFragment.newInstance();
        transactionsFragment = TransactionsFragment.newInstance();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        mTxvToolbarTitle.setText(R.string.app_name);

        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mBottomNavigationView.setLabelVisibilityMode(com.google.android.material.navigation.NavigationBarView.LABEL_VISIBILITY_LABELED);

        FragmentTransaction buildBeginTransaction = getSupportFragmentManager().beginTransaction();
        buildBeginTransaction.replace(R.id.container_home, homeFragment);
        buildBeginTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_invite) {
            Toast.makeText(this, "Invite and Earn", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.menu_notification) {
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

     private void setUpFragment(Fragment fragment){
         FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
         fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
         fragmentTransaction.replace(R.id.container_home, fragment);
         fragmentTransaction.commit();
     }
}
