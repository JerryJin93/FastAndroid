package com.jerryjin.fastandroid.common.abs;

import android.content.res.Configuration;
import android.support.annotation.StringRes;
import android.widget.Toast;

public class Application extends android.app.Application {

    private static Application instance;

    private Application(){

    }

    public static Application getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static void toast(CharSequence text){
        // TODO 必须在主线程运行
        Toast.makeText(instance, text, Toast.LENGTH_SHORT).show();
    }

    public static void toast(@StringRes int msgId){
        toast(instance.getString(msgId));
    }
}
