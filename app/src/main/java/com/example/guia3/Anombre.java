package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


import static com.example.guia3.MainActivity.listanombres;

public class Anombre extends AppCompatActivity implements View.OnClickListener {

    EditText editname;
    Button btnAgregar;
    ProgressBar progressBar;;
    int porcentaje = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anombre);

        editname = findViewById(R.id.editname);
        btnAgregar = findViewById(R.id.btnAgregar);
        progressBar = findViewById(R.id.progressBar);

        btnAgregar.setOnClickListener(this);
    }
    public boolean validar(){
        boolean valido = true;
        if(editname.getText().toString().isEmpty() ) {
            valido = false;
            editname.setError("Debe ingresar un nombre para agregar a la lista");
        }
        return valido;
    }

    public void agregarNombre(){
        String nombrelista = editname.getText().toString();
        listanombres.add(nombrelista);
    }

    void enviarData(){
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int progreso = 0;
                while (progreso < 100){

                    try{
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    progreso++;


                    final int finalProgreso = progreso;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            progressBar.setProgress(finalProgreso);
                            if(finalProgreso==100) {
                                agregarNombre();
                                finish();
                            }
                        }
                    });

                }

            }
        }).start();



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregar: {
                if(validar()) {
                    enviarData();
                }

            }
            break;
        }
    }
}