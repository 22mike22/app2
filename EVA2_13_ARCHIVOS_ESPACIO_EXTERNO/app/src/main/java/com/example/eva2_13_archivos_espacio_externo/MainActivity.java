package com.example.eva2_13_archivos_espacio_externo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtDatos;
    String rutaSDApp, rutaSD;
    boolean bLeerEscArch = false;
    final static int PERMISO_ESCRITURA = 100;
    final static String ARCHIVO = "prueba.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtDatos = findViewById(R.id.edtTxtDatos);
        rutaSD = Environment.getExternalStorageDirectory().getAbsolutePath();
        rutaSDApp = getExternalFilesDir(null).getAbsolutePath();
        Log.wtf("rutaSD", rutaSD);
        Log.wtf("rutaSDApp", rutaSDApp);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISO_ESCRITURA);
            } else {
                bLeerEscArch = true;
            }
        } else {
            bLeerEscArch = true;
        }
    }

    public void guardar() {
        if (bLeerEscArch) {
            String[] aCadenas=edtTxtDatos.getText().toString().split("\n");
            try {
                FileOutputStream fos = new FileOutputStream(rutaSD+"/"+ARCHIVO);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                for(int i=0;i<aCadenas.length;i++){
                    bw.append(aCadenas[i]);
                    bw.append("\n");
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void leer() {
        if (bLeerEscArch) {
            String sCade;
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(rutaSD+"/"+ARCHIVO);

                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                while ((sCade=br.readLine())!=null){
                    edtTxtDatos.append(sCade);
                    edtTxtDatos.append("\n");
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISO_ESCRITURA) {
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                bLeerEscArch=true;
            }
        }
    }
}
