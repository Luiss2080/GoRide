package com.example.goride.controlador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goride.R;
import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.modelo.repositorio.RepositorioUsuario;
import com.example.goride.modelo.utilidades.GestorSesion;
import com.example.goride.modelo.utilidades.InicializadorDatos;
import com.example.goride.modelo.utilidades.ValidadorDatos;
import com.google.android.material.textfield.TextInputEditText;

/**
 * Controlador para la pantalla de inicio de sesión
 */
public class ActividadLogin extends AppCompatActivity {

    private TextInputEditText campoUsuario;
    private TextInputEditText campoContrasena;
    private Button botonIngresar;

    private RepositorioUsuario repositorioUsuario;
    private GestorSesion gestorSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializar repositorios
        repositorioUsuario = new RepositorioUsuario(this);
        gestorSesion = new GestorSesion(this);

        // Inicializar datos de prueba
        InicializadorDatos inicializador = new InicializadorDatos(this);
        inicializador.inicializarDatosPrueba();

        // Verificar si ya hay sesión activa
        if (gestorSesion.haySesionActiva()) {
            irAMenuPrincipal();
            return;
        }

        setContentView(R.layout.activity_login);

        inicializarVistas();
        configurarEventos();
    }

    /**
     * Inicializa las vistas
     */
    private void inicializarVistas() {
        campoUsuario = findViewById(R.id.campoUsuario);
        campoContrasena = findViewById(R.id.campoContrasena);
        botonIngresar = findViewById(R.id.botonIngresar);
    }

    /**
     * Configura los eventos de los componentes
     */
    private void configurarEventos() {
        botonIngresar.setOnClickListener(v -> iniciarSesion());
    }

    /**
     * Procesa el inicio de sesión
     */
    private void iniciarSesion() {
        String nombreUsuario = campoUsuario.getText().toString().trim();
        String contrasena = campoContrasena.getText().toString().trim();

        // Validar campos vacíos
        if (!ValidadorDatos.esTextoValido(nombreUsuario) || !ValidadorDatos.esTextoValido(contrasena)) {
            mostrarMensaje(getString(R.string.error_campos_vacios));
            return;
        }

        // Intentar autenticar
        Usuario usuario = repositorioUsuario.autenticar(nombreUsuario, contrasena);

        if (usuario != null) {
            // Guardar sesión
            gestorSesion.iniciarSesion(
                usuario.getIdUsuario(),
                usuario.getNombreUsuario(),
                usuario.getNombreCompleto(),
                usuario.getIdRol()
            );

            // Ir al menú principal
            irAMenuPrincipal();
        } else {
            mostrarMensaje(getString(R.string.error_credenciales));
        }
    }

    /**
     * Navega al menú principal
     */
    private void irAMenuPrincipal() {
        Intent intent = new Intent(this, ActividadMenuPrincipal.class);
        startActivity(intent);
        finish();
    }

    /**
     * Muestra un mensaje Toast
     */
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}