package com.example.goride.vista.adaptadores.usuario;
}
    }
        }
            });
                }
                    eventosUsuario.alEliminarUsuario(usuario);
                if (eventosUsuario != null) {
            botonEliminar.setOnClickListener(v -> {

            });
                }
                    eventosUsuario.alEditarUsuario(usuario);
                if (eventosUsuario != null) {
            botonEditar.setOnClickListener(v -> {

            textoTelefono.setText("Teléfono: " + usuario.getTelefono());
            textoCorreo.setText("Correo: " + usuario.getCorreoElectronico());
            textoNombreUsuario.setText("Usuario: " + usuario.getNombreUsuario());
            textoNombreCompleto.setText(usuario.getNombreCompleto());
        public void vincular(Usuario usuario) {

        }
            botonEliminar = itemView.findViewById(R.id.botonEliminar);
            botonEditar = itemView.findViewById(R.id.botonEditar);
            textoTelefono = itemView.findViewById(R.id.textoTelefono);
            textoCorreo = itemView.findViewById(R.id.textoCorreo);
            textoNombreUsuario = itemView.findViewById(R.id.textoNombreUsuario);
            textoNombreCompleto = itemView.findViewById(R.id.textoNombreCompleto);

            super(itemView);
        public VistaUsuario(@NonNull View itemView) {

        private Button botonEliminar;
        private Button botonEditar;
        private TextView textoTelefono;
        private TextView textoCorreo;
        private TextView textoNombreUsuario;
        private TextView textoNombreCompleto;

    class VistaUsuario extends RecyclerView.ViewHolder {
     */
     * ViewHolder para Usuario
    /**

    }
        return usuarios.size();
    public int getItemCount() {
    @Override

    }
        holder.vincular(usuario);
        Usuario usuario = usuarios.get(position);
    public void onBindViewHolder(@NonNull VistaUsuario holder, int position) {
    @Override

    }
        return new VistaUsuario(vista);
            .inflate(R.layout.item_usuario, parent, false);
        View vista = LayoutInflater.from(parent.getContext())
    public VistaUsuario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    @Override
    @NonNull

    }
        this.eventosUsuario = eventosUsuario;
        this.usuarios = usuarios;
    public AdaptadorUsuario(List<Usuario> usuarios, EventosUsuario eventosUsuario) {

    }
        void alEliminarUsuario(Usuario usuario);
        void alEditarUsuario(Usuario usuario);
    public interface EventosUsuario {
     */
     * Interface para manejar eventos de usuario
    /**

    private EventosUsuario eventosUsuario;
    private List<Usuario> usuarios;

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.VistaUsuario> {
 */
 * Adaptador para mostrar la lista de usuarios en un RecyclerView
/**

import java.util.List;

import com.example.goride.modelo.entidades.Usuario;
import com.example.goride.R;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import android.widget.TextView;
import android.widget.Button;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;


