package com.jerryjin.fastandroid.ui.widget.progressbar;

import android.content.Context;
import android.util.AttributeSet;

import com.jerryjin.fastandroid.ui.widget.AbstractView;


public abstract class AbstractProgressBar extends AbstractView {

    protected int mProgress;

    public AbstractProgressBar(Context context) {
        super(context);
    }

    public AbstractProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public int getProgress() {
        return mProgress;
    }

    public void setProgress(int mProgress) {
        this.mProgress = mProgress;
        invalidate();
    }
}
