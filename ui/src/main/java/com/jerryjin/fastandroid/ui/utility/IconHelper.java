package com.jerryjin.fastandroid.ui.utility;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;

public class IconHelper {
    /**
     * 把Drawable转换为Bitmap
     *
     * @param drawable Drawable对象
     * @return Bitmap对象
     */
    public static Bitmap getIcon(Drawable drawable) {

        // 若系统版本大于等于API26（Oreo）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            } else if (drawable instanceof AdaptiveIconDrawable) {
                Drawable backgroundDr = ((AdaptiveIconDrawable) drawable).getBackground();
                Drawable foregroundDr = ((AdaptiveIconDrawable) drawable).getForeground();

                Drawable[] drawables = new Drawable[2];
                drawables[0] = backgroundDr;
                drawables[1] = foregroundDr;

                LayerDrawable layerDrawable = new LayerDrawable(drawables);

                int width = layerDrawable.getIntrinsicWidth();
                int height = layerDrawable.getIntrinsicHeight();

                Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(bitmap);

                layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                layerDrawable.draw(canvas);

                return bitmap;
            } else {
                return null;
            }
        }
        // 系统版本低于Android O的处理
        else {
            return ((BitmapDrawable) drawable).getBitmap();
        }
    }
}
