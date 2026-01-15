package com.example.goride.modelo.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

/**
 * Entidad que representa un Servicio de transporte en el sistema GoRide
 */
@Entity(tableName = "servicios")
public class Servicio {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_servicio")
    private int idServicio;

    @ColumnInfo(name = "nombre_servicio")
    private String nombreServicio;

    @ColumnInfo(name = "descripcion")
    private String descripcion;

    @ColumnInfo(name = "precio_base")
    private double precioBase;

    @ColumnInfo(name = "precio_por_kilometro")
    private double precioPorKilometro;

    @ColumnInfo(name = "estado")
    private String estado; // Activo, Inactivo

    // Constructor vacío
    public Servicio() {
    }

    // Constructor completo
    public Servicio(String nombreServicio, String descripcion, double precioBase,
                    double precioPorKilometro, String estado) {
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.precioPorKilometro = precioPorKilometro;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioPorKilometro() {
        return precioPorKilometro;
    }

    public void setPrecioPorKilometro(double precioPorKilometro) {
        this.precioPorKilometro = precioPorKilometro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

