package com.example.goride.modelo.repositorio;

import android.content.Context;

import com.example.goride.modelo.basedatos.BaseDatosGoRide;
import com.example.goride.modelo.dao.ViajeDao;
import com.example.goride.modelo.entidades.Viaje;

import java.util.List;

/**
 * Repositorio para gestionar operaciones de Viaje
 */
public class RepositorioViaje {

    private ViajeDao viajeDao;

    public RepositorioViaje(Context contexto) {
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
        this.viajeDao = baseDatos.viajeDao();
    }

    /**
     * Crea un nuevo viaje
     */
    public long crear(Viaje viaje) {
        return viajeDao.insertar(viaje);
    }

    /**
     * Actualiza un viaje existente
     */
    public void actualizar(Viaje viaje) {
        viajeDao.actualizar(viaje);
    }

    /**
     * Elimina un viaje
     */
    public void eliminar(Viaje viaje) {
        viajeDao.eliminar(viaje);
    }

    /**
     * Obtiene todos los viajes
     */
    public List<Viaje> obtenerTodos() {
        return viajeDao.obtenerTodos();
    }

    /**
     * Obtiene un viaje por su ID
     */
    public Viaje obtenerPorId(int idViaje) {
        return viajeDao.obtenerPorId(idViaje);
    }

    /**
     * Obtiene viajes por usuario
     */
    public List<Viaje> obtenerPorUsuario(int idUsuario) {
        return viajeDao.obtenerPorUsuario(idUsuario);
    }

    /**
     * Obtiene viajes por conductor
     */
    public List<Viaje> obtenerPorConductor(int idConductor) {
        return viajeDao.obtenerPorConductor(idConductor);
    }

    /**
     * Obtiene viajes por estado
     */
    public List<Viaje> obtenerPorEstado(String estado) {
        return viajeDao.obtenerPorEstado(estado);
    }

    /**
     * Obtiene viajes por fecha
     */
    public List<Viaje> obtenerPorFecha(String fecha) {
        return viajeDao.obtenerPorFecha(fecha);
    }

    /**
     * Obtiene viajes por usuario y estado
     */
    public List<Viaje> obtenerPorUsuarioYEstado(int idUsuario, String estado) {
        return viajeDao.obtenerPorUsuarioYEstado(idUsuario, estado);
    }

    /**
     * Obtiene viajes por conductor y estado
     */
    public List<Viaje> obtenerPorConductorYEstado(int idConductor, String estado) {
        return viajeDao.obtenerPorConductorYEstado(idConductor, estado);
    }

    /**
     * Obtiene todos los viajes ordenados por fecha
     */
    public List<Viaje> obtenerTodosOrdenadosPorFecha() {
        return viajeDao.obtenerTodosOrdenadosPorFecha();
    }
}

