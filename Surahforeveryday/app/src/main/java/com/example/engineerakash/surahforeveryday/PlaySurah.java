package com.example.engineerakash.surahforeveryday;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
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
    TextView banglaFont;
    TextView arbiFont;
    //String nameOfSurah = getIntent().getStringExtra("surahName");
    String fatihaBangla = "সূরা আল ফাতিহা\n" +
            "শুরু করছি আল্লাহর নামে যিনি পরম করুণাময়, অতি দয়ালু।\n" +
            "যাবতীয় প্রশংসা আল্লাহ তা’আলার যিনি সকল সৃষ্টি জগতের পালনকর্তা।\n" +
            "যিনি নিতান্ত মেহেরবান ও দয়ালু।\n" +
            "যিনি বিচার দিনের মালিক।\n";
    String asrBangla = "সূরা আছর\n" +
            "কসম যুগের (সময়ের),\n" +
            "নিশ্চয় মানুষ ক্ষতিগ্রস্ত;\n" +
            "কিন্তু তারা নয়, যারা বিশ্বাস স্থাপন করে ও সৎকর্ম করে\n";
    String kautharBangla = "সূরা কাওসার \n" +
            "\n" +
            "নিশ্চয় আমি আপনাকে কাওসার দান করেছি।\n" +
            "অতএব আপনার পালনকর্তার উদ্দেশ্যে নামায পড়ুন\n" +
            "যে আপনার শত্রু, সেই তো লেজকাটা, নির্বংশ।\n";
    String qurayshBangla = "সূরা কোরাইশ \n" +
            "কোরাইশের আসক্তির কারণে,\n" +
            "আসক্তির কারণে তাদের শীত ও গ্রীষ্মকালীন সফরের।\n" +
            "অতএব তারা যেন এবাদত করে এই ঘরের পালনকর্তার\n" +
            "যিনি তাদেরকে ক্ষুধায় আহার দিয়েছেন।\n";
    String nasrBangla = "সূরা নছর\n" +
            "যখন আসবে আল্লাহর সাহায্য ও বিজয়\n" +
            "এবং আপনি মানুষকে দলে দলে আল্লাহর দ্বীনে প্রবেশ করতে দেখবেন,\n" +
            "তখন আপনি আপনার পালনকর্তার পবিত্রতা বর্ণনা করুন\n";
    String fatihaArabic = "بِسْمِ اللّهِ الرَّحْمـَنِ الرَّحِيمِ\n" +
            "الْحَمْدُ للّهِ رَبِّ الْعَالَمِينَ\n" +
            "الرَّحْمـنِ الرَّحِيمِ\n" +
            "مَـالِكِ يَوْمِ الدِّينِ\n" +
            "إِيَّاكَ نَعْبُدُ وإِيَّاكَ نَسْتَعِينُ\n" +
            "اهدِنَــــا الصِّرَاطَ المُستَقِيمَ\n" +
            "صِرَاطَ الَّذِينَ أَنعَمتَ عَلَيهِمْ غَيرِ المَغضُوبِ عَلَيهِمْ وَلاَ الضَّالِّينَ\n";
    String asrArabic = "وَالْعَصْرِ\n" +
            "إِنَّ الْإِنسَانَ لَفِي خُسْرٍ\n" +
            "إِلَّا الَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ وَتَوَاصَوْا بِالْحَقِّ وَتَوَاصَوْا بِالصَّبْرِ\n";
    String kautharArabic = "إِنَّا أَعْطَيْنَاكَ الْكَوْثَرَ\n" +
            "فَصَلِّ لِرَبِّكَ وَانْحَرْ\n" +
            "إِنَّ شَانِئَكَ هُوَ الْأَبْتَرُ\n";
    String quraysArabic = "لِإِيلَافِ قُرَيْشٍ\n" +
            "إِيلَافِهِمْ رِحْلَةَ الشِّتَاء وَالصَّيْفِ\n" +
            "فَلْيَعْبُدُوا رَبَّ هَذَا الْبَيْتِ\n" +
            "الَّذِي أَطْعَمَهُم مِّن جُوعٍ وَآمَنَهُم مِّنْ خَوْفٍ\n";
    String nasrArabic = "إِذَا جَاء نَصْرُ اللَّهِ وَالْفَتْحُ\n" +
            "وَرَأَيْتَ النَّاسَ يَدْخُلُونَ فِي دِينِ اللَّهِ أَفْوَاجًا\n" +
            "فَسَبِّحْ بِحَمْدِ رَبِّكَ وَاسْتَغْفِرْهُ إِنَّهُ كَانَ تَوَّابًا\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_surah);
        surahNameText = (TextView) findViewById(R.id.anyText);
        palyStatus = (TextView) findViewById(R.id.playingStatus);
        banglaFont = (TextView) findViewById(R.id.bangla);
        arbiFont = (TextView) findViewById(R.id.arabic);
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
    //create menu
    /*@Override
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
    }*/

    public void getAllSura(View view) {
        if (m > 2)
        {
            surahMedia.stop();
        }
        Intent goToListOfSurahActivity = new Intent(getBaseContext(), ListOfSurahActivity.class);
        startActivity(goToListOfSurahActivity);
    }

    public void banglaString(View view) {
        int mediaIdForBanglaString = getIntent().getIntExtra("mediaId", 1);
        Typeface tfb = Typeface.createFromAsset(getAssets(), "fonts/kalpurush.ttf");
        banglaFont.setTypeface(tfb);
        switch (mediaIdForBanglaString)
        {
            case R.raw.al_fatiha:
            {
                banglaFont.setText(fatihaBangla);
                break;
            }
            case R.raw.al_asr:
            {
                banglaFont.setText(asrBangla);
                break;
            }
            case R.raw.al_kauthar:
            {
                banglaFont.setText(kautharBangla);
                break;
            }
            case R.raw.al_quraysh:
            {
                banglaFont.setText(qurayshBangla);
                break;
            }
            case R.raw.an_nasr:
            {
                banglaFont.setText(nasrBangla);
                break;
            }
            default:
            {
                banglaFont.setText("wait for next upadte!");
                break;
            }
        }
        /*final AlertDialog.Builder bangla = new AlertDialog.Builder(PlaySurah.this);
        bangla.setMessage("nameOfSurah");
        bangla.setCancelable(true);
        bangla.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog banglaLearn = bangla.create();
        banglaLearn.show();*/
    }

    public void arabicString(View view) {
        int mediaIdForArabicString = getIntent().getIntExtra("mediaId", 1);
        Typeface tfa = Typeface.createFromAsset(getAssets(), "fonts/aayatquraan2.ttf");
        arbiFont.setTypeface(tfa);
        switch (mediaIdForArabicString)
        {
            case R.raw.al_fatiha:
            {
                arbiFont.setText(fatihaArabic);
                break;
            }
            case R.raw.al_asr:
            {
                arbiFont.setText(asrArabic);
                break;
            }
            case R.raw.al_kauthar:
            {
                arbiFont.setText(kautharArabic);
                break;
            }
            case R.raw.al_quraysh:
            {
                arbiFont.setText(quraysArabic);
                break;
            }
            case R.raw.an_nasr:
            {
                arbiFont.setText(nasrArabic);
                break;
            }
            default:
            {
                arbiFont.setText("wait for next upadte!");
                break;
            }
        }
        /*final AlertDialog.Builder arabic = new AlertDialog.Builder(PlaySurah.this);
        arabic.setMessage(string1).toString();
        arabic.setCancelable(true);
        arabic.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog arabicLearn = arabic.create();
        arabicLearn.show();*/
    }
}
