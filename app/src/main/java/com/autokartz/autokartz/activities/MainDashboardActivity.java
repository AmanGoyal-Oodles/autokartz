package com.autokartz.autokartz.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.autokartz.autokartz.R;
import com.autokartz.autokartz.fragments.CompanyURLFragment;
import com.autokartz.autokartz.fragments.EnquireFormFragment;
import com.autokartz.autokartz.fragments.HomeFragment;
import com.autokartz.autokartz.fragments.MyAccountFragment;
import com.autokartz.autokartz.fragments.OrdersFragment;
import com.autokartz.autokartz.fragments.TransactionHistoryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainDashboardActivity extends AppCompatActivity {

    @BindView(R.id.main_nav_drawer_layout)
    DrawerLayout mNavDrawerLayout;
    @BindView(R.id.nav_toolbar)
    Toolbar mToolbar;
    NavigationView mNavView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ListView mDrawerList;
    private String[] mDrawerItems;
    private View mHeaderView;
    private static int NAV_ITEM_INDEX = 0;
    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard2);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mNavView = (NavigationView) findViewById(R.id.nav_view);
        init();
        setActionBarDrawerToggle();
        openHomeFragment(new HomeFragment());
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        NAV_ITEM_INDEX = 0;
                        break;
                    case R.id.nav_enquire_form:
                        fragment = new EnquireFormFragment();
                        NAV_ITEM_INDEX = 1;
                        break;
                    case R.id.nav_transaction_history:
                        fragment = new TransactionHistoryFragment();
                        NAV_ITEM_INDEX = 2;
                        break;
                    case R.id.nav_orders:
                        fragment = new OrdersFragment();
                        NAV_ITEM_INDEX = 3;
                        break;
                    case R.id.nav_myaccount:
                        fragment = new MyAccountFragment();
                        NAV_ITEM_INDEX = 4;
                        break;
                    case R.id.nav_companyurl:
                        fragment = new CompanyURLFragment();
                        NAV_ITEM_INDEX = 5;
                        break;
                }
                openHomeFragment(fragment);
                mNavDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private void setActionBarDrawerToggle() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mNavDrawerLayout, mToolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mNavDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void openHomeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commitNowAllowingStateLoss();
    }

    private void init() {
        // initVariables();
    }

}
