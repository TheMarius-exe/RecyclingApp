package com.example.recyclingapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclingapp.db.DbUsers;

public class Register extends AppCompatActivity {

    private EditText email;
    private EditText name;
    private EditText phoneNumber;
    private EditText username;
    private EditText password;
    private EditText passwordCnf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        passwordCnf = findViewById(R.id.password2);

        TextView loginTxt = findViewById(R.id.loginTxt);

        Button registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);

                if (email.getText().toString().isEmpty()|| name.getText().toString().isEmpty() || phoneNumber.getText().toString().isEmpty()  || username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || passwordCnf.getText().toString().isEmpty()){
                    //complete();
                    Toast.makeText(Register.this, "RELLENA TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();

                }else {
                        if (password.getText().toString().equals(passwordCnf.getText().toString())) {
                            DbUsers dbUsers = new DbUsers(Register.this);
                            long id = dbUsers.insertUser(
                                    email.getText().toString(),
                                    name.getText().toString(),
                                    phoneNumber.getText().toString(),
                                    username.getText().toString(),
                                    password.getText().toString());

                            long idGet = dbUsers.getUser(
                                    email.getText().toString(),
                                    name.getText().toString(),
                                    phoneNumber.getText().toString(),
                                    username.getText().toString(),
                                    password.getText().toString());

                            if (id > 0) {
                                Toast.makeText(Register.this, "RESGISTRO CONFIRMADO", Toast.LENGTH_SHORT).show();
                                clear();

                                startActivity(intent);
                            } else if (idGet < 0) {
                                Toast.makeText(Register.this, "USUARIO CREADO", Toast.LENGTH_SHORT).show();
                                clear();
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this, "ERROR AL CREAR EL USUARIO", Toast.LENGTH_SHORT).show();
                                clear();
                            }
                        } else {
                            Toast.makeText(Register.this, "LAS CONTRASEÑAS NO COINCIDEN  RELLENA", Toast.LENGTH_SHORT).show();
                        }
                }

            }
        });

        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(Register.this, Login.class);
                startActivity(log);
            }
        });


    }

    public void clear(){
        email.setText("");
        name.setText("");
        phoneNumber.setText("");
        username.setText("");
        password.setText("");
        passwordCnf.setText("");

    }

}
