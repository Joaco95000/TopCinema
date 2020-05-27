package com.example.topcinema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AyudanteBaseDeDatos extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DE_DATOS = "topcinema",
            NOMBRE_TABLA_USUARIOS = "usuarios";
    private static final int VERSION_BASE_DE_DATOS =1;

    public AyudanteBaseDeDatos(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("create table if not exists %s(id integer primary key autoincrement,correo text, nombre text,apellido1 text,apellido2 text, edad integer,usuario text,password text);",NOMBRE_TABLA_USUARIOS));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}