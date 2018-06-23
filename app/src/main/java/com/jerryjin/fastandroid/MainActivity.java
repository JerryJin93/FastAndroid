package com.jerryjin.fastandroid;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jerryjin.fastandroid.widget.progressbar.RoundProgressBar;

public class MainActivity extends AppCompatActivity {

    private RoundProgressBar roundProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roundProgressBar = findViewById(R.id.progressBar);

        roundProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofInt(roundProgressBar, "progress", 0, 100).setDuration(10000).start();
            }
        });

    }
}
