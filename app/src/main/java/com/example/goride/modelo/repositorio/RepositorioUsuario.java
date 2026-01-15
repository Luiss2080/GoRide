package com.example.goride.modelo.repositorio;
}
    }
        return usuarioDao.verificarExistenciaCorreo(correo) > 0;
    public boolean existeCorreo(String correo) {
     */
     * Verifica si existe un correo electrónico
    /**

    }
        return usuarioDao.verificarExistenciaUsuario(nombreUsuario) > 0;
    public boolean existeNombreUsuario(String nombreUsuario) {
     */
     * Verifica si existe un nombre de usuario
    /**

    }
        return usuarioDao.obtenerPorEstado(estado);
    public List<Usuario> obtenerPorEstado(String estado) {
     */
     * Obtiene usuarios por estado
    /**

    }
        return usuarioDao.obtenerPorRol(idRol);
    public List<Usuario> obtenerPorRol(int idRol) {
     */
     * Obtiene usuarios por rol
    /**

    }
        return usuarioDao.autenticar(nombreUsuario, contrasena);
    public Usuario autenticar(String nombreUsuario, String contrasena) {
     */
     * Autentica un usuario
    /**

    }
        return usuarioDao.obtenerPorNombreUsuario(nombreUsuario);
    public Usuario obtenerPorNombreUsuario(String nombreUsuario) {
     */
     * Obtiene un usuario por nombre de usuario
    /**

    }
        return usuarioDao.obtenerPorId(idUsuario);
    public Usuario obtenerPorId(int idUsuario) {
     */
     * Obtiene un usuario por su ID
    /**

    }
        return usuarioDao.obtenerTodos();
    public List<Usuario> obtenerTodos() {
     */
     * Obtiene todos los usuarios
    /**

    }
        usuarioDao.eliminar(usuario);
    public void eliminar(Usuario usuario) {
     */
     * Elimina un usuario
    /**

    }
        usuarioDao.actualizar(usuario);
    public void actualizar(Usuario usuario) {
     */
     * Actualiza un usuario existente
    /**

    }
        return usuarioDao.insertar(usuario);
    public long crear(Usuario usuario) {
     */
     * Crea un nuevo usuario
    /**

    }
        this.usuarioDao = baseDatos.usuarioDao();
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
    public RepositorioUsuario(Context contexto) {

    private UsuarioDao usuarioDao;

public class RepositorioUsuario {
 */
 * Repositorio para gestionar operaciones de Usuario
/**

import java.util.List;

import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.modelo.dao.UsuarioDao;
import com.example.goride.modelo.basedatos.BaseDatosGoRide;

import android.content.Context;


