package com.example.android.miwok;

import android.content.Context;

/**
 * Created by PMUZYKA on 2017-05-25.
 */

public class Word {

    private String miwokTranslation;
    private String englishTranslation;

    public Word(Context context){
        miwokTranslation="test";
        englishTranslation="test2";
    }
    public String getEnglishTranslation(String text){
        return englishTranslation=text;
    }

    public String getMiwokTranslation(String text){
        return miwokTranslation=text;
    }
}
