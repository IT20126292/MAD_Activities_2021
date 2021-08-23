package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyServices extends Service{
    MediaPlayer player;

//    @Override
//    public void onCreate() {
//        //super.onCreate();
//        MediaPlayer player = MediaPlayer.create(this, R.raw.teriyaki_boyz);
//        player.setLooping(true);
//        player.start();
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(player == null){
            player = MediaPlayer.create(this, R.raw.teriyaki_boyz);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    onDestroy();
                }
            });
        }
        player.setLooping(true);
        player.start();
        //return START_STICKY;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(player != null){
            player.release();
            player = null;
            Toast.makeText(this, "Mediaplayer released", Toast.LENGTH_SHORT).show();
        }
        //player.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
