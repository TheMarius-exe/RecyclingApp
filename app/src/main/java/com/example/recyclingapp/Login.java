package com.example.recyclingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclingapp.db.DbUsers;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView email = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        TextView registerTxt = findViewById(R.id.registerTxt);

        Button loginBtn =  findViewById(R.id.loginBtn);


       loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUsers dbUsers = new DbUsers(Login.this);

                if (email.equals(" ") || password.equals(" ")){
                    Toast.makeText(Login.this, "RELLENE TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean login = dbUsers.login(email.getText().toString(),password.getText().toString());
                    if (login == true){
                        Toast.makeText(Login.this, "LOGGEADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this , Reciclaje.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(Login.this, "ERROR AL LOGEAR", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });



        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            //public void onClick(View view) {setContentView(R.layout.activity_register);}
            public void onClick(View view){
                Intent intent = new Intent(Login.this , Register.class);
                startActivity(intent);
            }
        });

    }
}