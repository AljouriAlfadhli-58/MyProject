package com.example.mahaasel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent i = new Intent(getApplicationContext(), Page1.class);
                    startActivity(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();


        Handler h = new Handler(getMainLooper());
        final Runnable r = new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(), Page1.class);
                startActivity(i);
            }
        };
        h.postDelayed(r,2000);

    }
    }