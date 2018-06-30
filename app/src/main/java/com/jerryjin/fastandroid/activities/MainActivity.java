package com.jerryjin.fastandroid.activities;

import android.animation.ObjectAnimator;
import android.view.View;

import com.jerryjin.fastandroid.R;
import com.jerryjin.fastandroid.common.app.Activity;
import com.jerryjin.fastandroid.ui.widget.progressbar.RoundProgressBar;

public class MainActivity extends Activity {

    private RoundProgressBar roundProgressBar;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        roundProgressBar = findViewById(R.id.progressBar);

        roundProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofInt(roundProgressBar, "progress", 0, 100).setDuration(10000).start();
            }
        });
    }
}
