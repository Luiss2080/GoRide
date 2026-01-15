package com.example.goride.modelo.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "conductores")
public class Conductor {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_conductor")
    private int idConductor;

    @ColumnInfo(name = "id_usuario")
    private int idUsuario;

    @ColumnInfo(name = "licencia_conducir")
    private String licenciaConducir;

    @ColumnInfo(name = "placa_vehiculo")
    private String placaVehiculo;

    @ColumnInfo(name = "modelo_vehiculo")
    private String modeloVehiculo;

    @ColumnInfo(name = "color_vehiculo")
    private String colorVehiculo;

    @ColumnInfo(name = "anio_vehiculo")
    private int anioVehiculo;

    @ColumnInfo(name = "estado")
    private String estado;

    public Conductor() {
    }

    public Conductor(int idUsuario, String licenciaConducir, String placaVehiculo,
                     String modeloVehiculo, String colorVehiculo, int anioVehiculo, String estado) {
        this.idUsuario = idUsuario;
        this.licenciaConducir = licenciaConducir;
        this.placaVehiculo = placaVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.colorVehiculo = colorVehiculo;
        this.anioVehiculo = anioVehiculo;
        this.estado = estado;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }

    public int getAnioVehiculo() {
        return anioVehiculo;
    }

    public void setAnioVehiculo(int anioVehiculo) {
        this.anioVehiculo = anioVehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

