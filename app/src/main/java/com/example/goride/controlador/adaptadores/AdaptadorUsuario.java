package com.example.goride.controlador.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goride.R;
import com.example.goride.modelo.entidades.Usuario;

import java.util.List;

/**
 * Adaptador para mostrar la lista de usuarios en un RecyclerView
 */
public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.VistaUsuario> {

    private List<Usuario> usuarios;
    private EventosUsuario eventosUsuario;

    /**
     * Interface para manejar eventos de usuario
     */
    public interface EventosUsuario {
        void alEditarUsuario(Usuario usuario);
        void alEliminarUsuario(Usuario usuario);
    }

    public AdaptadorUsuario(List<Usuario> usuarios, EventosUsuario eventosUsuario) {
        this.usuarios = usuarios;
        this.eventosUsuario = eventosUsuario;
    }

    @NonNull
    @Override
    public VistaUsuario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_usuario, parent, false);
        return new VistaUsuario(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaUsuario holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.vincular(usuario);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    /**
     * ViewHolder para Usuario
     */
    class VistaUsuario extends RecyclerView.ViewHolder {

        private TextView textoNombreCompleto;
        private TextView textoNombreUsuario;
        private TextView textoCorreo;
        private TextView textoTelefono;
        private Button botonEditar;
        private Button botonEliminar;

        public VistaUsuario(@NonNull View itemView) {
            super(itemView);

            textoNombreCompleto = itemView.findViewById(R.id.textoNombreCompleto);
            textoNombreUsuario = itemView.findViewById(R.id.textoNombreUsuario);
            textoCorreo = itemView.findViewById(R.id.textoCorreo);
            textoTelefono = itemView.findViewById(R.id.textoTelefono);
            botonEditar = itemView.findViewById(R.id.botonEditar);
            botonEliminar = itemView.findViewById(R.id.botonEliminar);
        }

        public void vincular(Usuario usuario) {
            textoNombreCompleto.setText(usuario.getNombreCompleto());
            textoNombreUsuario.setText("Usuario: " + usuario.getNombreUsuario());
            textoCorreo.setText("Correo: " + usuario.getCorreoElectronico());
            textoTelefono.setText("Teléfono: " + usuario.getTelefono());

            botonEditar.setOnClickListener(v -> {
                if (eventosUsuario != null) {
                    eventosUsuario.alEditarUsuario(usuario);
                }
            });

            botonEliminar.setOnClickListener(v -> {
                if (eventosUsuario != null) {
                    eventosUsuario.alEliminarUsuario(usuario);
                }
            });
        }
    }
}

