package com.example.engineerakash.surahforeveryday;

import java.util.ArrayList;

/**
 * Created by ENGINEER AKASH on 2/5/2017.
 */
public class SurahProfile {
    //declare all variables
    private String surahName;
    private int surahMediaFile;
    private String surahCost;
    private boolean isPaid;

    public SurahProfile(String surahName, int surahMediaFile, String surahCost, boolean isPaid) {
        this.surahName = surahName;
        this.surahMediaFile = surahMediaFile;
        this.surahCost = surahCost;
        this.isPaid = isPaid;
    }

    public SurahProfile() {
    }

    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }

    public int getSurahMediaFile() {
        return surahMediaFile;
    }

    public void setSurahMediaFile(int surahMediaFile) {
        this.surahMediaFile = surahMediaFile;
    }

    public String getSurahCost() {
        return surahCost;
    }

    public void setSurahCost(String surahCost) {
        this.surahCost = surahCost;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
    //create a method for take all profiles information means initialize/take all variables value
    public ArrayList<SurahProfile> getAllSurahProfile()
    {
        ArrayList<SurahProfile> newSurah = new ArrayList<>();
        newSurah.add(new SurahProfile("Al fatiha", R.raw.al_fatiha, "Free", false));
        newSurah.add(new SurahProfile("Al asr", R.raw.al_asr, "Free", false));
        newSurah.add(new SurahProfile("Al kauthar", R.raw.al_kauthar, "Free", false));
        newSurah.add(new SurahProfile("Al quraysh", R.raw.al_quraysh, "Free", false));
        newSurah.add(new SurahProfile("Al nasr", R.raw.an_nasr, "Free", false));
        newSurah.add(new SurahProfile("Al ariah", R.raw.al_ariah, "Free", false));
        newSurah.add(new SurahProfile("Al facl", R.raw.al_facl, "Free", false));
        newSurah.add(new SurahProfile("Al falaq", R.raw.al_falaq, "$5", true));
        newSurah.add(new SurahProfile("Al humaza", R.raw.al_humaza, "Free", false));
        newSurah.add(new SurahProfile("Al ikhlas", R.raw.al_ikhlas, "Free", false));
        newSurah.add(new SurahProfile("Al qadr", R.raw.al_qadr, "$1.50", true));
        newSurah.add(new SurahProfile("Al lahab", R.raw.al_lahab, "$30", true));
        newSurah.add(new SurahProfile("Al kafirun", R.raw.al_kafirun, "$8.50", true));
        newSurah.add(new SurahProfile("Al maun", R.raw.al_maun, "Free", false));
        newSurah.add(new SurahProfile("At tin", R.raw.at_tin, "Free", false));
        newSurah.add(new SurahProfile("Al nas", R.raw.an_nas, "Free", false));
        newSurah.add(new SurahProfile("Al takathur", R.raw.at_takathur, "$12", true));
        newSurah.add(new SurahProfile("Al alaq", R.raw.al_alaq, "Free", false));
        newSurah.add(new SurahProfile("Al adiyat", R.raw.al_adiyat, "Free", false));
        newSurah.add(new SurahProfile("Al zilzal", R.raw.az_zilzal, "Free", false));
        return newSurah;
    }
}
