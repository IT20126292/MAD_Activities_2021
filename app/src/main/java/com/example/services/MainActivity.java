package com.example.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintAttribute;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    Button btn_Start;
    Button btn_Stop;
    Button btn_Puase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_Start = this.findViewById(R.id.btn_Start);
        btn_Stop = this.findViewById(R.id.btn_Stop);
        btn_Puase = this.findViewById(R.id.btn_Puase);

        /*btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this, MyServices.class));
            }
        });

        btn_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this, MyServices.class));
            }
        });*/
    }

    public void play(View view) {
        if (player == null) {
            Toast.makeText(this, "Music Started", Toast.LENGTH_SHORT).show();
            player = MediaPlayer.create(getApplicationContext(), R.raw.teriyaki_boyz);
            /*player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });*/
            player.start();
        } else {
            player.start();
        }
    }

    public void pause(View view){
        if(player != null){
            player.pause();
            Toast.makeText(this, "Music Paused", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View view){
        stopPlayer();
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    private void stopPlayer() {
        if(player != null){
            player.release();
            player = null;
            Toast.makeText(this, "Music Stoped", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Mediaplayer released", Toast.LENGTH_LONG).show();
        }
    }
}