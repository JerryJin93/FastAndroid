package com.jerryjin.fastandroid.activities;

import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jerryjin.fastandroid.R;
import com.jerryjin.fastandroid.common.abs.Activity;
import com.jerryjin.fastandroid.ui.widget.progressbar.RoundProgressBar;
import com.jerryjin.fastandroid.utility.handler.Execution;
import com.jerryjin.fastandroid.utility.handler.runnable.Action;
import com.jerryjin.fastandroid.utility.persistant.SharedPreferencesHelper;

import butterknife.BindView;

public class MainActivity extends Activity {

    @Nullable
    @BindView(R.id.progressBar)
    RoundProgressBar roundProgressBar;

    @Nullable
    @BindView(R.id.textField)
    TextView textView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        roundProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofInt(roundProgressBar, "progress", 0, 100).setDuration(10000).start();
            }
        });


        Execution.updateUIAsync(new Action() {
            @Override
            public void activate() {
                Log.e("Thread1", Thread.currentThread().toString());
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i;
                for (i = 0; i < 1000; i++){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("Thread1", String.valueOf(i));

                }
                final int finalI = i;
                Execution.updateUIAsync(new Action() {
                    @Override
                    public void activate() {
                        textView.setText(String.valueOf(finalI));
                    }
                });
            }
        }).start();

        String[] keys = null;
        SharedPreferencesHelper
                .getInstance(this)
                .with("test")
                .putInts(new SharedPreferencesHelper.IRandomKeys() {
                    @Override
                    public void onSaved(String[] keys) {
                        for (String s : keys){
                            Log.e("TAG_SPH", s);
                        }

                    }
                }, 1, 2, 3);

//        for (int i = 0; i < 3 ; i++){
//            Log.e("TAG_SPH", keys[i] + " " + String.valueOf(SharedPreferencesHelper
//                                            .getInstance(this)
//                                            .getInts(keys)[i]));
//        }


    }
}
