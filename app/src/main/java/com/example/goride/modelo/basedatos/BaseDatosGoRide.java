package com.example.goride.modelo.basedatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.goride.modelo.dao.ConductorDao;
import com.example.goride.modelo.dao.RolDao;
import com.example.goride.modelo.dao.ServicioDao;
import com.example.goride.modelo.dao.UsuarioDao;
import com.example.goride.modelo.dao.ViajeDao;
import com.example.goride.modelo.entidades.Conductor;
import com.example.goride.modelo.entidades.Rol;
import com.example.goride.modelo.entidades.Servicio;
import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.modelo.entidades.Viaje;

@Database(
    entities = {
        Usuario.class,
        Rol.class,
        Conductor.class,
        Viaje.class,
        Servicio.class
    },
    version = 1,
    exportSchema = false
)
public abstract class BaseDatosGoRide extends RoomDatabase {

    private static BaseDatosGoRide instancia;

    public abstract UsuarioDao usuarioDao();
    public abstract RolDao rolDao();
    public abstract ConductorDao conductorDao();
    public abstract ViajeDao viajeDao();
    public abstract ServicioDao servicioDao();

    public static synchronized BaseDatosGoRide obtenerInstancia(Context contexto) {
        if (instancia == null) {
            instancia = Room.databaseBuilder(
                contexto.getApplicationContext(),
                BaseDatosGoRide.class,
                "goride_db"
            )
            .allowMainThreadQueries()
            .build();
        }
        return instancia;
    }

    public static void cerrarInstancia() {
        if (instancia != null && instancia.isOpen()) {
            instancia.close();
            instancia = null;
        }
    }
}

