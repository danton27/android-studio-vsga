package com.pens.vsgamobileprog;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int statusBarColor = Color.parseColor("#202f65");
        getWindow().setStatusBarColor(statusBarColor);
    }
}
