package com.example.fishermanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ekran_glowny extends AppCompatActivity {
    Button ekran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran_glowny);


        ekran = findViewById(R.id.button_wejdz);


        ekran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ekran_glowny.this, MActivity.class);
                startActivity(intent);            }
        });
    }
}
