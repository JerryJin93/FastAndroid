package com.jerryjin.fastandroid.common.widget;

import com.jerryjin.fastandroid.common.widget.recycler.RecyclerAdapter;

public interface AdapterCallback<T> {
    void update(T data, RecyclerAdapter.ViewHolder<T> holder);
}
