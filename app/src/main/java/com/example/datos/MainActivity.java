package com.example.datos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    ControladorDB db;
    SQLiteDatabase controlDB;
    Cursor cursor;
    EditText password;
    EditText name;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            password = findViewById(R.id.password);
            name = findViewById(R.id.editText);
            btnSubmit = findViewById(R.id.btnSubmit);

            db = new ControladorDB(this, "FES Aragón", null, 2);
            controlDB = db.getWritableDatabase();

            // DELETE
            controlDB.execSQL("delete from alumnos");

            // INSERT
            controlDB.execSQL("insert into alumnos values(012345678, 'admin')");

            // UPDATE
            controlDB.execSQL("update alumnos set cuenta=110001210 where cuenta=110001219");

            // SELECT
//            cursor = controlDB.rawQuery("select * from alumnos", null);
//            if ( cursor.moveToFirst() ) {
//                do {
//                    Log.i("Cuenta", ""+cursor.getString(0)+" - "+cursor.getString(1));
//                } while ( cursor.moveToNext() );
//            }
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Integer numeroCuenta = Integer.valueOf(password.getText().toString());
                        String nombre = String.valueOf(name.getText()).toLowerCase();
                        cursor = controlDB.rawQuery(
                                "select * from alumnos where cuenta=" + numeroCuenta + " and nombre='"+nombre+"'", null);
                        if ( cursor.moveToFirst() ) {
                            do {
                                Log.i("Cuenta", ""+cursor.getString(0)+" - "+cursor.getString(1));
                                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                                startActivity(intent);
                            } while ( cursor.moveToNext() );
                        }
                    } catch (Exception e) {
                        Log.e("Error Click", e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            Log.e("Error Base de datos", e.getMessage());
        }
    }
}
