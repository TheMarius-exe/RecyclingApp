package com.example.recyclingapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.recyclingapp.Reciclaje;

public class DbUsers extends DbHelper{
    static Context context;


    public DbUsers(@Nullable Context context){
        super(context);
        this.context = context;

    }

    public long insertUser(String email, String name, String phoneNumber, String username, String password) {

        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("email", email);
            values.put("name", name);
            values.put("phoneNumber", phoneNumber);
            values.put("username", username);
            values.put("password", password);
            values.put("puntos", 0);

            id = db.insert(TABLE_USERS, null, values);
        } catch (Exception e) {
            e.toString();
            System.out.println(e);
        }

        return id;
    }

    public long getUser(String email, String name, String phoneNumber, String username, String password){
        long idreg = 0;;

        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.get(email);
            values.get(name);
            values.get(phoneNumber);
            values.get(username);
            values.get(password);

            idreg = db.insert(TABLE_USERS, null, values);

        }catch (Exception e){
            e.toString();
            System.out.println(e);
        }

        return idreg;
    }


    public Boolean login(String email, String password){
        SQLiteDatabase db = DbUsers.this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select email,password from t_users where email= '"+ email +"' and password = '" + password + "'", null);

        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }

    public int numPuntosUser(String email){
        int a= 0;
        SQLiteDatabase db = DbUsers.this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from t_users where email = '" + email + "'" ,null);

        if (cursor.moveToFirst()){
            a = cursor.getInt(4);
            return a;
        }else {
            return a;
        }
    }

    public Boolean update(int puntos){
        try{
            DbHelper myDBHelp = new DbHelper(context);
            SQLiteDatabase DB = myDBHelp.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("puntos", puntos);
            Toast.makeText(context, "Tienes actualmente" + puntos, Toast.LENGTH_SHORT).show();
            DB.update(TABLE_USERS, values,null, null);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
