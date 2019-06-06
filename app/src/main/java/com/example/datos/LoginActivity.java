package com.example.datos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class LoginActivity extends AppCompatActivity {
  Button regresarBtn;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    regresarBtn = findViewById(R.id.btnRegresar);

    regresarBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent form = new Intent(getBaseContext(), MainActivity.class);
        startActivity(form);
      }
    });
  }
}
