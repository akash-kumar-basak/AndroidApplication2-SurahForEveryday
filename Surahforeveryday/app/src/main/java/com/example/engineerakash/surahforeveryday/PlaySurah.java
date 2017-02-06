package com.example.engineerakash.surahforeveryday;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaySurah extends AppCompatActivity {
    int i = 1, m = 1;
    private ArrayList<SurahProfile> mySurahProfiles;
    static MediaPlayer surahMedia;
    SurahProfileAdaptar surahProfileAdaptar;
    TextView surahNameText;
    TextView palyStatus;
    //String nameOfSurah = getIntent().getStringExtra("surahName");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_surah);
        surahNameText = (TextView) findViewById(R.id.nameOfSurah);
        palyStatus = (TextView) findViewById(R.id.playingStatus);
    }
    public void plays(View view) {
            if (i < 2)
        {
            int mediaId = getIntent().getIntExtra("mediaId", 1);
            surahMedia = MediaPlayer.create(getBaseContext(), mediaId);
            surahMedia.start();
            i++;
            m = 3;
        }
    }

    public void stops(View view) {
        surahMedia.stop();
        if(i >= 2 )
        {
            //palyStatus.setText(" ");
            i--;
        }
    }
    @Override
    public void onBackPressed() {
        if (m > 2)
        {
            surahMedia.stop();
        }
        Intent gotoListActivity = new Intent(getBaseContext(), ListOfSurahActivity.class);
        startActivity(gotoListActivity);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    public void helpMethod(MenuItem item) {
        final AlertDialog.Builder helpString = new AlertDialog.Builder(PlaySurah.this);
        helpString.setMessage("User guide:" +
                "\n1.Click any Surah name then click play button." +
                "\n2.Click Stop for stop current playing surah." +
                "\n3.Some surah is premium, so u first need to" +
                "\n buy this for play.");
        helpString.setCancelable(true);
        helpString.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog userHelp = helpString.create();
        userHelp.show();
    }

    public void aboutMethod(MenuItem item) {
        final AlertDialog.Builder aboutString = new AlertDialog.Builder(PlaySurah.this);
        aboutString.setMessage("About:" +
                "\nDeveloper: akash kumar basak" +
                "\nFirst release date:5-2-2017." +
                "\nVersion: 1.0.0");
        aboutString.setCancelable(true);
        aboutString.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog aboutApp = aboutString.create();
        aboutApp.show();
    }

    public void getAllSura(View view) {
        Intent goToListOfSurahActivity = new Intent(getBaseContext(), ListOfSurahActivity.class);
        startActivity(goToListOfSurahActivity);
    }
}
