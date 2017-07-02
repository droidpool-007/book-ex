package com.bookex.features.home;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bookex.R;
import com.bookex.databinding.ActivityMainBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_Main extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    ActivityMainBinding binding = null;
    NavigationListModel mNavigationListModel = null;

    public static final int PAYMENT = 1001;
    public static final int ADDRESS = 1002;
    public static final int REFINE = 1003;
    public static final int HELP = 1004;
    public static final int ABOUT_US = 1005;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ButterKnife.bind(this);

        binding.setNavigationListModel(mNavigationListModel);
        setUpNavigationView();
    }

    private void setUpNavigationView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationListModel = new NavigationListModel();
        mNavigationListModel.setUsername("Poonam");
        mNavigationListModel.setMobile("90819898989");
        ObservableArrayList<NavigationItemModel> navigationList = mNavigationListModel.getNavigationList();

        NavigationItemModel itemModel = new NavigationItemModel();
        itemModel.setId(PAYMENT);
        itemModel.setItemName("Payment");
        navigationList.add(itemModel);

        itemModel = new NavigationItemModel();
        itemModel.setId(ADDRESS);
        itemModel.setItemName("Address");
        navigationList.add(itemModel);

        itemModel = new NavigationItemModel();
        itemModel.setId(REFINE);
        itemModel.setItemName("Refine");
        navigationList.add(itemModel);

        itemModel = new NavigationItemModel();
        itemModel.setId(HELP);
        itemModel.setItemName("Get Help");
        navigationList.add(itemModel);

        itemModel = new NavigationItemModel();
        itemModel.setId(ABOUT_US);
        itemModel.setItemName("About Us");
        navigationList.add(itemModel);

        mNavigationListModel.setNavigationList(navigationList);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

}
