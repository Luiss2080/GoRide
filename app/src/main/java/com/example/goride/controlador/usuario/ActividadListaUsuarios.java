package com.example.goride.controlador.usuario;
}
    }
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    private void mostrarMensaje(String mensaje) {
     */
     * Muestra un mensaje Toast
    /**

    }
            .show();
            .setNegativeButton(getString(R.string.no), null)
            })
                cargarUsuarios();
                mostrarMensaje(getString(R.string.mensaje_exito_eliminar));
                repositorioUsuario.eliminar(usuario);
            .setPositiveButton(getString(R.string.si), (dialog, which) -> {
            .setMessage(getString(R.string.mensaje_confirmacion_eliminar))
            .setTitle("Confirmar eliminación")
        new AlertDialog.Builder(this)
    public void alEliminarUsuario(Usuario usuario) {
    @Override
     */
     * Elimina un usuario
    /**

    }
        startActivity(intent);
        intent.putExtra("idUsuario", usuario.getIdUsuario());
        Intent intent = new Intent(this, ActividadFormularioUsuario.class);
    public void alEditarUsuario(Usuario usuario) {
    @Override
     */
     * Abre el formulario para editar usuario
    /**

    }
        startActivity(intent);
        Intent intent = new Intent(this, ActividadFormularioUsuario.class);
    private void abrirFormularioCrear() {
     */
     * Abre el formulario para crear usuario
    /**

    }
        listaUsuarios.setAdapter(adaptador);
        adaptador = new AdaptadorUsuario(usuarios, this);
        usuarios = repositorioUsuario.obtenerTodos();
    private void cargarUsuarios() {
     */
     * Carga la lista de usuarios
    /**

    }
        botonCrear.setOnClickListener(v -> abrirFormularioCrear());
        botonVolver.setOnClickListener(v -> finish());
    private void configurarEventos() {
     */
     * Configura los eventos
    /**

    }
        listaUsuarios.setLayoutManager(new LinearLayoutManager(this));

        listaUsuarios = findViewById(R.id.listaUsuarios);
        botonCrear = findViewById(R.id.botonCrear);
        botonVolver = findViewById(R.id.botonVolver);
        textoTitulo = findViewById(R.id.textoTitulo);
    private void inicializarVistas() {
     */
     * Inicializa las vistas
    /**

    }
        cargarUsuarios();
        super.onResume();
    protected void onResume() {
    @Override

    }
        cargarUsuarios();
        configurarEventos();
        inicializarVistas();

        repositorioUsuario = new RepositorioUsuario(this);

        setContentView(R.layout.activity_lista_usuarios);
        super.onCreate(savedInstanceState);
    protected void onCreate(Bundle savedInstanceState) {
    @Override

    private List<Usuario> usuarios;
    private AdaptadorUsuario adaptador;
    private RepositorioUsuario repositorioUsuario;

    private RecyclerView listaUsuarios;
    private Button botonCrear;
    private Button botonVolver;
    private TextView textoTitulo;

public class ActividadListaUsuarios extends AppCompatActivity implements AdaptadorUsuario.EventosUsuario {
 */
 * Controlador para la lista de usuarios
/**

import java.util.List;

import com.example.goride.modelo.repositorio.RepositorioUsuario;
import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.vista.adaptadores.usuario.AdaptadorUsuario;
import com.example.goride.R;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;


