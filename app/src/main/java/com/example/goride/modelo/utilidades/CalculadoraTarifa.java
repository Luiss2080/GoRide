package com.example.goride.modelo.utilidades;

import com.example.goride.modelo.entidades.Servicio;

public class CalculadoraTarifa {

    public static double calcularTarifa(Servicio servicio, double distanciaKm) {
        if (servicio == null || distanciaKm < 0) {
            return 0.0;
        }
        double precioBase = servicio.getPrecioBase();
        double precioPorKm = servicio.getPrecioPorKilometro();
        return precioBase + (distanciaKm * precioPorKm);
    }

    public static double calcularTarifaRedondeada(Servicio servicio, double distanciaKm) {
        double tarifa = calcularTarifa(servicio, distanciaKm);
        return Math.round(tarifa * 100.0) / 100.0;
    }

    public static String formatearTarifa(double tarifa) {
        return String.format("$%.2f", tarifa);
    }
}

