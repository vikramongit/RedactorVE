package com.vikram.redactorve;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.InterstitialAd;

public class SplashActivity extends AppCompatActivity {


    private Ads ads;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT<16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_splash);
        ads = new Ads();
        if (ads.mInterstitialAd == null) {
            ads.loadAd(SplashActivity.this);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openmainactivity();
            }
        }, 4000);
    }

    private void openmainactivity() {
        ads.loadd(new Ads.AdLisoner() {
            @Override
            public void onSucssec(InterstitialAd mInterstitialAd) {
                startActivity(new Intent(SplashActivity.this, Mainactivity.class));
                finish();
            }

            @Override
            public void onun() {
                startActivity(new Intent(SplashActivity.this, Mainactivity.class));
                finish();
            }
        });

    }
}
