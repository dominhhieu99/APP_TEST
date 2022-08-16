package com.example.web;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.web.ui.dashboard.DashboardFragment;
import com.example.web.ui.home.HomeFragment;
import com.example.web.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView navigationView;
    ActionBar actionBar;

    private HomeFragment homeFragment;
    private DashboardFragment dashboardFragment;
    private NotificationsFragment notificationsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();
        actionBar = getSupportActionBar();
        setContentView(R.layout.activity_home);
        navigationView = findViewById(R.id.nav_view);
        homeFragment = new HomeFragment();
        dashboardFragment = new DashboardFragment();
        notificationsFragment = new NotificationsFragment();
        loadFragment(homeFragment);
        navigationView.setOnNavigationItemSelectedListener(this);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = homeFragment;
                break;

            case R.id.navigation_dashboard:
                fragment = dashboardFragment;
                break;

            case R.id.navigation_notifications:
                fragment = notificationsFragment;
                break;
        }
        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            if (fragment.isAdded()){
                if (fragment instanceof HomeFragment){
                    if (dashboardFragment.isAdded())
                    getSupportFragmentManager()
                            .beginTransaction()
                            .hide( dashboardFragment)
                            .commit();
                    if (notificationsFragment.isAdded())
                    getSupportFragmentManager()
                            .beginTransaction()
                            .hide( notificationsFragment)
                            .commit();
                }else if (fragment instanceof DashboardFragment){
                    if (homeFragment.isAdded())
                    getSupportFragmentManager()
                            .beginTransaction()
                            .hide( homeFragment)
                            .commit();
                    if (notificationsFragment.isAdded())
                    getSupportFragmentManager()
                            .beginTransaction()
                            .hide( notificationsFragment)
                            .commit();
                }else {
                    if (homeFragment.isAdded())
                    getSupportFragmentManager()
                            .beginTransaction()
                            .hide( homeFragment)
                            .commit();
                    if (dashboardFragment.isAdded())
                    getSupportFragmentManager()
                            .beginTransaction()
                            .hide( dashboardFragment)
                            .commit();
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .show( fragment)
                        .commit();


            }else {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.nav_host_fragment, fragment)
                        .commit();
            }
            return true;
        }
        return false;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}