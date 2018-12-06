package com.app.akiddie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView imageView;
    private Handler mHandler;
    private Runnable mRunnable;
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView =  findViewById(R.id.akiddielogo);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);
        imageView.startAnimation(animation);

        /*helps run the object later on the main UI thread without blocking other operations */
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                Intent toMainActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(toMainActivity);
                finish();
            }
        };

        /* allows user to prematurely move to main activity */
        View view = findViewById(R.id.akiddielogo);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable, SPLASH_TIME_OUT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }
}
