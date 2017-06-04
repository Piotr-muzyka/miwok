/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
    @Override
    protected void onStop(){
        super.onStop();

        releaseMediaPlayer();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        Word.hasAnImage=false;
        // we use final so we can reference the listView inside onItemClick.
        final ArrayList<Word> phrases = new ArrayList<Word>();

        // populate the ListView with entries.
        phrases.add(new Word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I’m feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes, I’m coming.","oyaaset...", R.raw.phrase_yes_im_coming));
        phrases.add(new Word("I’m coming.","michәksәs?", R.raw.phrase_im_coming));
        phrases.add(new Word("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        phrases.add(new Word("Come here.","әnni'nem", R.raw.phrase_come_here));

        WordAdapter itemsAdapter = new WordAdapter(this,phrases, R.color.category_phrases);



        ListView listView = (ListView) findViewById(R.id.listview_word);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, View selectedView, int position, long id) {


                releaseMediaPlayer();
//                Log.d("ON ITEM CLICK...", " ON ITEM CLICK... "+ position + phrases.get(position).getMusicId());
                Log.v("NumbersActivity", "Current word: " + phrases.toString());
                // here we are referencing a certain Word Object inside a ListView. We are referencing a method which returns songId
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, phrases.get(position).getMusicId());

                //start the audio file
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    public void onCompletion(MediaPlayer mp) {
                        Toast toast = Toast.makeText(PhrasesActivity.this, "Song finished", Toast.LENGTH_LONG);
                        toast.show();
                        mediaPlayer.release();
                        releaseMediaPlayer();
                    }
                });
            }
        });

        /**
         * Clean up the media player by releasing its resources.
         */



    }
}
