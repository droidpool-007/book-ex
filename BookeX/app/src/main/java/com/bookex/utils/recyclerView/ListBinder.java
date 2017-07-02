package com.bookex.utils.recyclerView;

import android.databinding.BindingAdapter;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListBinder {

    @BindingAdapter({"app:bindData", "app:layoutId"})
    public static void bindRecyclerView(RecyclerView view, final List<?> list, @LayoutRes int layoutId) {
        view.setAdapter(new SingleLayoutAdapter(layoutId) {
            @Override
            public int getItemCount() {
                return list.size();
            }

            @Override
            protected Object getObjForPosition(int position) {
                return list.get(position);
            }


        });
    }
}
