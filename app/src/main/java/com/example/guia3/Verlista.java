package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import static com.example.guia3.MainActivity.arrayAdapter;

public class Verlista extends AppCompatActivity {
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlista);

        lv1=findViewById(R.id.lv1);
        lv1.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        lv1.setAdapter(arrayAdapter);
    }
}