package com.example.goride.modelo.entidades;
}
    }
        this.fechaCreacion = fechaCreacion;
    public void setFechaCreacion(String fechaCreacion) {

    }
        return fechaCreacion;
    public String getFechaCreacion() {

    }
        this.estado = estado;
    public void setEstado(String estado) {

    }
        return estado;
    public String getEstado() {

    }
        this.idRol = idRol;
    public void setIdRol(int idRol) {

    }
        return idRol;
    public int getIdRol() {

    }
        this.telefono = telefono;
    public void setTelefono(String telefono) {

    }
        return telefono;
    public String getTelefono() {

    }
        this.correoElectronico = correoElectronico;
    public void setCorreoElectronico(String correoElectronico) {

    }
        return correoElectronico;
    public String getCorreoElectronico() {

    }
        this.nombreCompleto = nombreCompleto;
    public void setNombreCompleto(String nombreCompleto) {

    }
        return nombreCompleto;
    public String getNombreCompleto() {

    }
        this.contrasena = contrasena;
    public void setContrasena(String contrasena) {

    }
        return contrasena;
    public String getContrasena() {

    }
        this.nombreUsuario = nombreUsuario;
    public void setNombreUsuario(String nombreUsuario) {

    }
        return nombreUsuario;
    public String getNombreUsuario() {

    }
        this.idUsuario = idUsuario;
    public void setIdUsuario(int idUsuario) {

    }
        return idUsuario;
    public int getIdUsuario() {
    // Getters y Setters

    }
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.idRol = idRol;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.nombreCompleto = nombreCompleto;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
                   String correoElectronico, String telefono, int idRol, String estado, String fechaCreacion) {
    public Usuario(String nombreUsuario, String contrasena, String nombreCompleto,
    // Constructor completo

    }
    public Usuario() {
    // Constructor vacío

    private String fechaCreacion;
    @ColumnInfo(name = "fecha_creacion")

    private String estado; // Activo, Inactivo
    @ColumnInfo(name = "estado")

    private int idRol;
    @ColumnInfo(name = "id_rol")

    private String telefono;
    @ColumnInfo(name = "telefono")

    private String correoElectronico;
    @ColumnInfo(name = "correo_electronico")

    private String nombreCompleto;
    @ColumnInfo(name = "nombre_completo")

    private String contrasena;
    @ColumnInfo(name = "contrasena")

    private String nombreUsuario;
    @ColumnInfo(name = "nombre_usuario")

    private int idUsuario;
    @ColumnInfo(name = "id_usuario")
    @PrimaryKey(autoGenerate = true)

public class Usuario {
@Entity(tableName = "usuarios")
 */
 * Entidad que representa a un Usuario en el sistema GoRide
/**

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;


