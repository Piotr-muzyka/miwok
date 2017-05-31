package com.example.android.miwok;

import android.content.Context;

/**
 * Created by PMUZYKA on 2017-05-25.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int resourceId;


    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation= defaultTranslation;
        mMiwokTranslation= miwokTranslation;
    }

    // Overloading constructor - multiple constructors for a Java class
    //in this scenario we need one constructor with 2 TextViews and an ImageView in order to create ListView for most activities
    // and a second constructor for Phrases activity which has no ImageView - constructor without mResourceId.

    public Word(String defaultTranslation, String miwokTranslation, int mResourceId){
        mDefaultTranslation= defaultTranslation;
        mMiwokTranslation= miwokTranslation;
        resourceId = mResourceId;
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
}
