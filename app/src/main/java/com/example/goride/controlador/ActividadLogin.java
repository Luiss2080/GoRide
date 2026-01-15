package com.example.goride.controlador;
}
    }
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    private void mostrarMensaje(String mensaje) {
     */
     * Muestra un mensaje Toast
    /**

    }
        finish();
        startActivity(intent);
        Intent intent = new Intent(this, ActividadMenuPrincipal.class);
    private void irAMenuPrincipal() {
     */
     * Navega al menú principal
    /**

    }
        }
            mostrarMensaje(getString(R.string.error_credenciales));
        } else {
            irAMenuPrincipal();
            // Ir al menú principal

            );
                usuario.getIdRol()
                usuario.getNombreCompleto(),
                usuario.getNombreUsuario(),
                usuario.getIdUsuario(),
            gestorSesion.iniciarSesion(
            // Guardar sesión
        if (usuario != null) {

        Usuario usuario = repositorioUsuario.autenticar(nombreUsuario, contrasena);
        // Intentar autenticar

        }
            return;
            mostrarMensaje(getString(R.string.error_campos_vacios));
        if (!ValidadorDatos.esTextoValido(nombreUsuario) || !ValidadorDatos.esTextoValido(contrasena)) {
        // Validar campos vacíos

        String contrasena = campoContrasena.getText().toString().trim();
        String nombreUsuario = campoUsuario.getText().toString().trim();
    private void iniciarSesion() {
     */
     * Procesa el inicio de sesión
    /**

    }
        botonIngresar.setOnClickListener(v -> iniciarSesion());
    private void configurarEventos() {
     */
     * Configura los eventos de los componentes
    /**

    }
        botonIngresar = findViewById(R.id.botonIngresar);
        campoContrasena = findViewById(R.id.campoContrasena);
        campoUsuario = findViewById(R.id.campoUsuario);
    private void inicializarVistas() {
     */
     * Inicializa las vistas
    /**

    }
        configurarEventos();
        inicializarVistas();

        setContentView(R.layout.activity_login);

        }
            return;
            irAMenuPrincipal();
        if (gestorSesion.haySesionActiva()) {
        // Verificar si ya hay sesión activa

        inicializador.inicializarDatosPrueba();
        InicializadorDatos inicializador = new InicializadorDatos(this);
        // Inicializar datos de prueba

        gestorSesion = new GestorSesion(this);
        repositorioUsuario = new RepositorioUsuario(this);
        // Inicializar repositorios

        super.onCreate(savedInstanceState);
    protected void onCreate(Bundle savedInstanceState) {
    @Override

    private GestorSesion gestorSesion;
    private RepositorioUsuario repositorioUsuario;

    private Button botonIngresar;
    private TextInputEditText campoContrasena;
    private TextInputEditText campoUsuario;

public class ActividadLogin extends AppCompatActivity {
 */
 * Controlador para la pantalla de inicio de sesión
/**

import com.google.android.material.textfield.TextInputEditText;
import com.example.goride.modelo.utilidades.ValidadorDatos;
import com.example.goride.modelo.utilidades.InicializadorDatos;
import com.example.goride.modelo.utilidades.GestorSesion;
import com.example.goride.modelo.repositorio.RepositorioUsuario;
import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.R;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;


