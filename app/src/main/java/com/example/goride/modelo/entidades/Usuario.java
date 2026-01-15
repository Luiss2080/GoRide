package com.example.goride.modelo.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

/**
 * Entidad que representa a un Usuario en el sistema GoRide
 */
@Entity(tableName = "usuarios")
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

    // Constructor vacío
    public Usuario() {
    }

    // Constructor completo
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

    // Getters y Setters
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


