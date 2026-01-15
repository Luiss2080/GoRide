package com.example.goride.vista.adaptadores.viaje;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goride.R;
import com.example.goride.modelo.entidades.Viaje;
import com.example.goride.modelo.utilidades.CalculadoraTarifa;

import java.util.List;

/**
 * Adaptador para mostrar la lista de viajes en un RecyclerView
 */
public class AdaptadorViaje extends RecyclerView.Adapter<AdaptadorViaje.VistaViaje> {

    private List<Viaje> viajes;
    private EventosViaje eventosViaje;

    /**
     * Interface para manejar eventos de viaje
     */
    public interface EventosViaje {
        void alEditarViaje(Viaje viaje);
        void alEliminarViaje(Viaje viaje);
        void alVerDetalles(Viaje viaje);
    }

    public AdaptadorViaje(List<Viaje> viajes, EventosViaje eventosViaje) {
        this.viajes = viajes;
        this.eventosViaje = eventosViaje;
    }

    @NonNull
    @Override
    public VistaViaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_viaje, parent, false);
        return new VistaViaje(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaViaje holder, int position) {
        Viaje viaje = viajes.get(position);
        holder.vincular(viaje);
    }

    @Override
    public int getItemCount() {
        return viajes.size();
    }

    /**
     * ViewHolder para Viaje
     */
    class VistaViaje extends RecyclerView.ViewHolder {

        private TextView textoOrigen;
        private TextView textoDestino;
        private TextView textoFecha;
        private TextView textoEstado;
        private TextView textoTarifa;
        private Button botonEditar;
        private Button botonEliminar;

        public VistaViaje(@NonNull View itemView) {
            super(itemView);

            textoOrigen = itemView.findViewById(R.id.textoOrigen);
            textoDestino = itemView.findViewById(R.id.textoDestino);
            textoFecha = itemView.findViewById(R.id.textoFecha);
            textoEstado = itemView.findViewById(R.id.textoEstado);
            textoTarifa = itemView.findViewById(R.id.textoTarifa);
            botonEditar = itemView.findViewById(R.id.botonEditar);
            botonEliminar = itemView.findViewById(R.id.botonEliminar);
        }

        public void vincular(Viaje viaje) {
            textoOrigen.setText("Origen: " + viaje.getOrigen());
            textoDestino.setText("Destino: " + viaje.getDestino());
            textoFecha.setText(viaje.getFechaViaje() + " - " + viaje.getHoraViaje());
            textoEstado.setText("Estado: " + viaje.getEstado());
            textoTarifa.setText("Tarifa: " + CalculadoraTarifa.formatearTarifa(viaje.getTarifa()));

            botonEditar.setOnClickListener(v -> {
                if (eventosViaje != null) {
                    eventosViaje.alEditarViaje(viaje);
                }
            });

            botonEliminar.setOnClickListener(v -> {
                if (eventosViaje != null) {
                    eventosViaje.alEliminarViaje(viaje);
                }
            });

            itemView.setOnClickListener(v -> {
                if (eventosViaje != null) {
                    eventosViaje.alVerDetalles(viaje);
                }
            });
        }
    }
}

