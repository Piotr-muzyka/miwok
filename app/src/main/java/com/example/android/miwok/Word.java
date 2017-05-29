package com.example.android.miwok;

import android.content.Context;

/**
 * Created by PMUZYKA on 2017-05-25.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;


    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation= defaultTranslation;
        mMiwokTranslation= miwokTranslation;
    }
    public String getEnglishTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
}
