package com.example.miwokupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;


    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            Toast.makeText(Numbers.this, "!", Toast.LENGTH_SHORT).show();
            releaseMediaPlayer();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        Toast.makeText(this, "WELCOME TO NUMBERS ACTIVITY", Toast.LENGTH_SHORT).show();

        //NEECHE FINAL ISLIYE LIKHA HAI KYUKI MUJE ARRAY LIS KO SETONCLICK LISTNER VALI ANNOYMOUS CLASS MAI USE KRNA HAI JO KI
        // SRIF FINL CLASS VALO KO HI USE KRNE DETI HAI.
       final ArrayList<NumbersConstructor> numbersConstructors = new ArrayList<NumbersConstructor>(0);
        /*
        AB YAHA PE MAI new NumbersConstructor() ka ek constructor banna rha hun aur usme value bej rha hun
        jo ki numbersconstructors mai hai sab.
        harr line mai ek naya object create ho rhau hai.
         */
        numbersConstructors.add(new NumbersConstructor("One", "Lutti", R.drawable.number_one,R.raw.audio_number_one));
        numbersConstructors.add(new NumbersConstructor("Two", "Tooti", R.drawable.number_two,R.raw.audio_number_two));
        numbersConstructors.add(new NumbersConstructor("Three", "threeti", R.drawable.number_three,R.raw.audio_number_three));
        numbersConstructors.add(new NumbersConstructor("Four", "forri", R.drawable.number_four,R.raw.audio_number_four));
        numbersConstructors.add(new NumbersConstructor("Five", "fivirr", R.drawable.number_five,R.raw.audio_number_five));
        numbersConstructors.add(new NumbersConstructor("Six", "sixxrerer", R.drawable.number_six,R.raw.audio_number_six));
        numbersConstructors.add(new NumbersConstructor("Seven", "sevenene", R.drawable.number_seven,R.raw.audio_number_seven));
        numbersConstructors.add(new NumbersConstructor("Eight", "egfgbgf", R.drawable.number_eight,R.raw.audio_number_eight));
        numbersConstructors.add(new NumbersConstructor("Nine", "ngf", R.drawable.number_nine,R.raw.audio_number_nine));
        numbersConstructors.add(new NumbersConstructor("Ten", "trefef", R.drawable.number_ten,R.raw.audio_number_ten));

        /*
        YEH EK ADAPTER CLASS HAI JO LIST KO VIEW BANAKE DEGI KI KAISE PRINT KRNA HAI VIEWS KO
        ISKA KAM HOTA HAI  VIEWS MAI HONE VALE DATA KO EKSATH LANA AUR READY KRKE JAB LIST MAANGE USE BEJ DENBA

         */
        NumbersAdapter adapter = new NumbersAdapter(this, numbersConstructors);

        /*
        AB YEH ARRAY ADAPTER KO BOLTA HAI KI BHAI KITNE VIEWS BANA DIYE HAU TOH VO MEREKO RETURN KRDE
        AUR ISKE BAAD VO LIST VIEWS MAI SAARE VIEWS KO DAAL DETA HAI..
         */
        ListView listView = (ListView) findViewById(R.id.Numberslist);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();//KI AGR PHELE SE KOI HOGA TOH VO BI RELASE HO JAYE
                NumbersConstructor numbersaudio=numbersConstructors.get(position);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    mMediaPlayer = MediaPlayer.create(Numbers.this, numbersaudio.getNumbersAudio());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;


            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}

