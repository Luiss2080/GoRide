package com.example.goride.vista.adaptadores.rol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goride.R;
import com.example.goride.modelo.entidades.Rol;

import java.util.List;

/**
 * Adaptador para mostrar la lista de roles en un RecyclerView
 */
public class AdaptadorRol extends RecyclerView.Adapter<AdaptadorRol.VistaRol> {

    private List<Rol> roles;
    private EventosRol eventosRol;

    /**
     * Interface para manejar eventos de rol
     */
    public interface EventosRol {
        void alEditarRol(Rol rol);
        void alEliminarRol(Rol rol);
    }

    public AdaptadorRol(List<Rol> roles, EventosRol eventosRol) {
        this.roles = roles;
        this.eventosRol = eventosRol;
    }

    @NonNull
    @Override
    public VistaRol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_rol, parent, false);
        return new VistaRol(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaRol holder, int position) {
        Rol rol = roles.get(position);
        holder.vincular(rol);
    }

    @Override
    public int getItemCount() {
        return roles.size();
    }

    /**
     * ViewHolder para Rol
     */
    class VistaRol extends RecyclerView.ViewHolder {

        private TextView textoNombreRol;
        private TextView textoDescripcion;
        private TextView textoEstado;
        private Button botonEditar;
        private Button botonEliminar;

        public VistaRol(@NonNull View itemView) {
            super(itemView);

            textoNombreRol = itemView.findViewById(R.id.textoNombreRol);
            textoDescripcion = itemView.findViewById(R.id.textoDescripcion);
            textoEstado = itemView.findViewById(R.id.textoEstado);
            botonEditar = itemView.findViewById(R.id.botonEditar);
            botonEliminar = itemView.findViewById(R.id.botonEliminar);
        }

        public void vincular(Rol rol) {
            textoNombreRol.setText(rol.getNombreRol());
            textoDescripcion.setText(rol.getDescripcion());
            textoEstado.setText("Estado: " + rol.getEstado());

            botonEditar.setOnClickListener(v -> {
                if (eventosRol != null) {
                    eventosRol.alEditarRol(rol);
                }
            });

            botonEliminar.setOnClickListener(v -> {
                if (eventosRol != null) {
                    eventosRol.alEliminarRol(rol);
                }
            });
        }
    }
}

