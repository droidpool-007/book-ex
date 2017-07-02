package com.bookex.features.home;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import com.bookex.BR;

public class NavigationListModel extends BaseObservable {

    private String username, mobile;
    private ObservableArrayList<NavigationItemModel> navigationList = new ObservableArrayList<>();

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
        notifyPropertyChanged(BR.mobile);
    }

    @Bindable
    public ObservableArrayList<NavigationItemModel> getNavigationList() {
        return navigationList;
    }

    public void setNavigationList(ObservableArrayList<NavigationItemModel> navigationList) {
        this.navigationList = navigationList;
        notifyPropertyChanged(BR.navigationList);
    }

    public void setProfileData(String name, String mobile) {
        setUsername(name);
        setMobile(mobile);
    }

}
