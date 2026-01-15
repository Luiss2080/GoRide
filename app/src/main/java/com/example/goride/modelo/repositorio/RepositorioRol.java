package com.example.goride.modelo.repositorio;

import android.content.Context;

import com.example.goride.modelo.basedatos.BaseDatosGoRide;
import com.example.goride.modelo.dao.RolDao;
import com.example.goride.modelo.entidades.Rol;

import java.util.List;

/**
 * Repositorio para gestionar operaciones de Rol
 */
public class RepositorioRol {

    private RolDao rolDao;

    public RepositorioRol(Context contexto) {
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
        this.rolDao = baseDatos.rolDao();
    }

    /**
     * Crea un nuevo rol
     */
    public long crear(Rol rol) {
        return rolDao.insertar(rol);
    }

    /**
     * Actualiza un rol existente
     */
    public void actualizar(Rol rol) {
        rolDao.actualizar(rol);
    }

    /**
     * Elimina un rol
     */
    public void eliminar(Rol rol) {
        rolDao.eliminar(rol);
    }

    /**
     * Obtiene todos los roles
     */
    public List<Rol> obtenerTodos() {
        return rolDao.obtenerTodos();
    }

    /**
     * Obtiene un rol por su ID
     */
    public Rol obtenerPorId(int idRol) {
        return rolDao.obtenerPorId(idRol);
    }

    /**
     * Obtiene un rol por nombre
     */
    public Rol obtenerPorNombre(String nombreRol) {
        return rolDao.obtenerPorNombre(nombreRol);
    }

    /**
     * Obtiene roles por estado
     */
    public List<Rol> obtenerPorEstado(String estado) {
        return rolDao.obtenerPorEstado(estado);
    }

    /**
     * Verifica si existe un nombre de rol
     */
    public boolean existeNombre(String nombreRol) {
        return rolDao.verificarExistenciaNombre(nombreRol) > 0;
    }
}

