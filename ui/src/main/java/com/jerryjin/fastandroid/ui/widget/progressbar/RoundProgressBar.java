package com.jerryjin.fastandroid.ui.widget.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.jerryjin.fastandroid.ui.R;
import com.jerryjin.fastandroid.ui.utility.UiUtility;

public class RoundProgressBar extends AbstractProgressBar {

    private static final String KEY_PROGRESS = "key_progress";
    private static final String INSTANCE = "INSTANCE";

    private int mPadding;
    private int mLineColor;
    private int mLineWidth;
    private int mRadius;
    private int mTextSize;

    private RectF rectF;

    public RoundProgressBar(Context context) {
        super(context);
    }

    public RoundProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void initStyle(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RoundProgressBar);

        try {
            mPadding = (int) array.getDimension(R.styleable.RoundProgressBar_android_padding, UiUtility.dp2px(context, 5));
            if (mPadding == 0){
                mPadding = (int) UiUtility.dp2px(context, 5);
            }

            mLineColor = array.getColor(R.styleable.RoundProgressBar_color, getResources().getColor(R.color.light_purple));
            mLineWidth = (int) array.getDimension(R.styleable.RoundProgressBar_lineWidth, UiUtility.dp2px(context, 3));
            mTextSize = (int) array.getDimension(R.styleable.RoundProgressBar_android_textSize, UiUtility.sp2px(context, 16));
            mProgress = array.getInt(R.styleable.RoundProgressBar_android_progress, 0);
        } catch (NullPointerException e) {
            mPadding = (int) UiUtility.dp2px(context, 5);
            mLineColor = getResources().getColor(R.color.light_purple);
            mLineWidth = (int) UiUtility.dp2px(context, 3);
            mTextSize = (int) UiUtility.sp2px(context, 16);
            mProgress = 0;
        } finally {
            array.recycle();
        }
    }

    @Override
    protected void initPaint() {
        super.initPaint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mLineColor);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRadius = (Math.min(w, h) - mPadding) / 2;
        rectF = new RectF(0, 0, mRadius * 2, mRadius * 2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize + mPadding * 2;
            System.out.println("EXACTLY " + UiUtility.px2dp(getContext(), width) + "mPadding: " + mPadding);
        } else {
            int demandWidth = width + getPaddingStart() + getPaddingEnd();
            if (widthMode == MeasureSpec.AT_MOST) {
                width = Math.min(demandWidth, width);
            } else {
                width = demandWidth;
            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize + mPadding * 2;
        } else {
            int demandHeight = height + getPaddingTop() + getPaddingBottom();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(demandHeight, width);
            } else {
                height = demandHeight;
            }
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(mLineWidth * 1.0f / 4);

        int width = getWidth();
        int height = getHeight();

        canvas.drawCircle(width / 2, height / 2, mRadius, mPaint);

        mPaint.setStrokeWidth(mLineWidth);
        canvas.save();
        float margin = (width - mRadius * 2) / 2;
        canvas.translate(margin, margin);

        float sweepAngle = mProgress * 1.0f / 100 * 360;

        canvas.drawArc(rectF, 0, sweepAngle, false, mPaint);
        canvas.restore();


        String text = mProgress + "%";
        mPaint.setStrokeWidth(0);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(mTextSize);
        float textHeight = UiUtility.getTextHeight(mPaint);

        // Number has no descent.
        canvas.drawText(text, 0, text.length(), width / 2, height / 2 + textHeight / 2 - mPaint.descent() / 2, mPaint);
        // canvas.drawLine(0, height / 2, width, height / 2, mPaint);
    }


    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_PROGRESS, mProgress);
        bundle.putParcelable(INSTANCE, super.onSaveInstanceState());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            Parcelable parcelable = bundle.getParcelable(INSTANCE);
            super.onRestoreInstanceState(parcelable);
            mProgress = bundle.getInt(KEY_PROGRESS);
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public int getLineColor() {
        return mLineColor;
    }

    public void setLineColor(int mLineColor) {
        this.mLineColor = mLineColor;
        invalidate();
    }
}
