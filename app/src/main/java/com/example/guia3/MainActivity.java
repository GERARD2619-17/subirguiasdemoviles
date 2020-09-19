package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static List<String> listanombres;
    public static ArrayAdapter<String> arrayAdapter;

    Button btndatos;
    Button btnNombre;
    Button btnverlista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndatos = findViewById(R.id.btndatos);
        btnNombre =  findViewById(R.id.btnNombre);
        btnverlista = findViewById(R.id.btnverlista);
        listanombres = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,listanombres);
        btndatos.setOnClickListener(this);
        btnNombre.setOnClickListener(this);
        btnverlista.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnverlista: {
                if(listanombres.isEmpty() ){
                    Toast.makeText(this, "Lo sentimos no podemos mostra la pantalla por que no se han agregado nombres", Toast.LENGTH_LONG).show();

                }else{
                    Intent intent = new Intent(this, Verlista.class);
                    startActivity(intent);
                }
            }
            break;
            case R.id.btnNombre: {
                Intent intent = new Intent(this, Anombre.class);
                startActivity(intent);

            }
            break;
            case R.id.btndatos: {
                Intent intent = new Intent(this, MDato.class);
                startActivity(intent);

            }
            break;
        }
    }
}