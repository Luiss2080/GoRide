package com.example.goride.vista.adaptadores.servicio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goride.R;
import com.example.goride.modelo.entidades.Servicio;
import com.example.goride.modelo.utilidades.CalculadoraTarifa;

import java.util.List;

/**
 * Adaptador para mostrar la lista de servicios en un RecyclerView
 */
public class AdaptadorServicio extends RecyclerView.Adapter<AdaptadorServicio.VistaServicio> {

    private List<Servicio> servicios;
    private EventosServicio eventosServicio;

    /**
     * Interface para manejar eventos de servicio
     */
    public interface EventosServicio {
        void alEditarServicio(Servicio servicio);
        void alEliminarServicio(Servicio servicio);
    }

    public AdaptadorServicio(List<Servicio> servicios, EventosServicio eventosServicio) {
        this.servicios = servicios;
        this.eventosServicio = eventosServicio;
    }

    @NonNull
    @Override
    public VistaServicio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_servicio, parent, false);
        return new VistaServicio(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaServicio holder, int position) {
        Servicio servicio = servicios.get(position);
        holder.vincular(servicio);
    }

    @Override
    public int getItemCount() {
        return servicios.size();
    }

    /**
     * ViewHolder para Servicio
     */
    class VistaServicio extends RecyclerView.ViewHolder {

        private TextView textoNombreServicio;
        private TextView textoDescripcion;
        private TextView textoPrecioBase;
        private TextView textoPrecioPorKm;
        private TextView textoEstado;
        private Button botonEditar;
        private Button botonEliminar;

        public VistaServicio(@NonNull View itemView) {
            super(itemView);

            textoNombreServicio = itemView.findViewById(R.id.textoNombreServicio);
            textoDescripcion = itemView.findViewById(R.id.textoDescripcion);
            textoPrecioBase = itemView.findViewById(R.id.textoPrecioBase);
            textoPrecioPorKm = itemView.findViewById(R.id.textoPrecioPorKm);
            textoEstado = itemView.findViewById(R.id.textoEstado);
            botonEditar = itemView.findViewById(R.id.botonEditar);
            botonEliminar = itemView.findViewById(R.id.botonEliminar);
        }

        public void vincular(Servicio servicio) {
            textoNombreServicio.setText(servicio.getNombreServicio());
            textoDescripcion.setText(servicio.getDescripcion());
            textoPrecioBase.setText("Base: " + CalculadoraTarifa.formatearTarifa(servicio.getPrecioBase()));
            textoPrecioPorKm.setText("Por Km: " + CalculadoraTarifa.formatearTarifa(servicio.getPrecioPorKilometro()));
            textoEstado.setText("Estado: " + servicio.getEstado());

            botonEditar.setOnClickListener(v -> {
                if (eventosServicio != null) {
                    eventosServicio.alEditarServicio(servicio);
                }
            });

            botonEliminar.setOnClickListener(v -> {
                if (eventosServicio != null) {
                    eventosServicio.alEliminarServicio(servicio);
                }
            });
        }
    }
}

