package com.example.a6;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(this,R.raw.jojo);
    }

    public void iniciar(View v){
        if(mediaPlayer!=null)
            mediaPlayer.start();
        Toast.makeText(this,"hola",Toast.LENGTH_SHORT).show();
    }
    public void detener(View v){
        if(mediaPlayer!=null)
            mediaPlayer.stop();
    }


}
