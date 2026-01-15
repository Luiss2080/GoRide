package com.example.goride.modelo.repositorio;
}
    }
        return usuarioDao.verificarExistenciaCorreo(correo) > 0;
    public boolean existeCorreo(String correo) {

    }
        return usuarioDao.verificarExistenciaUsuario(nombreUsuario) > 0;
    public boolean existeNombreUsuario(String nombreUsuario) {

    }
        return usuarioDao.obtenerPorEstado(estado);
    public List<Usuario> obtenerPorEstado(String estado) {

    }
        return usuarioDao.obtenerPorRol(idRol);
    public List<Usuario> obtenerPorRol(int idRol) {

    }
        return usuarioDao.autenticar(nombreUsuario, contrasena);
    public Usuario autenticar(String nombreUsuario, String contrasena) {

    }
        return usuarioDao.obtenerPorNombreUsuario(nombreUsuario);
    public Usuario obtenerPorNombreUsuario(String nombreUsuario) {

    }
        return usuarioDao.obtenerPorId(idUsuario);
    public Usuario obtenerPorId(int idUsuario) {

    }
        return usuarioDao.obtenerTodos();
    public List<Usuario> obtenerTodos() {

    }
        usuarioDao.eliminar(usuario);
    public void eliminar(Usuario usuario) {

    }
        usuarioDao.actualizar(usuario);
    public void actualizar(Usuario usuario) {

    }
        return usuarioDao.insertar(usuario);
    public long crear(Usuario usuario) {

    }
        this.usuarioDao = baseDatos.usuarioDao();
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
    public RepositorioUsuario(Context contexto) {

    private UsuarioDao usuarioDao;

public class RepositorioUsuario {

import java.util.List;

import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.modelo.dao.UsuarioDao;
import com.example.goride.modelo.basedatos.BaseDatosGoRide;

import android.content.Context;


