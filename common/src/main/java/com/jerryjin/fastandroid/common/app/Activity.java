package com.jerryjin.fastandroid.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindows();
        int layoutResId = getLayoutResId();
        initView(layoutResId);
        initWidget();
        initData();
    }

    protected abstract int getLayoutResId();

    protected void initView(int layoutResId){
        setContentView(layoutResId);
    }

    protected void initWindows(){

    }

    protected void initWidget(){

    }

    protected void initData(){

    }
}
