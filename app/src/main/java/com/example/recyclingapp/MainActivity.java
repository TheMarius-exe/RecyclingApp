package com.example.recyclingapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView database= findViewById(R.id.imageView);
        Button loginmainBtn = findViewById(R.id.loginMainBtn);
        Button registerBtn = findViewById(R.id.registerBtn);

        loginmainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            //public void onClick(View view) {setContentView(R.layout.activity_register);}
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this , Register.class);
                startActivity(intent);
            }
        });

        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , database.class);
                startActivity(intent);
            }
        });





    }

}