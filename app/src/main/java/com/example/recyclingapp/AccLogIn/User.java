package com.example.recyclingapp.AccLogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.recyclingapp.R;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        TextView User = findViewById(R.id.textSeeUser);
        TextView Email = findViewById(R.id.textSeeEmail);
        TextView Phone = findViewById(R.id.textSeePhone);



    }
}