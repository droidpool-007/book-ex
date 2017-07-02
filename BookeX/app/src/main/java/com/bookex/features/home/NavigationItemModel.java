package com.bookex.features.home;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bookex.BR;

public class NavigationItemModel extends BaseObservable {

    private int id;
    private String itemName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
        notifyPropertyChanged(BR.itemName);
    }
}
