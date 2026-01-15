package com.example.goride.modelo.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.goride.modelo.entidades.Rol;

import java.util.List;

@Dao
public interface RolDao {

    @Insert
    long insertar(Rol rol);

    @Update
    void actualizar(Rol rol);

    @Delete
    void eliminar(Rol rol);

    @Query("SELECT * FROM roles")
    List<Rol> obtenerTodos();

    @Query("SELECT * FROM roles WHERE id_rol = :idRol")
    Rol obtenerPorId(int idRol);

    @Query("SELECT * FROM roles WHERE nombre_rol = :nombreRol")
    Rol obtenerPorNombre(String nombreRol);

    @Query("SELECT * FROM roles WHERE estado = :estado")
    List<Rol> obtenerPorEstado(String estado);

    @Query("SELECT COUNT(*) FROM roles WHERE nombre_rol = :nombreRol")
    int verificarExistenciaNombre(String nombreRol);
}

