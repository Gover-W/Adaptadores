package com.example.adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adaptadores.clase.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText edt_nombre, edt_contra;
    Button btn_login;

    SharedPreferences sharedPreferennces;
    SharedPreferences.Editor editor;
    public static final String dataUser = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            edt_nombre = findViewById(R.id.edt_nombre);
            edt_contra = findViewById(R.id.edt_contra);
            btn_login = findViewById(R.id.btn_login);

            sharedPreferennces = getSharedPreferences(dataUser, modo_private);
            editor = sharedPreferennces.edit();
            dato = getApplicationContext().getSharedPreferences(dataUser,modo_private).getString("user","0");

            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!edt_nombre.getText().toString().isEmpty() && !edt_contra.getText().toString().isEmpty()){
                        Context context = MainActivity.this;
                        Intent intent = new Intent(context, MainActivity2.class);
                        context.startActivity(intent);
                    }else {
                        edt_nombre.setError("Ingrese un nombre");
                        edt_contra.setError("Ingrese una contraseña");
                    }
                }
            });

        if (!dato.equalsIgnoreCase("0")){
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
            finish();
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("user",edt_nombre.getText().toString());
                editor.commit();
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

    }
}