package com.bookex.utils.recyclerView;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import com.bookex.BR;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public BaseViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.obj, obj);
        binding.executePendingBindings();
    }
}
