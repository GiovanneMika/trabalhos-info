package com.example.idade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText tIdade;
    Button bCalcula;
    TextView tResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tIdade = findViewById(R.id.tIdade);
        bCalcula = findViewById(R.id.bCalcula);
        tResultado = findViewById(R.id.tResultado);
        bCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double idade = Double.parseDouble(tIdade.getText().toString());
                    if(tIdade.getText()/)
                tResultado.setText("Já viveu "+Double.toString(idade*12)+" meses");
            }
        });
    }
}