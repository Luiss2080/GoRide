package com.example.goride.modelo.utilidades;

import android.util.Patterns;

/**
 * Clase de utilidades para validaciones de datos
 */
public class ValidadorDatos {

    /**
     * Valida que un texto no esté vacío
     */
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida el formato de un correo electrónico
     */
    public static boolean esCorreoValido(String correo) {
        if (!esTextoValido(correo)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }

    /**
     * Valida el formato de un teléfono (10 dígitos)
     */
    public static boolean esTelefonoValido(String telefono) {
        if (!esTextoValido(telefono)) {
            return false;
        }
        return telefono.matches("\\d{10}");
    }

    /**
     * Valida que una contraseña cumpla requisitos mínimos
     */
    public static boolean esContrasenaValida(String contrasena) {
        if (!esTextoValido(contrasena)) {
            return false;
        }
        return contrasena.length() >= 6;
    }

    /**
     * Valida que un nombre de usuario cumpla requisitos
     */
    public static boolean esNombreUsuarioValido(String nombreUsuario) {
        if (!esTextoValido(nombreUsuario)) {
            return false;
        }
        return nombreUsuario.matches("^[a-zA-Z0-9_]{4,}$");
    }

    /**
     * Valida que una placa vehicular tenga formato correcto
     */
    public static boolean esPlacaValida(String placa) {
        if (!esTextoValido(placa)) {
            return false;
        }
        return placa.matches("^[A-Z]{3}[0-9]{3}$") || placa.matches("^[0-9]{3}[A-Z]{3}$");
    }

    /**
     * Valida que un número sea positivo
     */
    public static boolean esNumeroPositivo(double numero) {
        return numero > 0;
    }

    /**
     * Valida que un año sea válido
     */
    public static boolean esAnioValido(int anio) {
        int anioActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return anio >= 1900 && anio <= anioActual + 1;
    }
}

