package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Thread thread;
    Intent MiIntent;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void onStart(final Intent intent, int startId){
        super.onStart(intent,startId);
        Log.wtf("mi servicio",intent.getStringExtra("dato"));
        thread=new Thread(){
            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        Thread.sleep(1000);
                        MiIntent=new Intent("Mi Servicio");
                        MiIntent.putExtra("enviado","hola");
                        sendBroadcast(MiIntent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
    }
    public void onDestroy(){
        super.onDestroy();

        Log.wtf("mi servicio","onDestroy");
        thread.interrupt();
    }
    public void onCreate(){
        super.onCreate();
        Log.wtf("mi servicio","onCreate");
    }

}
