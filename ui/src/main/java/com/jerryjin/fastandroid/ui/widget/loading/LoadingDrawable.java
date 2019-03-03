package com.jerryjin.fastandroid.ui.widget.loading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public abstract class LoadingDrawable extends Drawable implements Animatable {

    private static final int LINE_WIDTH = 4;
    private static final int FRAME_DURATION = (int) ((float) (1 / 60) * 1000);
    protected Paint mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    protected Paint mForegroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    protected float mProgress;
    private boolean mRun;
    private final Runnable mAnim = new Runnable() {
        @Override
        public void run() {
            if (isRunning()) {
                onRefresh();
                invalidateSelf();
            } else {
                unscheduleSelf(this);
            }
        }
    };


    public LoadingDrawable() {
        mBackgroundPaint.setStyle(Paint.Style.STROKE);
        mBackgroundPaint.setDither(true);
        mBackgroundPaint.setStrokeWidth(LINE_WIDTH);
        mForegroundPaint.setStyle(Paint.Style.STROKE);
        mForegroundPaint.setDither(true);
        mForegroundPaint.setStrokeWidth(LINE_WIDTH);
    }

    @Override
    public int getIntrinsicHeight() {
        float maxHeight = Math.max(mBackgroundPaint.getStrokeWidth(), mForegroundPaint.getStrokeWidth());
        return (int) (maxHeight * 2);
    }

    @Override
    public int getIntrinsicWidth() {
        float maxWidth = Math.max(mBackgroundPaint.getStrokeWidth(), mForegroundPaint.getStrokeWidth());
        return (int) (maxWidth * 2);
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void setAlpha(int alpha) {
        mForegroundPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    @Override
    public void start() {
        if (!mRun) {
            mRun = true;
            scheduleSelf(mAnim, SystemClock.uptimeMillis() + FRAME_DURATION);
        }
    }

    @Override
    public void stop() {
        if (isRunning()) {
            mRun = false;
            unscheduleSelf(mAnim);
            invalidateSelf();
        }
    }

    @Override
    public boolean isRunning() {
        return mRun;
    }


    protected abstract void drawBackground(Canvas canvas);
    protected abstract void drawForeground(Canvas canvas);
    protected abstract void onProgressChange(float progress);
    protected abstract void onRefresh();
}
