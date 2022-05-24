package com.example.duastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText tLogin, tSenha;
    Button bLogin;
    CheckBox bLembrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tLogin = findViewById(R.id.tLogin);
        tSenha = findViewById(R.id.tSenha);
        bLogin = findViewById(R.id.bLogin);
        bLembrar = findViewById(R.id.bLembrar);
        try {
            InputStream arq = openFileInput("senhas.txt");
            if (arq != null) {
                String[] i = lerTexto();
                System.out.println("uuuu"+i[1]);
                tLogin.setText(i[0]);
                tSenha.setText(i[1]);
                arq.close();
            }else{
                tLogin.setText("");
                tSenha.setText("");
            }
        } catch (IOException e) {
            Log.v("MainActivity", e.getMessage());
        }
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tLogin.getText().toString().equals("fulano") && tSenha.getText().toString().equals("1234")){
                    Intent i=new Intent(MainActivity.this, SegundaActivity.class);
                    i.putExtra("login", tLogin.getText().toString());
                    startActivity(i);
                    if(bLembrar.isChecked()){
                        gravarTexto(tLogin.getText().toString(), tSenha.getText().toString());
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Login e/ou senha inválidos", Toast.LENGTH_SHORT).show();
                }


                }


        });
    }
    private void gravarTexto(String user, String senha) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("senhas.txt", Context.MODE_PRIVATE));
            osw.write(user+"\n");
            osw.write(senha);
            osw.close();
        } catch (IOException e) {
            Log.v("MainActivity", e.getMessage());
        }
    }

    private String[] lerTexto() {
        String user = "";
        String[] coisas;
        coisas = new String[2];
        Integer contador=0;
        try {
            InputStream arq = openFileInput("senhas.txt");
            if (arq != null) {
                InputStreamReader isr = new InputStreamReader(arq);
                BufferedReader bis = new BufferedReader(isr);
                String linhalida = "";
                while ((linhalida = bis.readLine()) != null) {
                    coisas[contador]=linhalida;
                    contador++;
                }
                arq.close();
            }
        } catch (IOException e) {
            Log.v("MainActivity", e.getMessage());
        }
        return coisas;
    }
}