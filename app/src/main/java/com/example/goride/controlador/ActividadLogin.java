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
        iniciarAnimaciones();
    }

    /**
     * Inicializa las vistas
     */
    private void inicializarVistas() {
        campoUsuario = findViewById(R.id.campoUsuario);
        campoContrasena = findViewById(R.id.campoContrasena);
        botonIngresar = findViewById(R.id.botonIngresar);

        // Buscar las vistas por su parent o crear referencias
        iconoHeader = findViewById(R.id.iconoHeader);
        if (iconoHeader == null) {
            // Si no tiene ID, buscar la primera CardView
            View rootView = findViewById(android.R.id.content);
            if (rootView instanceof android.view.ViewGroup) {
                iconoHeader = encontrarPrimeraCardView((android.view.ViewGroup) rootView);
            }
        }
    }

    /**
     * Configura los eventos de los componentes
     */
    private void configurarEventos() {
        // Evento del botón con animación
        botonIngresar.setOnClickListener(v -> {
            animarBoton(v);
            // Delay para la animación antes de procesar
            new Handler().postDelayed(this::iniciarSesion, 150);
        });

        // Validación en tiempo real para campos
        configurarValidacionTiempoReal();
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
        String usuario = campoUsuario.getText().toString().trim();
        String contrasena = campoContrasena.getText().toString().trim();

        boolean camposValidos = !usuario.isEmpty() && !contrasena.isEmpty() && contrasena.length() >= 3;

        botonIngresar.setEnabled(camposValidos);
        botonIngresar.setAlpha(camposValidos ? 1.0f : 0.6f);
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

    /**
     * Inicia las animaciones de entrada
     */
    private void iniciarAnimaciones() {
        // Encontrar todas las vistas
        View rootView = findViewById(android.R.id.content);

        // Inicialmente ocultar las vistas para animación
        if (iconoHeader != null) {
            iconoHeader.setAlpha(0f);
            iconoHeader.setTranslationY(50f);
        }

        // Animar secuencialmente
        animarElementosEntrada();
    }

    /**
     * Anima los elementos de entrada secuencialmente
     */
    private void animarElementosEntrada() {
        Handler handler = new Handler();

        // Animar ícono header (0ms)
        if (iconoHeader != null) {
            ObjectAnimator.ofFloat(iconoHeader, "alpha", 0f, 1f).setDuration(600).start();
            ObjectAnimator.ofFloat(iconoHeader, "translationY", 50f, 0f).setDuration(600).start();
        }

        // Animar formulario (200ms después)
        handler.postDelayed(() -> {
            Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.fade_slide_up);
            if (findViewById(R.id.campoUsuario) != null) {
                findViewById(R.id.campoUsuario).getParent().getParent().startAnimation(slideUp);
            }
        }, 200);

        // Animar botón (400ms después)
        handler.postDelayed(() -> {
            Animation scaleIn = AnimationUtils.loadAnimation(this, R.anim.scale_fade_in);
            botonIngresar.startAnimation(scaleIn);

            // Inicializar validación después de animaciones
            validarCamposYActivarBoton();
        }, 400);
    }

    /**
     * Anima el botón cuando se presiona
     */
    private void animarBoton(View boton) {
        // Escala down y up
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(boton, "scaleX", 1f, 0.95f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(boton, "scaleY", 1f, 0.95f);
        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(boton, "scaleX", 0.95f, 1f);
        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(boton, "scaleY", 0.95f, 1f);

        scaleDownX.setDuration(75);
        scaleDownY.setDuration(75);
        scaleUpX.setDuration(75);
        scaleUpY.setDuration(75);

        animatorSet.play(scaleDownX).with(scaleDownY);
        animatorSet.play(scaleUpX).with(scaleUpY).after(scaleDownX);
        animatorSet.start();
    }

    /**
     * Método auxiliar para encontrar la primera CardView
     */
    private CardView encontrarPrimeraCardView(android.view.ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof CardView) {
                return (CardView) child;
            } else if (child instanceof android.view.ViewGroup) {
                CardView found = encontrarPrimeraCardView((android.view.ViewGroup) child);
                if (found != null) return found;
            }
        }
        return null;
    }
}