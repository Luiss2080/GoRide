package com.example.goride.controlador.usuario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goride.R;
import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.modelo.repositorio.RepositorioUsuario;
import com.example.goride.vista.adaptadores.usuario.AdaptadorUsuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * Actividad para listar usuarios
 */
public class ActividadListaUsuarios extends AppCompatActivity implements AdaptadorUsuario.EventosUsuario {

    private RecyclerView listaUsuarios;
    private FloatingActionButton botonAgregar;
    private RepositorioUsuario repositorioUsuario;
    private AdaptadorUsuario adaptador;
    private List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        repositorioUsuario = new RepositorioUsuario(this);

        listaUsuarios = findViewById(R.id.listaUsuarios);
        listaUsuarios.setLayoutManager(new LinearLayoutManager(this));

        botonAgregar = findViewById(R.id.botonAgregar);
        botonAgregar.setOnClickListener(v -> abrirFormularioCrear());
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarUsuarios();
    }

    /**
     * Carga la lista de usuarios
     */
    private void cargarUsuarios() {
        usuarios = repositorioUsuario.obtenerTodos();
        adaptador = new AdaptadorUsuario(usuarios, this);
        listaUsuarios.setAdapter(adaptador);
    }

    /**
     * Abre el formulario para crear usuario
     */
    private void abrirFormularioCrear() {
        Intent intent = new Intent(this, ActividadFormularioUsuario.class);
        startActivity(intent);
    }

    /**
     * Abre el formulario para editar usuario
     */
    @Override
    public void alEditarUsuario(Usuario usuario) {
        Intent intent = new Intent(this, ActividadFormularioUsuario.class);
        intent.putExtra("idUsuario", usuario.getIdUsuario());
        startActivity(intent);
    }

    /**
     * Elimina un usuario
     */
    @Override
    public void alEliminarUsuario(Usuario usuario) {
        new AlertDialog.Builder(this)
            .setTitle("Confirmar eliminación")
            .setMessage(getString(R.string.mensaje_confirmacion_eliminar))
            .setPositiveButton(getString(R.string.si), (dialog, which) -> {
                repositorioUsuario.eliminar(usuario);
                mostrarMensaje(getString(R.string.mensaje_exito_eliminar));
                cargarUsuarios();
            })
            .setNegativeButton(getString(R.string.no), null)
            .show();
    }

    /**
     * Muestra un mensaje Toast
     */
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}

