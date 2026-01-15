package com.example.goride.modelo.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "viajes")
public class Viaje {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_viaje")
    private int idViaje;

    @ColumnInfo(name = "id_usuario")
    private int idUsuario;

    @ColumnInfo(name = "id_conductor")
    private int idConductor;

    @ColumnInfo(name = "id_servicio")
    private int idServicio;

    @ColumnInfo(name = "origen")
    private String origen;

    @ColumnInfo(name = "destino")
    private String destino;

    @ColumnInfo(name = "fecha_viaje")
    private String fechaViaje;

    @ColumnInfo(name = "hora_viaje")
    private String horaViaje;

    @ColumnInfo(name = "estado")
    private String estado;

    @ColumnInfo(name = "tarifa")
    private double tarifa;

    @ColumnInfo(name = "distancia_km")
    private double distanciaKm;

    public Viaje() {
    }

    public Viaje(int idUsuario, int idConductor, int idServicio, String origen,
                 String destino, String fechaViaje, String horaViaje, String estado,
                 double tarifa, double distanciaKm) {
        this.idUsuario = idUsuario;
        this.idConductor = idConductor;
        this.idServicio = idServicio;
        this.origen = origen;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.estado = estado;
        this.tarifa = tarifa;
        this.distanciaKm = distanciaKm;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public String getHoraViaje() {
        return horaViaje;
    }

    public void setHoraViaje(String horaViaje) {
        this.horaViaje = horaViaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }
}

