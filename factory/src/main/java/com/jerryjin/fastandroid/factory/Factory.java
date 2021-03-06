package com.jerryjin.fastandroid.factory;

import android.support.annotation.NonNull;

import com.jerryjin.fastandroid.common.abs.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Factory {

    @NonNull
    private static final Factory instance;

    private final Executor executor;

    static {
        instance = new Factory();
    }

    private Factory(){
        executor = Executors.newFixedThreadPool(4);

    }

    public static Application getApplication(){
        return Application.getInstance();
    }


}
