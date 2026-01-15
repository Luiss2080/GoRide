package com.example.goride.modelo.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.goride.modelo.entidades.Viaje;

import java.util.List;

/**
 * DAO para operaciones de base de datos de Viaje
 */
@Dao
public interface ViajeDao {

    @Insert
    long insertar(Viaje viaje);

    @Update
    void actualizar(Viaje viaje);

    @Delete
    void eliminar(Viaje viaje);

    @Query("SELECT * FROM viajes")
    List<Viaje> obtenerTodos();

    @Query("SELECT * FROM viajes WHERE id_viaje = :idViaje")
    Viaje obtenerPorId(int idViaje);

    @Query("SELECT * FROM viajes WHERE id_usuario = :idUsuario")
    List<Viaje> obtenerPorUsuario(int idUsuario);

    @Query("SELECT * FROM viajes WHERE id_conductor = :idConductor")
    List<Viaje> obtenerPorConductor(int idConductor);

    @Query("SELECT * FROM viajes WHERE estado = :estado")
    List<Viaje> obtenerPorEstado(String estado);

    @Query("SELECT * FROM viajes WHERE fecha_viaje = :fecha")
    List<Viaje> obtenerPorFecha(String fecha);

    @Query("SELECT * FROM viajes WHERE id_usuario = :idUsuario AND estado = :estado")
    List<Viaje> obtenerPorUsuarioYEstado(int idUsuario, String estado);

    @Query("SELECT * FROM viajes WHERE id_conductor = :idConductor AND estado = :estado")
    List<Viaje> obtenerPorConductorYEstado(int idConductor, String estado);

    @Query("SELECT * FROM viajes ORDER BY fecha_viaje DESC, hora_viaje DESC")
    List<Viaje> obtenerTodosOrdenadosPorFecha();
}

