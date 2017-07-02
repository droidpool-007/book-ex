package com.bookex.utils.recyclerView;


public abstract class SingleLayoutAdapter extends BaseRecyclerViewAdapter {
    private final int layoutId;

    public SingleLayoutAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutId;
    }

}
