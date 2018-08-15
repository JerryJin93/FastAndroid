package com.jerryjin.fastandroid.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class AbstractView extends View {

    protected Paint mPaint;

    public AbstractView(Context context) {
        super(context);
        initStyle(context, null);
        initPaint();
    }

    public AbstractView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initStyle(context, attrs);
        initPaint();
    }

    public AbstractView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initStyle(context, attrs);
        initPaint();
    }

    public AbstractView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initStyle(context, attrs);
        initPaint();
    }

    /**
     * Load attributes
     *
     * @param attrs   AttributeSet
     * @param context Context
     */
    protected abstract void initStyle(Context context, AttributeSet attrs);

    protected void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
    }

}
