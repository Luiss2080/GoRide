package com.example.goride.modelo.utilidades;
}
    }
        return FORMATO_HORA.format(hora);
    public static String formatearHora(Date hora) {

    }
        return FORMATO_FECHA.format(fecha);
    public static String formatearFecha(Date fecha) {

    }
        return FORMATO_FECHA_HORA.format(new Date());
    public static String obtenerFechaHoraActual() {

    }
        return FORMATO_HORA.format(new Date());
    public static String obtenerHoraActual() {

    }
        return FORMATO_FECHA.format(new Date());
    public static String obtenerFechaActual() {

    private static final SimpleDateFormat FORMATO_FECHA_HORA = new SimpleDateFormat("dd/MM/yyyy HH:mm", new Locale("es", "ES"));
    private static final SimpleDateFormat FORMATO_HORA = new SimpleDateFormat("HH:mm", new Locale("es", "ES"));
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "ES"));

public class UtilidadesFecha {

import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;


