package com.example.goride.modelo.utilidades;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class UtilidadesFecha {
    private static final String PATRON_FECHA = "dd/MM/yyyy";
    private static final String PATRON_HORA = "HH:mm";
    private static final String PATRON_FECHA_HORA = "dd/MM/yyyy HH:mm";
    private static final Locale LOCALIZACION = new Locale("es", "ES");
    private UtilidadesFecha() {
        // Constructor privado para evitar instanciación
    }
    public static String obtenerFechaActual() {
        return new SimpleDateFormat(PATRON_FECHA, LOCALIZACION).format(new Date());
    }
    public static String obtenerHoraActual() {
        return new SimpleDateFormat(PATRON_HORA, LOCALIZACION).format(new Date());
    }
    public static String obtenerFechaHoraActual() {
        return new SimpleDateFormat(PATRON_FECHA_HORA, LOCALIZACION).format(new Date());
    }
    public static String formatearFecha(Date fecha) {
        return new SimpleDateFormat(PATRON_FECHA, LOCALIZACION).format(fecha);
    }
    public static String formatearHora(Date hora) {
        return new SimpleDateFormat(PATRON_HORA, LOCALIZACION).format(hora);
    }
}