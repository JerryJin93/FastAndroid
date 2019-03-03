package com.jerryjin.fastandroid.utility.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;

import com.jerryjin.fastandroid.common.abs.Activity;
import com.jerryjin.fastandroid.utility.bean.InstalledApp;

import java.util.ArrayList;
import java.util.List;

public class AppHelper {
    /**
     * @param context Context
     * @return App info list.
     */
    public static List<ResolveInfo> getAppInfo(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        return context.getPackageManager().queryIntentActivities(intent, 0);
    }

    /**
     * 将List<ResolveInfo>转换为List<InstalledApp>
     *
     * @param context Context
     * @return 转换好的List
     */
    @NonNull
    public static List<InstalledApp> getAppList(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> appInfoList = AppHelper.getAppInfo(context);
        ArrayList<InstalledApp> appList = new ArrayList<>();
        for (ResolveInfo resolveInfo : appInfoList) {
            appList.add(new InstalledApp(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name,
                    resolveInfo.activityInfo.loadIcon(packageManager), (String) resolveInfo.activityInfo.loadLabel(packageManager)));
        }
        return appList;
    }

    /**
     * Jump to another Activity by the given context.
     * <p>
     *
     * @param from Context, the context that invokes this method.
     * @param cls  Class, the objective Activity you want to go to.
     */
    public static void comeHere(Context from, Class<? extends Activity> cls) {
        from.startActivity(new Intent(from, cls));
    }
}
