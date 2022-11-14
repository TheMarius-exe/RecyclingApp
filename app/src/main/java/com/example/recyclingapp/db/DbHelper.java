package com.example.recyclingapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private  static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NOMBRE = "reciclaje.db";
    public static final String TABLE_USERS = "t_users";

    public DbHelper (@Nullable Context context){
        super(context,DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USERS + "(" +
                "email TEXT PRIMARY KEY NOT NULL," +
                "name TEXT NOT NULL," +
                "phoneNumber TEXT NOT NULL," +
                "username TEXT NOT NULL," +
                "password TEXT NOT NULL," +
                "puntos TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_USERS);
        onCreate(sqLiteDatabase);

    }

}
