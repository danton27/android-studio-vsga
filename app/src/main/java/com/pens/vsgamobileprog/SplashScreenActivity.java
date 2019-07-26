package com.pens.vsgamobileprog;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.File;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView imgSplScreen;
    Animation fade;
    public static final String FILENAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int statusBarColor = Color.parseColor("#F9F9F9");
        getWindow().setStatusBarColor(statusBarColor);
        imgSplScreen = (ImageView) findViewById(R.id.imgsplscreen);
        fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        imgSplScreen.startAnimation(fade);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogin()) {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }, 2000);
    }

    boolean isLogin() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);
        if (file.exists()) {
            return true;
        } else {
            return  false;
        }
    }
}
