package com.example.goride.modelo.entidades;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import androidx.room.Index;
@Entity(
    tableName = "roles",
    indices = {
        @Index(value = "nombre_rol", unique = true)
    }
)
public class Rol {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_rol")
    private int idRol;
    @ColumnInfo(name = "nombre_rol")
    private String nombreRol;
    @ColumnInfo(name = "descripcion")
    private String descripcion;
    @ColumnInfo(name = "estado")
    private String estado;
    public Rol() {}
    public Rol(String nombreRol, String descripcion, String estado) {
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) { this.idRol = idRol; }
    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
