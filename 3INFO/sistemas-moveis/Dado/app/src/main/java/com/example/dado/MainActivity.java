package com.example.dado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button bSorteia;
    ImageView iDado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bSorteia=findViewById(R.id.bSorteia);
        iDado=findViewById(R.id.iDado);
        bSorteia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sorteia=new Random().nextInt(6);
                if(sorteia==0){
                    iDado.setImageResource(R.drawable.um);
                }
                if(sorteia==1){
                    iDado.setImageResource(R.drawable.dois);
                }
                if(sorteia==2){
                    iDado.setImageResource(R.drawable.tres);
                }
                if(sorteia==3){
                    iDado.setImageResource(R.drawable.quatro);
                }
                if(sorteia==4){
                    iDado.setImageResource(R.drawable.cinco);
                }
                if(sorteia==5){
                    iDado.setImageResource(R.drawable.seis);
                }

            }
        });

    }
}