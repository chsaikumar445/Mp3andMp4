package com.example.mp3and4player;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView video = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);

        String[] videonames = {"video1","video2","video3"};

        ArrayAdapter<String> videoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,videonames);

        ListView videolist= (ListView) findViewById(R.id.video_list);

        videolist.setAdapter(videoAdapter);

         videolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String videoid=(String) parent.getItemAtPosition(position);
                 switch (videoid){
                     case "video1":
                         Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1);
                         video.setVideoURI(uri);
                         video.start();
                         break;
                     case "video2":
                        uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video2);
                         video.setVideoURI(uri);
                         video.start();
                         break;
                     case "video3":
                          uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video3);
                         video.setVideoURI(uri);
                         video.start();
                         break;
                 }
             }
         });

    }
}