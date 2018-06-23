package com.jerryjin.fastandroid.utility;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.TypedValue;

public class UiUtility {

    public static float dp2px(Context context, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static float sp2px(Context context, int sp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    public static float getTextWidth(Paint paint, @NonNull String string){
        return paint.measureText(string);
    }

    public static float getTextHeight(Paint paint){
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }
}
