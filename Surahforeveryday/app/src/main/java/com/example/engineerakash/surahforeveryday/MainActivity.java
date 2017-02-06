package com.example.engineerakash.surahforeveryday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    //Delay time
    private final static int TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //implement os handlers method
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToHomeActivity = new Intent(MainActivity.this, ListOfSurahActivity.class);
                startActivity(goToHomeActivity);
            }
        }, TIME);
    }
}
