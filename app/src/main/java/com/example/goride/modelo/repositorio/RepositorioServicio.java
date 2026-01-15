package com.example.goride.modelo.repositorio;

import android.content.Context;

import com.example.goride.modelo.basedatos.BaseDatosGoRide;
import com.example.goride.modelo.dao.ServicioDao;
import com.example.goride.modelo.entidades.Servicio;

import java.util.List;

/**
 * Repositorio para gestionar operaciones de Servicio
 */
public class RepositorioServicio {

    private ServicioDao servicioDao;

    public RepositorioServicio(Context contexto) {
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
        this.servicioDao = baseDatos.servicioDao();
    }

    /**
     * Crea un nuevo servicio
     */
    public long crear(Servicio servicio) {
        return servicioDao.insertar(servicio);
    }

    /**
     * Actualiza un servicio existente
     */
    public void actualizar(Servicio servicio) {
        servicioDao.actualizar(servicio);
    }

    /**
     * Elimina un servicio
     */
    public void eliminar(Servicio servicio) {
        servicioDao.eliminar(servicio);
    }

    /**
     * Obtiene todos los servicios
     */
    public List<Servicio> obtenerTodos() {
        return servicioDao.obtenerTodos();
    }

    /**
     * Obtiene un servicio por su ID
     */
    public Servicio obtenerPorId(int idServicio) {
        return servicioDao.obtenerPorId(idServicio);
    }

    /**
     * Obtiene un servicio por nombre
     */
    public Servicio obtenerPorNombre(String nombreServicio) {
        return servicioDao.obtenerPorNombre(nombreServicio);
    }

    /**
     * Obtiene servicios por estado
     */
    public List<Servicio> obtenerPorEstado(String estado) {
        return servicioDao.obtenerPorEstado(estado);
    }

    /**
     * Verifica si existe un nombre de servicio
     */
    public boolean existeNombre(String nombreServicio) {
        return servicioDao.verificarExistenciaNombre(nombreServicio) > 0;
    }
}

