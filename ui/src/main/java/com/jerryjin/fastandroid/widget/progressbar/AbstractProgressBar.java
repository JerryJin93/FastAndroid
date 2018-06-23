package com.jerryjin.fastandroid.widget.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.jerryjin.fastandroid.R;


public abstract class AbstractProgressBar extends View {

    protected int mProgress;
    protected Paint mPaint;

    public AbstractProgressBar(Context context) {
        super(context);
        initStyle(context, null);
        initPaint();
    }

    public AbstractProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initStyle(context, attrs);
        initPaint();
    }

    public AbstractProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initStyle(context, attrs);
        initPaint();
    }

    /**
     * Load attributes
     * @param attrs AttributeSet
     * @param context Context
     */
    public abstract void initStyle(Context context, AttributeSet attrs);

    public abstract void initPaint();

    public int getProgress() {
        return mProgress;
    }

    public void setProgress(int mProgress) {
        this.mProgress = mProgress;
        invalidate();
    }
}
