package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent inServicio;
    Button Button,Button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inServicio=new Intent(this,MyService.class);
        BroadcastReceiver breceiver=new MiBroadCastReceiver();

        IntentFilter intentFilter=new IntentFilter("Mi Servicio");
        registerReceiver(breceiver,intentFilter);

        Button=findViewById(R.id.button);
        Button2=findViewById(R.id.button2);
        Button.setOnClickListener(this);
        Button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                iniciar(v);
                break;
            case R.id.button2:
                cerrar(v);
                break;
        }
    }

    public void iniciar(View v){
        inServicio.putExtra("dato","mi actividad");
        startService(inServicio);
    }
    public void cerrar(View v){
        stopService(inServicio);
    }
    class  MiBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //Procesamos un mensaje
            Log.wtf("Mensaje","thread");
        }
    }
}
