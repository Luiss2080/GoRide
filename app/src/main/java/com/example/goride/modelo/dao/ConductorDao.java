package com.example.goride.modelo.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.goride.modelo.entidades.Conductor;

import java.util.List;

@Dao
public interface ConductorDao {

    @Insert
    long insertar(Conductor conductor);

    @Update
    void actualizar(Conductor conductor);

    @Delete
    void eliminar(Conductor conductor);

    @Query("SELECT * FROM conductores")
    List<Conductor> obtenerTodos();

    @Query("SELECT * FROM conductores WHERE id_conductor = :idConductor")
    Conductor obtenerPorId(int idConductor);

    @Query("SELECT * FROM conductores WHERE id_usuario = :idUsuario")
    Conductor obtenerPorUsuario(int idUsuario);

    @Query("SELECT * FROM conductores WHERE licencia_conducir = :licencia")
    Conductor obtenerPorLicencia(String licencia);

    @Query("SELECT * FROM conductores WHERE placa_vehiculo = :placa")
    Conductor obtenerPorPlaca(String placa);

    @Query("SELECT * FROM conductores WHERE estado = :estado")
    List<Conductor> obtenerPorEstado(String estado);

    @Query("SELECT COUNT(*) FROM conductores WHERE licencia_conducir = :licencia")
    int verificarExistenciaLicencia(String licencia);

    @Query("SELECT COUNT(*) FROM conductores WHERE placa_vehiculo = :placa")
    int verificarExistenciaPlaca(String placa);
}

