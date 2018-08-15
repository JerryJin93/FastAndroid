package com.jerryjin.fastandroid.utility.differ;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class DiffCallback<T extends DiffCallback.IDiffer<T>> extends DiffUtil.Callback {

    private List<T> oldList, newList;

    public DiffCallback(List<T> oldList, List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        T oldBean = oldList.get(oldItemPosition);
        T newBean = newList.get(newItemPosition);
        return newBean.areItemsTheSame(oldBean);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        T oldBean = oldList.get(oldItemPosition);
        T newBean = newList.get(newItemPosition);
        return newBean.areContentsTheSame(oldBean);
    }


    public interface IDiffer<T> {

        boolean areItemsTheSame(T old);

        boolean areContentsTheSame(T old);
    }
}
