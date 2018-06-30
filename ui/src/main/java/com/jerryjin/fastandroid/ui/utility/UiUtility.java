package com.jerryjin.fastandroid.ui.utility;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class UiUtility {

    /**
     * Convert dips to pixels
     * @param context Context
     * @param dp dip(dp) values
     * @return Converted pixels.
     */
    public static float dp2px(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context, float pixels) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float scale = displayMetrics.density;
        return pixels / scale;
    }

    public static float sp2px(Context context, float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    public static float px2sp(Context context, float pixels) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float scale = displayMetrics.scaledDensity;
        return pixels / scale;
    }

    public static float getTextWidth(Paint paint, @NonNull String string) {
        return paint.measureText(string);
    }

    public static float getTextHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }
}
