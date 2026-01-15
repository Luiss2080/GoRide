package com.example.goride;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goride.controlador.ActividadLogin;

/**
 * Activity principal - Redirecciona al Login
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Redirigir directamente al Login
        Intent intent = new Intent(this, ActividadLogin.class);
        startActivity(intent);
        finish();
    }
}