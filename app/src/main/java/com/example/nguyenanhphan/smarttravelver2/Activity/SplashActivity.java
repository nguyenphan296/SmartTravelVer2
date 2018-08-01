package com.example.nguyenanhphan.smarttravelver2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nguyenanhphan.smarttravelver2.MainActivity;
import com.example.nguyenanhphan.smarttravelver2.R;

public class SplashActivity extends AppCompatActivity {
    private final static int SPLASH_DISPLAY_LENGTH = 5000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentSplash = new Intent(SplashActivity.this, DangNhapActivity.class);
                SplashActivity.this.startActivity(intentSplash);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
