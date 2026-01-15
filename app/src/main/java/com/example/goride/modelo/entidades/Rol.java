package com.example.goride.modelo.entidades;
}
    }
        this.estado = estado;
    public void setEstado(String estado) {

    }
        return estado;
    public String getEstado() {

    }
        this.descripcion = descripcion;
    public void setDescripcion(String descripcion) {

    }
        return descripcion;
    public String getDescripcion() {

    }
        this.nombreRol = nombreRol;
    public void setNombreRol(String nombreRol) {

    }
        return nombreRol;
    public String getNombreRol() {

    }
        this.idRol = idRol;
    public void setIdRol(int idRol) {

    }
        return idRol;
    public int getIdRol() {

    }
        this.estado = estado;
        this.descripcion = descripcion;
        this.nombreRol = nombreRol;
    public Rol(String nombreRol, String descripcion, String estado) {

    }
    public Rol() {

    private String estado;
    @ColumnInfo(name = "estado")

    private String descripcion;
    @ColumnInfo(name = "descripcion")

    private String nombreRol;
    @ColumnInfo(name = "nombre_rol")

    private int idRol;
    @ColumnInfo(name = "id_rol")
    @PrimaryKey(autoGenerate = true)

public class Rol {
@Entity(tableName = "roles")

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;


