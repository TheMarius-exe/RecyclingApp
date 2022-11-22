package com.example.recyclingapp;

import static com.example.recyclingapp.Login.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclingapp.db.DbUsers;

public class Reciclaje extends AppCompatActivity {

    public static TextView puntos;
    private Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reciclaje);
        String email = getIntent().getStringExtra("email");
        user = new DbUsers(this).numPuntosUser(email);

        ImageView organico = findViewById(R.id.imageNegro);
        ImageView papel = findViewById(R.id.imageAzul);
        ImageView plastico = findViewById(R.id.imageAmarillo);
        ImageView vidrio = findViewById(R.id.imageVerde);


        puntos = findViewById(R.id.textPuntsEdit);

        DbUsers dbUsers = new DbUsers(Reciclaje.this);
        puntos.setText(String.valueOf(user.getPuntos()));


        organico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int or = 5;
                int suma = or + user.getPuntos();
                new DbUsers(view.getContext()).update(suma, user.getEmail());
                user = new DbUsers(view.getContext()).numPuntosUser(user.getEmail());
                puntos.setText(String.valueOf(user.getPuntos()));
           }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int or = 8;
                int suma = or + user.getPuntos();
                new DbUsers(view.getContext()).update(suma, user.getEmail());
                user = new DbUsers(view.getContext()).numPuntosUser(user.getEmail());
                puntos.setText(String.valueOf(user.getPuntos()));


            }
        });
        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int or = 10;
                int suma = or + user.getPuntos();
                new DbUsers(view.getContext()).update(suma, user.getEmail());
                user = new DbUsers(view.getContext()).numPuntosUser(user.getEmail());
                puntos.setText(String.valueOf(user.getPuntos()));
            }
        });
        vidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int or = 15;
                int suma = or + user.getPuntos();
                new DbUsers(view.getContext()).update(suma, user.getEmail());
                user = new DbUsers(view.getContext()).numPuntosUser(user.getEmail());
                puntos.setText(String.valueOf(user.getPuntos()));

            }
        });

        

    }









}