package com.example.adaptadores;

import static com.example.adaptadores.R.id.rcv_usuarios;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adaptadores.adaptadores.UsuarioAdaptador;
import com.example.adaptadores.clase.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    RecyclerView rcv_usuarios;
    Button btn_more;
    List<Usuario> lista = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        btn_more = findViewById(R.id.btn_more);
        rcv_usuarios = findViewById(R.id.rcv_usuarios);

        Usuario usu1 = new Usuario("https://rickandmortyapi.com/api/character/avatar/221.jpeg","carlos","Male");
        Usuario usu2 = new Usuario("https://rickandmortyapi.com/api/character/avatar/180.jpeg","Angelica","Female");
        Usuario usu3 = new Usuario("https://rickandmortyapi.com/api/character/avatar/140.jpeg","Juan","Male");
        Usuario usu4 = new Usuario("https://rickandmortyapi.com/api/character/avatar/261.jpeg","Yale","Female");
        Usuario usu5 = new Usuario("https://rickandmortyapi.com/api/character/avatar/130.jpeg","Geovannis","Male");
        Usuario usu6 = new Usuario("https://rickandmortyapi.com/api/character/avatar/110.jpeg","Jhojan","Male");
        Usuario usu7 = new Usuario("https://rickandmortyapi.com/api/character/avatar/291.jpeg","Alex","Male");
        Usuario usu8 = new Usuario("https://rickandmortyapi.com/api/character/avatar/240.jpeg","William","Male");
        Usuario usu9 = new Usuario("https://rickandmortyapi.com/api/character/avatar/250.jpeg","Jesus","Male");

        lista.add(usu1);
        lista.add(usu2);
        lista.add(usu3);
        lista.add(usu4);
        lista.add(usu5);
        lista.add(usu6);
        lista.add(usu7);
        lista.add(usu8);
        lista.add(usu9);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        rcv_usuarios.setAdapter(new UsuarioAdaptador(lista));


    }
}