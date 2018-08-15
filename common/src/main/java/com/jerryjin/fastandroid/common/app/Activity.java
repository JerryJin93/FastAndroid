package com.jerryjin.fastandroid.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Base Activity.
 * Done.
 */
public abstract class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindows();
        if (initArgs(getIntent().getExtras())) {
            int layoutResId = getLayoutResId();
            setContentView(layoutResId);
            initAhead();
            initView();
            initData();
        } else {
            finish();
        }
    }

    protected void initAhead(){

    }

    protected boolean initArgs(Bundle args) {
        return true;
    }

    protected abstract int getLayoutResId();

    protected void initView() {
        ButterKnife.bind(this);
    }

    protected void initWindows() {

    }

    protected void initData() {

    }
}
