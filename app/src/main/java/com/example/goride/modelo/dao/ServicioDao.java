package com.example.goride.modelo.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.goride.modelo.entidades.Servicio;

import java.util.List;

@Dao
public interface ServicioDao {

    @Insert
    long insertar(Servicio servicio);

    @Update
    void actualizar(Servicio servicio);

    @Delete
    void eliminar(Servicio servicio);

    @Query("SELECT * FROM servicios")
    List<Servicio> obtenerTodos();

    @Query("SELECT * FROM servicios WHERE id_servicio = :idServicio")
    Servicio obtenerPorId(int idServicio);

    @Query("SELECT * FROM servicios WHERE nombre_servicio = :nombreServicio")
    Servicio obtenerPorNombre(String nombreServicio);

    @Query("SELECT * FROM servicios WHERE estado = :estado")
    List<Servicio> obtenerPorEstado(String estado);

    @Query("SELECT COUNT(*) FROM servicios WHERE nombre_servicio = :nombreServicio")
    int verificarExistenciaNombre(String nombreServicio);
}

