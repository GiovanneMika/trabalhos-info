package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText tAltura, tPeso;
    Button bVerifica;
    ImageView iArnold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tAltura = findViewById(R.id.tAltura);
        tPeso = findViewById(R.id.tPeso);
        iArnold = findViewById(R.id.iArnold);
        bVerifica = findViewById(R.id.bVerifica);
        bVerifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double Altura = Double.parseDouble(tAltura.getText().toString());
                Double Peso = Double.parseDouble(tPeso.getText().toString());
                Double IMC = Peso/(Altura*Altura);
                if(IMC>26){
                    iArnold.setImageResource(R.drawable.gordo);
                }
                else if(IMC>=18.5 && IMC<=24.9){
                    iArnold.setImageResource(R.drawable.aprovado);
                }
                else{
                    iArnold.setImageResource(R.drawable.magro);
                }
            }
        });
    }
}