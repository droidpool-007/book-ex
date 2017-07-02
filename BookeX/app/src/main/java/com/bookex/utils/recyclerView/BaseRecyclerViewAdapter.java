package com.bookex.utils.recyclerView;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new BaseViewHolder(binding);
    }

    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Object obj = getObjForPosition(position);
        holder.bind(obj);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected abstract Object getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);

    //protected abstract Object getEventObject();
}
