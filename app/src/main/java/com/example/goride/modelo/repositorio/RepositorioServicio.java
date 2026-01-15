package com.example.goride.modelo.repositorio;
import android.content.Context;
import com.example.goride.modelo.basedatos.BaseDatosGoRide;
import com.example.goride.modelo.dao.ServicioDao;
import com.example.goride.modelo.entidades.Servicio;
import java.util.List;
public class RepositorioServicio {
    private ServicioDao servicioDao;
    public RepositorioServicio(Context contexto) {
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
        this.servicioDao = baseDatos.servicioDao();
    }
    public long crear(Servicio servicio) { return servicioDao.insertar(servicio); }
    public void actualizar(Servicio servicio) { servicioDao.actualizar(servicio); }
    public void eliminar(Servicio servicio) { servicioDao.eliminar(servicio); }
    public List<Servicio> obtenerTodos() { return servicioDao.obtenerTodos(); }
    public Servicio obtenerPorId(int idServicio) { return servicioDao.obtenerPorId(idServicio); }
    public Servicio obtenerPorNombre(String nombreServicio) { return servicioDao.obtenerPorNombre(nombreServicio); }
    public List<Servicio> obtenerPorEstado(String estado) { return servicioDao.obtenerPorEstado(estado); }
    public boolean existeNombre(String nombreServicio) { return servicioDao.verificarExistenciaNombre(nombreServicio) > 0; }
}
