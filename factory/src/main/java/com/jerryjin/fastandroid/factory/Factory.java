package com.jerryjin.fastandroid.factory;

import com.jerryjin.fastandroid.common.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Factory {

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
