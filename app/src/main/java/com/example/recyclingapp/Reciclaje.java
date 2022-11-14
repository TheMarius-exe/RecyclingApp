package com.example.recyclingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclingapp.db.DbUsers;

public class Reciclaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclaje);

        ImageView organico = findViewById(R.id.imageNegro);
        ImageView papel = findViewById(R.id.imageAzul);
        ImageView plastico = findViewById(R.id.imageAmarillo);
        ImageView vidrio = findViewById(R.id.imageVerde);

        Button verPuntos = findViewById(R.id.verPuntos);

        TextView puntos = findViewById(R.id.textPuntsEdit);

        DbUsers dbUsers = new DbUsers(Reciclaje.this);


        organico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean select = dbUsers.select(puntos.getText().toString());
                int or = 5;
                int points = Integer.parseInt(puntos.getText().toString());

                int suma = or + points;

                if (select == true){
                    puntos.setText(Integer.toString(suma));
                    Boolean update = dbUsers.update(puntos.getText().toString());
                    Toast.makeText(Reciclaje.this, "+5", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                }


            }
        });
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pa = 8;
                int points = Integer.parseInt(puntos.getText().toString());

                int suma = pa + points;
                puntos.setText(Integer.toString(suma));

            }
        });
        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int plas = 10;
                int points = Integer.parseInt(puntos.getText().toString());

                int suma = plas + points;
                puntos.setText(Integer.toString(suma));

            }
        });
        vidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int vi = 15;
                int points = Integer.parseInt(puntos.getText().toString());

                int suma = vi + points;
                puntos.setText(Integer.toString(suma));

            }
        });


    }









}