package com.example.goride.modelo.dao;
}
    int verificarExistenciaCorreo(String correo);
    @Query("SELECT COUNT(*) FROM usuarios WHERE correo_electronico = :correo")

    int verificarExistenciaUsuario(String nombreUsuario);
    @Query("SELECT COUNT(*) FROM usuarios WHERE nombre_usuario = :nombreUsuario")

    List<Usuario> obtenerPorEstado(String estado);
    @Query("SELECT * FROM usuarios WHERE estado = :estado")

    List<Usuario> obtenerPorRol(int idRol);
    @Query("SELECT * FROM usuarios WHERE id_rol = :idRol")

    Usuario autenticar(String nombreUsuario, String contrasena);
    @Query("SELECT * FROM usuarios WHERE nombre_usuario = :nombreUsuario AND contrasena = :contrasena")

    Usuario obtenerPorNombreUsuario(String nombreUsuario);
    @Query("SELECT * FROM usuarios WHERE nombre_usuario = :nombreUsuario")

    Usuario obtenerPorId(int idUsuario);
    @Query("SELECT * FROM usuarios WHERE id_usuario = :idUsuario")

    List<Usuario> obtenerTodos();
    @Query("SELECT * FROM usuarios")

    void eliminar(Usuario usuario);
    @Delete

    void actualizar(Usuario usuario);
    @Update

    long insertar(Usuario usuario);
    @Insert

public interface UsuarioDao {
@Dao
 */
 * DAO para operaciones de base de datos de Usuario
/**

import java.util.List;

import com.example.goride.modelo.entidades.Usuario;

import androidx.room.Update;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.Delete;
import androidx.room.Dao;


