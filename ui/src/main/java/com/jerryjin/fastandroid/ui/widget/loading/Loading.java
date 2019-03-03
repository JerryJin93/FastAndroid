package com.jerryjin.fastandroid.ui.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class Loading extends View {

    private LoadingDrawable mLoadingDrawable;

    public Loading(Context context) {
        this(context, null, 0, 0);
    }

    public Loading(Context context, AttributeSet attrs) {
        this(context, attrs, 0, 0);
    }

    public Loading(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public Loading(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
