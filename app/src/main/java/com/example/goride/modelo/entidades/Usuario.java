package com.example.goride.modelo.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import androidx.room.ForeignKey;
import androidx.room.Index;

/**
 * Entidad que representa a un Usuario en el sistema GoRide
 */
@Entity(
    tableName = "usuarios",
    foreignKeys = @ForeignKey(
        entity = Rol.class,
        parentColumns = "id_rol",
        childColumns = "id_rol",
        onDelete = ForeignKey.RESTRICT
    ),
    indices = {
        @Index(value = "nombre_usuario", unique = true),
        @Index(value = "correo_electronico", unique = true),
        @Index(value = "id_rol")
    }
)
public class Usuario {
    
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_usuario")
    private int idUsuario;
    
    @ColumnInfo(name = "nombre_usuario")
    private String nombreUsuario;
    
    @ColumnInfo(name = "contrasena")
    private String contrasena;
    
    @ColumnInfo(name = "nombre_completo")
    private String nombreCompleto;
    
    @ColumnInfo(name = "correo_electronico")
    private String correoElectronico;
    
    @ColumnInfo(name = "telefono")
    private String telefono;
    
    @ColumnInfo(name = "id_rol")
    private int idRol;
    
    @ColumnInfo(name = "estado")
    private String estado;
    
    @ColumnInfo(name = "fecha_creacion")
    private String fechaCreacion;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasena, String nombreCompleto, 
                   String correoElectronico, String telefono, int idRol, String estado, String fechaCreacion) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.idRol = idRol;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

