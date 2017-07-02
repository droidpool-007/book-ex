package com.bookex.features.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.bookex.R;
import com.bookex.features.home.Activity_Main;

public class Activity_Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Activity_Splash.this, Activity_Main.class));
            }
        }, 1500);
    }
}
