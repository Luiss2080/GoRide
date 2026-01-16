package com.example.goride.controlador;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
 * Controlador para la pantalla de inicio de sesión con diseño moderno
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
        iniciarAnimacionesEntrada();
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
        // Evento del botón con efecto visual
        botonIngresar.setOnClickListener(v -> {
            animarBotonClick(v);
            handler.postDelayed(this::iniciarSesion, 200);
        });

        // Validación en tiempo real
        configurarValidacionTiempoReal();

        // Estado inicial del botón
        validarCamposYActualizarBoton();
    }

    /**
     * Configura la validación en tiempo real de los campos
     */
    private void configurarValidacionTiempoReal() {
        TextWatcher validador = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No necesario implementar
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No necesario implementar
            }

            @Override
            public void afterTextChanged(Editable s) {
                validarCamposYActualizarBoton();
            }
        };

        campoUsuario.addTextChangedListener(validador);
        campoContrasena.addTextChangedListener(validador);
    }

    /**
     * Valida los campos y actualiza el estado del botón
     */
    private void validarCamposYActualizarBoton() {
        String usuario = obtenerTexto(campoUsuario);
        String contrasena = obtenerTexto(campoContrasena);

        boolean camposValidos = !usuario.isEmpty() &&
                               !contrasena.isEmpty() &&
                               contrasena.length() >= 3;

        botonIngresar.setEnabled(camposValidos);
        botonIngresar.setAlpha(camposValidos ? 1.0f : 0.5f);
    }

    /**
     * Obtiene texto de un campo de forma segura
     */
    private String obtenerTexto(TextInputEditText campo) {
        if (campo.getText() != null) {
            return campo.getText().toString().trim();
        }
        return "";
    }

    /**
     * Procesa el inicio de sesión
     */
    private void iniciarSesion() {
        String nombreUsuario = obtenerTexto(campoUsuario);
        String contrasena = obtenerTexto(campoContrasena);

        // Validar campos vacíos
        if (!ValidadorDatos.esTextoValido(nombreUsuario) || !ValidadorDatos.esTextoValido(contrasena)) {
            mostrarMensajeError(getString(R.string.error_campos_vacios));
            return;
        }

        // Deshabilitar botón temporalmente
        botonIngresar.setEnabled(false);
        botonIngresar.setText("Ingresando...");

        // Simular delay de autenticación para mejor UX
        handler.postDelayed(() -> {
            Usuario usuario = repositorioUsuario.autenticar(nombreUsuario, contrasena);

            if (usuario != null) {
                // Guardar sesión
                gestorSesion.iniciarSesion(
                    usuario.getIdUsuario(),
                    usuario.getNombreUsuario(),
                    usuario.getNombreCompleto(),
                    usuario.getIdRol()
                );

                // Animación de éxito y navegar
                mostrarMensajeExito("¡Bienvenido!");
                handler.postDelayed(this::irAMenuPrincipal, 1000);
            } else {
                mostrarMensajeError(getString(R.string.error_credenciales));
                restaurarBoton();
            }
        }, 800);
    }

    /**
     * Restaura el estado original del botón
     */
    private void restaurarBoton() {
        botonIngresar.setText(getString(R.string.boton_ingresar));
        validarCamposYActualizarBoton();
    }

    /**
     * Navega al menú principal con animación
     */
    private void irAMenuPrincipal() {
        Intent intent = new Intent(this, ActividadMenuPrincipal.class);
        startActivity(intent);
        finish();
        // Transición suave
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * Muestra un mensaje de error
     */
    private void mostrarMensajeError(String mensaje) {
        Toast.makeText(this, "❌ " + mensaje, Toast.LENGTH_SHORT).show();
    }

    /**
     * Muestra un mensaje de éxito
     */
    private void mostrarMensajeExito(String mensaje) {
        Toast.makeText(this, "✅ " + mensaje, Toast.LENGTH_SHORT).show();
    }

    /**
     * Inicia las animaciones de entrada
     */
    private void iniciarAnimacionesEntrada() {
        // Animar elementos secuencialmente para mejor efecto
        handler.postDelayed(() -> animarElemento(findViewById(R.id.campoUsuario).getParent().getParent()), 200);
        handler.postDelayed(() -> animarElemento(botonIngresar), 600);
    }

    /**
     * Anima un elemento con fade in y slide up
     */
    private void animarElemento(Object elemento) {
        if (elemento instanceof android.view.View) {
            android.view.View vista = (android.view.View) elemento;
            Animation animacion = AnimationUtils.loadAnimation(this, R.anim.fade_slide_up);
            vista.startAnimation(animacion);
        }
    }

    /**
     * Anima el click del botón
     */
    private void animarBotonClick(android.view.View boton) {
        // Efecto de escala simple
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
