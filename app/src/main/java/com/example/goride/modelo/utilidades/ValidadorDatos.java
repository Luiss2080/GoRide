package com.example.goride.modelo.utilidades;

/**
 * Utilidad para validar datos de entrada
 */
public class ValidadorDatos {

    /**
     * Valida que un texto no esté vacío
     */
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida que un nombre de usuario sea válido
     */
    public static boolean esNombreUsuarioValido(String nombreUsuario) {
        return esTextoValido(nombreUsuario) && nombreUsuario.length() >= 3;
    }

    /**
     * Valida que una contraseña sea válida
     */
    public static boolean esContrasenaValida(String contrasena) {
        return esTextoValido(contrasena) && contrasena.length() >= 4;
    }

    /**
     * Valida que un correo sea válido
     */
    public static boolean esCorreoValido(String correo) {
        if (!esTextoValido(correo)) return false;
        return correo.contains("@") && correo.contains(".");
    }

    /**
     * Valida que un teléfono sea válido
     */
    public static boolean esTelefonoValido(String telefono) {
        if (!esTextoValido(telefono)) return false;
        return telefono.length() >= 8 && telefono.matches("\\d+");
    }
}

