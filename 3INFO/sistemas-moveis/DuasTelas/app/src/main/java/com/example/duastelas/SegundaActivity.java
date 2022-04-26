package com.example.duastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    TextView lOla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        lOla = findViewById(R.id.lOla);
        Bundle parameters = getIntent().getExtras();
        if (parameters != null) {
            String login = parameters.getString("login");
            lOla.setText("Ola" + login + ", seja bem vindo!");
        }
    }
}