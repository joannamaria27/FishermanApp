package com.example.fishermanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MActivity extends AppCompatActivity {

    public static final int NEW_CAMERA_ACTIVITY_REQUEST_CODE = 1;
    ImageButton btnFlashLight;
    private final int CAMERA_REQUEST_CODE = 2;
    boolean hasCameraFlash = false;
    private boolean isFlashOn = false;

    Button button_sun;

    ImageButton buttonCamera;
    ImageButton buttonCompas;

    Button baza;
    ImageButton webView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        button_sun = findViewById(R.id.buton_sun);

        button_sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MActivity.this, SunActivity.class);
                startActivity(intent);
            }
        });

        buttonCompas = findViewById(R.id.button_compass);

        buttonCompas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MActivity.this, CompasActivity.class);
                startActivity(intent);
            }
        });
        buttonCamera = findViewById(R.id.button_camera);

        buttonCamera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MActivity.this, CameraActivity.class);
//                startActivityForResult(intent, NEW_CAMERA_ACTIVITY_REQUEST_CODE);
                startActivity(intent);
            }

        });
        baza = findViewById(R.id.button_baza);


        baza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        webView = findViewById(R.id.button_web);


        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pzw.org.pl/home/"));
                startActivity(intent);
            }
        });


//        ekran = findViewById(R.id.button_wejdz);
//
//
//        ekran.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
        hasCameraFlash = getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        btnFlashLight = findViewById(R.id.button_light);

        btnFlashLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermission(Manifest.permission.CAMERA, CAMERA_REQUEST_CODE);

            }
        });
    }


    private void flashLight() {
        if (hasCameraFlash) {
            if (isFlashOn) {
//                btnFlashLight.setText("ON");
                flashLightOff();
                isFlashOn = false;
            } else {
//                btnFlashLight.setText("OFF");
                flashLightOn();
                isFlashOn = true;
            }
        } else {
            Toast.makeText(MActivity.this, "No flash available on your device",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void flashLightOn() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
        } catch (CameraAccessException e) {
        }
    }

    private void flashLightOff() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {
        }
    }

    private void askPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            // We Dont have permission
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);

        } else {
            // We already have permission do what you want
            flashLight();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    hasCameraFlash = getPackageManager().
                            hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
                    Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_LONG).show();
                    flashLight();

                } else {
                    Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
