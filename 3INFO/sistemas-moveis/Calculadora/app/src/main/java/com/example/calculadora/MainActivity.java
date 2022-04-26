package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText tValorA, tValorB;
    Button bSoma, bSubtrai, bDivide, bMultiplica;
    TextView tResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tValorA = findViewById(R.id.tValorA);
        tValorB = findViewById(R.id.tValorB);
        bSoma = findViewById(R.id.bSoma);
        bSubtrai = findViewById(R.id.bSubtrai);
        bMultiplica = findViewById(R.id.bMultiplica);
        bDivide = findViewById(R.id.bDivide);
        tResultado = findViewById(R.id.tResultado);
        bSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    double a = Double.parseDouble(tValorA.getText().toString());
                    double b = Double.parseDouble(tValorB.getText().toString());
                    tResultado.setText(Double.toString(a+b));
                }
            });
        bSubtrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(tValorA.getText().toString());
                double b = Double.parseDouble(tValorB.getText().toString());
                tResultado.setText(Double.toString(a-b));
            }
        });
        bMultiplica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(tValorA.getText().toString());
                double b = Double.parseDouble(tValorB.getText().toString());
                tResultado.setText(Double.toString(a*b));
            }
        });
        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(tValorA.getText().toString());
                double b = Double.parseDouble(tValorB.getText().toString());
                tResultado.setText(Double.toString(a/b));
            }
        });

        }
    }