package com.example.goride.controlador;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goride.R;
import com.example.goride.modelo.entidades.Rol;
import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.modelo.repositorio.RepositorioRol;
import com.example.goride.modelo.repositorio.RepositorioUsuario;
import com.example.goride.modelo.utilidades.UtilidadesFecha;
import com.example.goride.modelo.utilidades.ValidadorDatos;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para el formulario de usuario (Crear/Editar)
 */
public class ActividadFormularioUsuario extends AppCompatActivity {

    private TextView textoTitulo;
    private Button botonVolver;
    private TextInputEditText campoNombreCompleto;
    private TextInputEditText campoNombreUsuario;
    private TextInputEditText campoContrasena;
    private TextInputEditText campoCorreo;
    private TextInputEditText campoTelefono;
    private Spinner spinnerRol;
    private Spinner spinnerEstado;
    private Button botonGuardar;
    private Button botonCancelar;

    private RepositorioUsuario repositorioUsuario;
    private RepositorioRol repositorioRol;

    private List<Rol> roles;
    private int idUsuarioEditar = -1;
    private boolean esEdicion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_usuario);

        repositorioUsuario = new RepositorioUsuario(this);
        repositorioRol = new RepositorioRol(this);

        // Verificar si es edición
        if (getIntent().hasExtra("idUsuario")) {
            idUsuarioEditar = getIntent().getIntExtra("idUsuario", -1);
            esEdicion = true;
        }

        inicializarVistas();
        configurarSpinners();
        configurarEventos();

        if (esEdicion) {
            cargarDatosUsuario();
        }
    }

    /**
     * Inicializa las vistas
     */
    private void inicializarVistas() {
        textoTitulo = findViewById(R.id.textoTitulo);
        botonVolver = findViewById(R.id.botonVolver);
        campoNombreCompleto = findViewById(R.id.campoNombreCompleto);
        campoNombreUsuario = findViewById(R.id.campoNombreUsuario);
        campoContrasena = findViewById(R.id.campoContrasena);
        campoCorreo = findViewById(R.id.campoCorreo);
        campoTelefono = findViewById(R.id.campoTelefono);
        spinnerRol = findViewById(R.id.spinnerRol);
        spinnerEstado = findViewById(R.id.spinnerEstado);
        botonGuardar = findViewById(R.id.botonGuardar);
        botonCancelar = findViewById(R.id.botonCancelar);

        // Cambiar título según el modo
        if (esEdicion) {
            textoTitulo.setText(R.string.titulo_editar_usuario);
        } else {
            textoTitulo.setText(R.string.titulo_crear_usuario);
        }
    }

    /**
     * Configura los spinners
     */
    private void configurarSpinners() {
        // Spinner de Roles
        roles = repositorioRol.obtenerPorEstado("Activo");
        List<String> nombresRoles = new ArrayList<>();
        for (Rol rol : roles) {
            nombresRoles.add(rol.getNombreRol());
        }
        ArrayAdapter<String> adaptadorRoles = new ArrayAdapter<>(
            this,
            android.R.layout.simple_spinner_item,
            nombresRoles
        );
        adaptadorRoles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRol.setAdapter(adaptadorRoles);

        // Spinner de Estados
        String[] estados = {
            getString(R.string.estado_activo),
            getString(R.string.estado_inactivo)
        };
        ArrayAdapter<String> adaptadorEstados = new ArrayAdapter<>(
            this,
            android.R.layout.simple_spinner_item,
            estados
        );
        adaptadorEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstado.setAdapter(adaptadorEstados);
    }

    /**
     * Configura los eventos
     */
    private void configurarEventos() {
        botonVolver.setOnClickListener(v -> finish());
        botonGuardar.setOnClickListener(v -> guardarUsuario());
        botonCancelar.setOnClickListener(v -> finish());
    }

    /**
     * Carga los datos del usuario a editar
     */
    private void cargarDatosUsuario() {
        Usuario usuario = repositorioUsuario.obtenerPorId(idUsuarioEditar);
        if (usuario != null) {
            campoNombreCompleto.setText(usuario.getNombreCompleto());
            campoNombreUsuario.setText(usuario.getNombreUsuario());
            campoContrasena.setText(usuario.getContrasena());
            campoCorreo.setText(usuario.getCorreoElectronico());
            campoTelefono.setText(usuario.getTelefono());

            // Seleccionar rol
            for (int i = 0; i < roles.size(); i++) {
                if (roles.get(i).getIdRol() == usuario.getIdRol()) {
                    spinnerRol.setSelection(i);
                    break;
                }
            }

            // Seleccionar estado
            if (usuario.getEstado().equals("Activo")) {
                spinnerEstado.setSelection(0);
            } else {
                spinnerEstado.setSelection(1);
            }
        }
    }

    /**
     * Guarda el usuario
     */
    private void guardarUsuario() {
        // Obtener valores
        String nombreCompleto = campoNombreCompleto.getText().toString().trim();
        String nombreUsuario = campoNombreUsuario.getText().toString().trim();
        String contrasena = campoContrasena.getText().toString().trim();
        String correo = campoCorreo.getText().toString().trim();
        String telefono = campoTelefono.getText().toString().trim();
        int posicionRol = spinnerRol.getSelectedItemPosition();
        String estado = spinnerEstado.getSelectedItem().toString();

        // Validaciones
        if (!validarCampos(nombreCompleto, nombreUsuario, contrasena, correo, telefono)) {
            return;
        }

        // Crear o actualizar usuario
        Usuario usuario;
        if (esEdicion) {
            usuario = repositorioUsuario.obtenerPorId(idUsuarioEditar);
            usuario.setNombreCompleto(nombreCompleto);
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setContrasena(contrasena);
            usuario.setCorreoElectronico(correo);
            usuario.setTelefono(telefono);
            usuario.setIdRol(roles.get(posicionRol).getIdRol());
            usuario.setEstado(estado);

            repositorioUsuario.actualizar(usuario);
            mostrarMensaje(getString(R.string.mensaje_exito_actualizar));
        } else {
            usuario = new Usuario(
                nombreUsuario,
                contrasena,
                nombreCompleto,
                correo,
                telefono,
                roles.get(posicionRol).getIdRol(),
                estado,
                UtilidadesFecha.obtenerFechaActual()
            );

            repositorioUsuario.crear(usuario);
            mostrarMensaje(getString(R.string.mensaje_exito_crear));
        }

        finish();
    }

    /**
     * Valida los campos del formulario
     */
    private boolean validarCampos(String nombreCompleto, String nombreUsuario,
                                  String contrasena, String correo, String telefono) {
        if (!ValidadorDatos.esTextoValido(nombreCompleto)) {
            mostrarMensaje("El nombre completo es requerido");
            return false;
        }

        if (!ValidadorDatos.esNombreUsuarioValido(nombreUsuario)) {
            mostrarMensaje("El nombre de usuario debe tener al menos 4 caracteres");
            return false;
        }

        if (!ValidadorDatos.esContrasenaValida(contrasena)) {
            mostrarMensaje("La contraseña debe tener al menos 6 caracteres");
            return false;
        }

        if (!ValidadorDatos.esCorreoValido(correo)) {
            mostrarMensaje("El correo electrónico no es válido");
            return false;
        }

        if (!ValidadorDatos.esTelefonoValido(telefono)) {
            mostrarMensaje("El teléfono debe tener 10 dígitos");
            return false;
        }

        return true;
    }

    /**
     * Muestra un mensaje Toast
     */
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}

