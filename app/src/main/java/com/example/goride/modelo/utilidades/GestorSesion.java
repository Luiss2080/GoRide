package com.example.goride.modelo.utilidades;

import android.content.Context;
import android.content.SharedPreferences;

public class GestorSesion {

    private static final String PREFERENCIAS = "GoRideSesion";
    private static final String CLAVE_ID_USUARIO = "idUsuario";
    private static final String CLAVE_NOMBRE_USUARIO = "nombreUsuario";
    private static final String CLAVE_NOMBRE_COMPLETO = "nombreCompleto";
    private static final String CLAVE_ID_ROL = "idRol";
    private static final String CLAVE_SESION_ACTIVA = "sesionActiva";

    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;

    public GestorSesion(Context contexto) {
        preferencias = contexto.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        editor = preferencias.edit();
    }

    public void iniciarSesion(int idUsuario, String nombreUsuario, String nombreCompleto, int idRol) {
        editor.putBoolean(CLAVE_SESION_ACTIVA, true);
        editor.putInt(CLAVE_ID_USUARIO, idUsuario);
        editor.putString(CLAVE_NOMBRE_USUARIO, nombreUsuario);
        editor.putString(CLAVE_NOMBRE_COMPLETO, nombreCompleto);
        editor.putInt(CLAVE_ID_ROL, idRol);
        editor.apply();
    }

    public void cerrarSesion() {
        editor.clear();
        editor.apply();
    }

    public boolean haySesionActiva() {
        return preferencias.getBoolean(CLAVE_SESION_ACTIVA, false);
    }

    public int obtenerIdUsuario() {
        return preferencias.getInt(CLAVE_ID_USUARIO, -1);
    }

    public String obtenerNombreUsuario() {
        return preferencias.getString(CLAVE_NOMBRE_USUARIO, "");
    }

    public String obtenerNombreCompleto() {
        return preferencias.getString(CLAVE_NOMBRE_COMPLETO, "");
    }

    public int obtenerIdRol() {
        return preferencias.getInt(CLAVE_ID_ROL, -1);
    }
}

