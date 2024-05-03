package com.example.adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MainActivity3 extends AppCompatActivity {

    Button btn_cerrar;
    public static final String dataUser = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String dato;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn_cerrar = findViewById(R.id.btn_cerrar);
        dato = getApplicationContext().getSharedPreferences(dataUser,modo_private).getString("user","0");

        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String genero = intent.getStringExtra("genero");
            String imagen = intent.getStringExtra("imagen");


            TextView tx_nombre = findViewById(R.id.tx_nombre);
            TextView tx_genero = findViewById(R.id.tx_genero);
            TextView tx_ciudad = findViewById(R.id.tx_ciudad);
            ImageView imagenn = findViewById(R.id.imagenn);

            tx_nombre.setText(nombre);
            tx_genero.setText(genero);
            tx_ciudad.setText("Citadel of Ricks");
            Picasso.get().load(imagen).into(imagenn);
        }


        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences configuracion = getApplicationContext().getSharedPreferences(dataUser,modo_private);
                configuracion.edit().clear().commit();
                Intent i = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}