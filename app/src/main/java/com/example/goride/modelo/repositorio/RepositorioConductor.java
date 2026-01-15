package com.example.goride.modelo.repositorio;
import android.content.Context;
import com.example.goride.modelo.basedatos.BaseDatosGoRide;
import com.example.goride.modelo.dao.ConductorDao;
import com.example.goride.modelo.entidades.Conductor;
import java.util.List;
public class RepositorioConductor {
    private ConductorDao conductorDao;
    public RepositorioConductor(Context contexto) {
        BaseDatosGoRide baseDatos = BaseDatosGoRide.obtenerInstancia(contexto);
        this.conductorDao = baseDatos.conductorDao();
    }
    public long crear(Conductor conductor) { return conductorDao.insertar(conductor); }
    public void actualizar(Conductor conductor) { conductorDao.actualizar(conductor); }
    public void eliminar(Conductor conductor) { conductorDao.eliminar(conductor); }
    public List<Conductor> obtenerTodos() { return conductorDao.obtenerTodos(); }
    public Conductor obtenerPorId(int idConductor) { return conductorDao.obtenerPorId(idConductor); }
    public Conductor obtenerPorUsuario(int idUsuario) { return conductorDao.obtenerPorUsuario(idUsuario); }
    public Conductor obtenerPorLicencia(String licencia) { return conductorDao.obtenerPorLicencia(licencia); }
    public Conductor obtenerPorPlaca(String placa) { return conductorDao.obtenerPorPlaca(placa); }
    public List<Conductor> obtenerPorEstado(String estado) { return conductorDao.obtenerPorEstado(estado); }
    public boolean existeLicencia(String licencia) { return conductorDao.verificarExistenciaLicencia(licencia) > 0; }
    public boolean existePlaca(String placa) { return conductorDao.verificarExistenciaPlaca(placa) > 0; }
}
