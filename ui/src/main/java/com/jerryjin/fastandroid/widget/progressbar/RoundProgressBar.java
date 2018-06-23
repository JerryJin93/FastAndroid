package com.jerryjin.fastandroid.widget.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.jerryjin.fastandroid.R;
import com.jerryjin.fastandroid.utility.UiUtility;

public class RoundProgressBar extends AbstractProgressBar {

    private static final String KEY_PROGRESS = "key_progress";
    private static final String INSTANCE = "INSTANCE";

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

        mLineColor = array.getColor(R.styleable.RoundProgressBar_color, getResources().getColor(R.color.light_purple));
        mLineWidth = (int) array.getDimension(R.styleable.RoundProgressBar_lineWidth, UiUtility.dp2px(context, 3));
        mRadius = (int) array.getDimension(R.styleable.RoundProgressBar_radius, UiUtility.dp2px(context, 20));
        mTextSize = (int) array.getDimension(R.styleable.RoundProgressBar_android_textSize, UiUtility.sp2px(context, 16));
        mProgress = array.getInt(R.styleable.RoundProgressBar_android_progress, 0);

        array.recycle();
    }

    @Override
    public void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mLineColor);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
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
            width = widthSize;
        } else {
            int demandWidth = measureWidth() + getPaddingStart() + getPaddingEnd();
            if (widthMode == MeasureSpec.AT_MOST) {
                width = Math.min(demandWidth, mLineWidth);
            } else {
                width = demandWidth;
            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            int demandHeight = measureHeight() + getPaddingTop() + getPaddingBottom();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(demandHeight, mLineWidth);
            } else {
                height = demandHeight;
            }
        }
        width = Math.min(width, height);
        //noinspection SuspiciousNameCombination
        setMeasuredDimension(width, width);
    }

    private int measureHeight() {
        return mRadius * 2;
    }

    private int measureWidth() {
        return mRadius * 2;
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
