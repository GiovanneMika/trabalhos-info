package com.example.nascimento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText tData;
    Button bCalcula;
    TextView tResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tData = findViewById(R.id.tData);
        bCalcula = findViewById(R.id.bCalcula);
        tResultado = findViewById(R.id.tResultado);
        bCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendario c = new Calendario();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
                try {
                    c.setDatanasc(Calendar.getInstance());
                    c.getDatanasc().setTime(sdf.parse(tData.getText().toString()));
                    c.calcula();
                    tResultado.setText("Você já viveu " + c.getMes() + " meses, " +c.getDia() + " dias, " + c.getHora() + " horas e " + c.getMinuto() + " minutos " );
                }catch(ParseException e){
                    tResultado.setText("ERROR 404 ;-;");
                }
            }
        });
    }
}