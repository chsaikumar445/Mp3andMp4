package com.example.mp3and4player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class audio extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);


        String[] audionames = {"audio1","audio2","audio3"};

        ArrayAdapter<String> audioAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,audionames);

        ListView audiolist= (ListView) findViewById(R.id.audio_list);

        audiolist.setAdapter(audioAdapter);

        Button play = findViewById(R.id.play);
        Button pause = findViewById(R.id.pause);
         //mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.audio1);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanUpMediaPlayer();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.audio1);
                mediaPlayer.start();    // playing a audio file
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        });
        audiolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String videoid=(String) parent.getItemAtPosition(position);
                switch (videoid){
                    case "audio1":
                        cleanUpMediaPlayer();
                        MediaPlayer   mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.audio1);

                        mediaPlayer.start();
                        break;
                    case "audio2":
                        cleanUpMediaPlayer();

                         mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.audio2);

                                mediaPlayer.start();    // playing a audio file
                        break;
                    case "audio3":
                        cleanUpMediaPlayer();

                          mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.audio3);

                                mediaPlayer.start();    // playing a audio file

                        break;
                }
            }
        });
    }

    public void cleanUpMediaPlayer(){
        if(mediaPlayer != null) {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
        }
    }
}