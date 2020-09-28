package com.example.eva_1_comunicacion_frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class ListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
        FrameLayout frameLayout=(FrameLayout)inflater.inflate(R.layout.fragment_blank, container, false);

        ListView lstVwDatos;
        lstVwDatos=frameLayout.findViewById(R.id.listVwDatos);
        lstVwDatos.setAdapter(new ArrayAdapter<>(
                main,
                android.R.layout.simple_list_item_1,
                s
        ));

        lstVwDatos.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return frameLayout;
    }
    String[] s={"hola","como","estas?"};
    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main=(MainActivity)getActivity();

    }
}
