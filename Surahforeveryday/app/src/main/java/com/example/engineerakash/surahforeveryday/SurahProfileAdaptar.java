package com.example.engineerakash.surahforeveryday;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ENGINEER AKASH on 2/5/2017.
 */
public class SurahProfileAdaptar extends ArrayAdapter<SurahProfile> {
    private Context context;
    private ArrayList<SurahProfile> mySurahProfiles;

    public SurahProfileAdaptar(Context context, ArrayList<SurahProfile> mySurahProfiles) {
        super(context, R.layout.every_row, mySurahProfiles);
        this.context = context;
        this.mySurahProfiles = mySurahProfiles;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.every_row,null,true);
        //intialize
        TextView surahName = (TextView) convertView.findViewById(R.id.nameOfSurah);
        TextView costing = (TextView) convertView.findViewById(R.id.costoOfSurah);
        //position set
        surahName.setText(mySurahProfiles.get(position).getSurahName());
        costing.setText(mySurahProfiles.get(position).getSurahCost());
        surahName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mySurahProfiles.get(position).isPaid() == false)
                {
                    Intent goToPlayActivity = new Intent(context, PlaySurah.class);
                    goToPlayActivity.putExtra("surahName", mySurahProfiles.get(position).getSurahName());
                    goToPlayActivity.putExtra("mediaId", mySurahProfiles.get(position).getSurahMediaFile());
                    context.startActivity(goToPlayActivity);
                }
                else
                {
                    Toast.makeText(context, "You should buy this for play!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return convertView;
    }
}
