package com.jerryjin.fastandroid.common.presenter;

import android.support.annotation.Nullable;

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {

    @Nullable
    protected T mView;

    public BasePresenter(T view) {
        setView(view);
    }

    /**
     * Get the specific type of view of current presenter.
     *
     * @return T view.
     */
    @Nullable
    protected final T getView() {
        return mView;
    }

    /**
     * Set a specific view to current presenter.
     *
     * @param view T view.
     */
    @SuppressWarnings("unchecked")
    protected void setView(T view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void onStart() {

    }

    @SuppressWarnings("unchecked")
    @Override
    public void onDestroy() {
        T view = mView;
        mView = null;
        if (view != null) {
            view.setPresenter(null);
        }
    }
}
