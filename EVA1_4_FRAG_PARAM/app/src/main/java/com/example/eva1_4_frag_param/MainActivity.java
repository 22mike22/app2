package com.example.eva1_4_frag_param;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void crearFrag(View v){
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();

        ParamFragment paramFragment=ParamFragment.newInstance("hola mundo", "valores asignados");

        ft.replace(R.id.frmLyFrag,paramFragment);

        ft.commit();
    }
}
