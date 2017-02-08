package com.example.engineerakash.surahforeveryday;

        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.widget.ListView;

        import java.util.ArrayList;

public class ListOfSurahActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<SurahProfile> arrayList;
    SurahProfileAdaptar surahProfileAdaptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_surah);
        listView = (ListView) findViewById(R.id.surahList);
        SurahProfile surahProfile = new SurahProfile();
        arrayList = surahProfile.getAllSurahProfile();
        surahProfileAdaptar = new SurahProfileAdaptar(this, arrayList);
        listView.setAdapter(surahProfileAdaptar);
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder exitApplication = new AlertDialog.Builder(ListOfSurahActivity.this);
        exitApplication.setMessage("Do you want to exit??");
        exitApplication.setCancelable(true);
        exitApplication.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        exitApplication.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        AlertDialog alertDialog = exitApplication.create();
        alertDialog.show();

    }
    //create menu
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void helpMethod(MenuItem item) {
        final AlertDialog.Builder helpString = new AlertDialog.Builder(ListOfSurahActivity.this);
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
        final AlertDialog.Builder aboutString = new AlertDialog.Builder(ListOfSurahActivity.this);
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
}
