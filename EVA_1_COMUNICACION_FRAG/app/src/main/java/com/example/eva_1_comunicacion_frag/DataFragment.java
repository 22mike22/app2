package com.example.eva_1_comunicacion_frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DataFragment extends Fragment {
    TextView txtVwDatos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.fragment_data, container, false);
        Button btnDatos=linearLayout.findViewById(R.id.btnData);
        txtVwDatos=linearLayout.findViewById(R.id.textViewDatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return linearLayout;
    }
}
