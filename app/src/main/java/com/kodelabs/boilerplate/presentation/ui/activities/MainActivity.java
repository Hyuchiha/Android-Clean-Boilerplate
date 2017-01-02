package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter.View;
import com.kodelabs.boilerplate.presentation.ui.fragments.FirstFragment;
import com.kodelabs.boilerplate.presentation.ui.fragments.SecondFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        uiSetup();
    }

    private void uiSetup() {
        // first fragment
        replaceFragment(firstFragment);

        // navigation drawer
        mNavigationView.setCheckedItem(R.id.nav_item_first);
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        selectNavItem(item);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void selectNavItem(MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_item_first:
                replaceFragment(firstFragment);
                break;
            case R.id.nav_item_second:
                replaceFragment(secondFragment);
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
