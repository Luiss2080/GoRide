package com.example.goride.modelo.repositorio;
import android.content.Context;
import com.example.goride.modelo.basedatos.BaseDatosGoRide;
import com.example.goride.modelo.dao.ViajeDao;
import com.example.goride.modelo.entidades.Viaje;
import java.util.List;
public class RepositorioViaje {
    private ViajeDao viajeDao;
    public RepositorioViaje(Context contexto) {
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
        this.viajeDao = baseDatos.viajeDao();
    }
    public long crear(Viaje viaje) { return viajeDao.insertar(viaje); }
    public void actualizar(Viaje viaje) { viajeDao.actualizar(viaje); }
    public void eliminar(Viaje viaje) { viajeDao.eliminar(viaje); }
    public List<Viaje> obtenerTodos() { return viajeDao.obtenerTodos(); }
    public Viaje obtenerPorId(int idViaje) { return viajeDao.obtenerPorId(idViaje); }
    public List<Viaje> obtenerPorUsuario(int idUsuario) { return viajeDao.obtenerPorUsuario(idUsuario); }
    public List<Viaje> obtenerPorConductor(int idConductor) { return viajeDao.obtenerPorConductor(idConductor); }
    public List<Viaje> obtenerPorEstado(String estado) { return viajeDao.obtenerPorEstado(estado); }
    public List<Viaje> obtenerPorFecha(String fecha) { return viajeDao.obtenerPorFecha(fecha); }
    public List<Viaje> obtenerPorUsuarioYEstado(int idUsuario, String estado) { return viajeDao.obtenerPorUsuarioYEstado(idUsuario, estado); }
    public List<Viaje> obtenerPorConductorYEstado(int idConductor, String estado) { return viajeDao.obtenerPorConductorYEstado(idConductor, estado); }
    public List<Viaje> obtenerTodosOrdenadosPorFecha() { return viajeDao.obtenerTodosOrdenadosPorFecha(); }
}
