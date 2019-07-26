package com.pens.vsgamobileprog;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout lnDailyNote, lnSqlLite, lnBackend, lnMaps, lnChat, lnCalculator, lnGallery, lnCalendar, lnSetting, lnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int statusBarColor = Color.parseColor("#202f65");
        getWindow().setStatusBarColor(statusBarColor);

        lnDailyNote = (LinearLayout) findViewById(R.id.dailynote);
        lnSqlLite = (LinearLayout) findViewById(R.id.sqllite);
        lnBackend = (LinearLayout) findViewById(R.id.backend);
        lnMaps = (LinearLayout) findViewById(R.id.maps);
        lnChat = (LinearLayout) findViewById(R.id.chat);
        lnCalculator = (LinearLayout) findViewById(R.id.calculator);
        lnGallery = (LinearLayout) findViewById(R.id.gallery);
        lnCalendar = (LinearLayout) findViewById(R.id.calendar);
        lnSetting = (LinearLayout) findViewById(R.id.setting);
        lnLogout = (LinearLayout) findViewById(R.id.logout);

        lnDailyNote.setOnClickListener(this);
        lnSqlLite.setOnClickListener(this);
        lnBackend.setOnClickListener(this);
        lnMaps.setOnClickListener(this);
        lnChat.setOnClickListener(this);
        lnCalculator.setOnClickListener(this);
        lnGallery.setOnClickListener(this);
        lnCalendar.setOnClickListener(this);
        lnSetting.setOnClickListener(this);
        lnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dailynote:
                break;
            case R.id.backend:
                break;
            case R.id.sqllite:
                break;
            case R.id.chat:
                break;
            case R.id.maps:
                break;
            case R.id.calculator:
                break;
            case R.id.calendar:
                break;
            case R.id.gallery:
                break;
            case R.id.setting:
                break;
            case R.id.logout:
                break;
        }
    }
}
