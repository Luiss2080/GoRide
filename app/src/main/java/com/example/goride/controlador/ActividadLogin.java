package com.example.goride.controlador;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
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
 * Controlador para la pantalla de inicio de sesión moderno
 */
public class ActividadLogin extends AppCompatActivity {

    private TextInputEditText campoUsuario;
    private TextInputEditText campoContrasena;
    private Button botonIngresar;

    private RepositorioUsuario repositorioUsuario;
    private GestorSesion gestorSesion;
    private Handler handler = new Handler();

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
        // Evento del botón simplificado
        botonIngresar.setOnClickListener(v -> {
            // Efecto visual simple
            animarBotonClick(v);
            // Delay mínimo antes de procesar
            handler.postDelayed(this::iniciarSesion, 150);
        });

        // Validación en tiempo real para campos
        configurarValidacionTiempoReal();

        // Inicializar estado del botón
        validarCamposYActivarBoton();
    }

    /**
     * Configura la validación en tiempo real de los campos
     */
    private void configurarValidacionTiempoReal() {
        TextWatcher validador = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                validarCamposYActivarBoton();
            }
        };

        campoUsuario.addTextChangedListener(validador);
        campoContrasena.addTextChangedListener(validador);
    }

    /**
     * Valida los campos y activa/desactiva el botón
     */
    private void validarCamposYActivarBoton() {
        String usuario = obtenerTextoSeguro(campoUsuario);
        String contrasena = obtenerTextoSeguro(campoContrasena);

        boolean camposValidos = !usuario.isEmpty() &&
                               !contrasena.isEmpty() &&
                               contrasena.length() >= 3;

        botonIngresar.setEnabled(camposValidos);
        botonIngresar.setAlpha(camposValidos ? 1.0f : 0.6f);
    }

    /**
     * Obtiene texto de un campo de forma segura
     */
    private String obtenerTextoSeguro(TextInputEditText campo) {
        if (campo != null && campo.getText() != null) {
            return campo.getText().toString().trim();
        }
        return "";
    }

    /**
     * Procesa el inicio de sesión
     */
    private void iniciarSesion() {
        String nombreUsuario = obtenerTextoSeguro(campoUsuario);
        String contrasena = obtenerTextoSeguro(campoContrasena);

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

    /**
     * Animación simple para el click del botón
     */
    private void animarBotonClick(android.view.View boton) {
        // Efecto de escala simple usando ViewPropertyAnimator
        boton.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction(() -> {
                    boton.animate()
                            .scaleX(1.0f)
                            .scaleY(1.0f)
                            .setDuration(100)
                            .start();
                }).start();
    }
}