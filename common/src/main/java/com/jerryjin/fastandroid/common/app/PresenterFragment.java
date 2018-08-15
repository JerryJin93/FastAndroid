package com.jerryjin.fastandroid.common.app;

import android.content.Context;

import com.jerryjin.fastandroid.common.presenter.BaseContract;

public abstract class PresenterFragment<P extends BaseContract.Presenter> extends Fragment implements BaseContract.View<P> {

    protected P mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initPresenter();
    }

    /**
     * Initialize the current presenter.
     * <p>
     * You should initialize presenter by instantiating an object of the its implemented presenter.
     */
    protected abstract void initPresenter();

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }
}
