package com.example.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControladorDB extends SQLiteOpenHelper {
    public ControladorDB(
        Context context,
        String nameDB,
        SQLiteDatabase.CursorFactory cursorFactory,
        int version
    ) {
            super(context, nameDB, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE alumnos( cuenta INTEGER, nombre STRING )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table alumnos add fecha DATE");
    }
}
