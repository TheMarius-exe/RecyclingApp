package com.example.recyclingapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.recyclingapp.db.DbHelper;

public class database extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Button btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Funciona");
                DbHelper dbHelper = new DbHelper(database.this);
                System.out.println("Funciona");
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                System.out.println("Funciona");

                if(db != null){
                    Toast.makeText(database.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(database.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
