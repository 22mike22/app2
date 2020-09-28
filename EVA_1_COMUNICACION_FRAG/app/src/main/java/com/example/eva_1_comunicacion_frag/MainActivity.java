package com.example.eva_1_comunicacion_frag;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListFragment listFragment;
    DataFragment dataFragment;

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if(ListFragment.class == fragment.getClass()){
           listFragment
        }else{

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
