package com.jerryjin.fastandroid.ui.widget.loading;

import android.graphics.Canvas;
import android.graphics.RectF;

public class CircleLoadingDrawable extends LoadingDrawable {

    private RectF mArc = new RectF();
    private float mStartAngle = 0;
    private float mSweepAngle = 0;

    @Override
    protected void drawBackground(Canvas canvas) {
        canvas.drawArc(mArc, 0, 360, false, mBackgroundPaint);
    }

    @Override
    protected void drawForeground(Canvas canvas) {
        canvas.drawArc(mArc, mStartAngle, -mSweepAngle, false, mForegroundPaint);
    }

    @Override
    protected void onProgressChange(float progress) {
        mStartAngle = 0;
        mSweepAngle = 360 * progress;
    }

    @Override
    protected void onRefresh() {

    }
}
