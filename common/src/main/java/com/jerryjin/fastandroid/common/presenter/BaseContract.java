package com.jerryjin.fastandroid.common.presenter;

import com.jerryjin.fastandroid.common.widget.recycler.RecyclerAdapter;

/**
 * Base contract based on MVP mode.
 */
public interface BaseContract {

    interface View<T extends Presenter> {
        /**
         * Set a presenter.
         *
         * @param presenter T presenter.
         */
        void setPresenter(T presenter);
    }

    interface Presenter {

        void onStart();

        void onDestroy();
    }

    interface RecyclerView<T extends Presenter, ViewMode> extends View<T> {

        RecyclerAdapter<ViewMode> getRecyclerAdapter();

        void onAdapterDataSetChanged();
    }
}
