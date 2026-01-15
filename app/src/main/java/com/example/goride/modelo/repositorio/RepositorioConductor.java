package com.example.goride.modelo.repositorio;

import android.content.Context;

import com.example.goride.modelo.basedatos.BaseDatosGoRide;
import com.example.goride.modelo.dao.ConductorDao;
import com.example.goride.modelo.entidades.Conductor;

import java.util.List;

/**
 * Repositorio para gestionar operaciones de Conductor
 */
public class RepositorioConductor {

    private ConductorDao conductorDao;

    public RepositorioConductor(Context contexto) {
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
        this.conductorDao = baseDatos.conductorDao();
    }

    /**
     * Crea un nuevo conductor
     */
    public long crear(Conductor conductor) {
        return conductorDao.insertar(conductor);
    }

    /**
     * Actualiza un conductor existente
     */
    public void actualizar(Conductor conductor) {
        conductorDao.actualizar(conductor);
    }

    /**
     * Elimina un conductor
     */
    public void eliminar(Conductor conductor) {
        conductorDao.eliminar(conductor);
    }

    /**
     * Obtiene todos los conductores
     */
    public List<Conductor> obtenerTodos() {
        return conductorDao.obtenerTodos();
    }

    /**
     * Obtiene un conductor por su ID
     */
    public Conductor obtenerPorId(int idConductor) {
        return conductorDao.obtenerPorId(idConductor);
    }

    /**
     * Obtiene un conductor por ID de usuario
     */
    public Conductor obtenerPorUsuario(int idUsuario) {
        return conductorDao.obtenerPorUsuario(idUsuario);
    }

    /**
     * Obtiene un conductor por licencia
     */
    public Conductor obtenerPorLicencia(String licencia) {
        return conductorDao.obtenerPorLicencia(licencia);
    }

    /**
     * Obtiene un conductor por placa
     */
    public Conductor obtenerPorPlaca(String placa) {
        return conductorDao.obtenerPorPlaca(placa);
    }

    /**
     * Obtiene conductores por estado
     */
    public List<Conductor> obtenerPorEstado(String estado) {
        return conductorDao.obtenerPorEstado(estado);
    }

    /**
     * Verifica si existe una licencia
     */
    public boolean existeLicencia(String licencia) {
        return conductorDao.verificarExistenciaLicencia(licencia) > 0;
    }

    /**
     * Verifica si existe una placa
     */
    public boolean existePlaca(String placa) {
        return conductorDao.verificarExistenciaPlaca(placa) > 0;
    }
}

