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


        TextView puntos = findViewById(R.id.textPuntsEdit);

        DbUsers dbUsers = new DbUsers(Reciclaje.this);


        organico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroPuntoUsuario= dbUsers.numPuntosUser("admin");
                int or = 5;

                int suma = or + numeroPuntoUsuario;

                if (numeroPuntoUsuario > 0 ){
                    puntos.setText(Integer.toString(suma));
                    Boolean update = dbUsers.update(suma);
                    if (update == true){

                        Toast.makeText(Reciclaje.this, "Se han sumado a tu cuenta: 5", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                }


            }
        });
        /*
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select= dbUsers.numPuntosUser(Integer.parseInt(puntos.getText().toString()));
                int pa = 8;
                int points = Integer.parseInt(puntos.getText().toString());

                int suma = pa + points;

                if (select > 1){
                    puntos.setText(puntos.getText().toString());
                    puntos.setText(Integer.toString(suma));
                    Boolean update = dbUsers.update(suma);
                    if (update == true){
                        Toast.makeText(Reciclaje.this, "Se han sumado a tu cuenta: 8", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                }


            }
        });
        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select= dbUsers.numPuntosUser(Integer.parseInt(puntos.getText().toString()));
                int plas = 10;
                int points = Integer.parseInt(puntos.getText().toString());

                int suma = plas + points;
                if (select > 1){
                    puntos.setText(puntos.getText().toString());
                    puntos.setText(Integer.toString(suma));
                    Boolean update = dbUsers.update(suma);
                    if (update == true) {
                        Toast.makeText(Reciclaje.this, "Se han sumado a tu cuenta: 10", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
        vidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select= dbUsers.numPuntosUser(Integer.parseInt(puntos.getText().toString()));
                int vi = 15;
                int points = Integer.parseInt(puntos.getText().toString());

                int suma = vi + points;
                    if (select > 1){
                        puntos.setText(puntos.getText().toString());
                        puntos.setText(Integer.toString(suma));
                        Boolean update = dbUsers.update(suma);
                        if (update == true){
                            Toast.makeText(Reciclaje.this, "Se han sumado a tu cuenta: 15", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Reciclaje.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }

            }
        });
*/

    }









}