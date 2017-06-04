package com.example.android.miwok;

import android.content.Context;

/**
 * Created by PMUZYKA on 2017-05-25.
 */

public class Word {
    // English translation of the word
    private String mDefaultTranslation;
    // Miwok translation of the word
    private String mMiwokTranslation;
    // Image representing word Id
    private int resourceId;
    // Pronounciation recording
    private int musicId;
    // Are there images for words/phrases available ?
    public static boolean hasAnImage=false;




    public Word(String defaultTranslation, String miwokTranslation, int mMusicId){
        mDefaultTranslation= defaultTranslation;
        mMiwokTranslation= miwokTranslation;
        musicId = mMusicId;


    }

    // Overloading constructor - multiple constructors for a Java class
    //in this scenario we need one constructor with 2 TextViews and an ImageView in order to create ListView for most activities
    // and a second constructor for Phrases activity which has no ImageView - constructor without mResourceId.

    public Word(String defaultTranslation, String miwokTranslation, int mResourceId, int mMusicId){
        mDefaultTranslation= defaultTranslation;
        mMiwokTranslation= miwokTranslation;
        resourceId = mResourceId;
        musicId = mMusicId;

    }
    public String getEnglishTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getResourceId() {
        return resourceId;
    }
    public int getMusicId(){return musicId;}
    public boolean hasAnImage(){
        return hasAnImage;
    }
}
