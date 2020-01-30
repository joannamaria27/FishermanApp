package com.example.fishermanapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.shredzone.commons.suncalc.SunTimes;

import java.util.Date;

class SunActivity extends AppCompatActivity {

    Date today = new Date();

    double lat = 52.13;//geolocation
    double lng = 21.00;

SunTimes times = SunTimes.compute()
        .on(today)
        .at(lat, lng)
        .execute();

Date wschod = times.getRise();
Date zachod = times.getSet();


    Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
    SunTimes timesJ = SunTimes.compute()
            .on(tomorrow)
            .at(lat, lng)
            .execute();
    Date wschodJ = times.getRise();
    Date zachodJ = times.getSet();



    private TextView wd;
    private TextView zd;
    private TextView wj;
    private TextView zj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun);

        wd = findViewById(R.id.wschod_dzis);
        zd = findViewById(R.id.zachod_dzis);
        wj = findViewById(R.id.wschod_jutro);
        zj = findViewById(R.id.zachod_jutro);

        wd.setText(wschod.toString());
        zd.setText(zachod.toString());
        wj.setText(wschodJ.toString());
        zj.setText(zachodJ.toString());

    }


}
