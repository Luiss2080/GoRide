package com.example.goride.vista.adaptadores.conductor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goride.R;
import com.example.goride.modelo.entidades.Conductor;

import java.util.List;

/**
 * Adaptador para mostrar la lista de conductores en un RecyclerView
 */
public class AdaptadorConductor extends RecyclerView.Adapter<AdaptadorConductor.VistaConductor> {

    private List<Conductor> conductores;
    private EventosConductor eventosConductor;

    /**
     * Interface para manejar eventos de conductor
     */
    public interface EventosConductor {
        void alEditarConductor(Conductor conductor);
        void alEliminarConductor(Conductor conductor);
    }

    public AdaptadorConductor(List<Conductor> conductores, EventosConductor eventosConductor) {
        this.conductores = conductores;
        this.eventosConductor = eventosConductor;
    }

    @NonNull
    @Override
    public VistaConductor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_conductor, parent, false);
        return new VistaConductor(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaConductor holder, int position) {
        Conductor conductor = conductores.get(position);
        holder.vincular(conductor);
    }

    @Override
    public int getItemCount() {
        return conductores.size();
    }

    /**
     * ViewHolder para Conductor
     */
    class VistaConductor extends RecyclerView.ViewHolder {

        private TextView textoLicencia;
        private TextView textoPlaca;
        private TextView textoModelo;
        private TextView textoColor;
        private TextView textoAnio;
        private Button botonEditar;
        private Button botonEliminar;

        public VistaConductor(@NonNull View itemView) {
            super(itemView);

            textoLicencia = itemView.findViewById(R.id.textoLicencia);
            textoPlaca = itemView.findViewById(R.id.textoPlaca);
            textoModelo = itemView.findViewById(R.id.textoModelo);
            textoColor = itemView.findViewById(R.id.textoColor);
            textoAnio = itemView.findViewById(R.id.textoAnio);
            botonEditar = itemView.findViewById(R.id.botonEditar);
            botonEliminar = itemView.findViewById(R.id.botonEliminar);
        }

        public void vincular(Conductor conductor) {
            textoLicencia.setText("Licencia: " + conductor.getLicenciaConducir());
            textoPlaca.setText("Placa: " + conductor.getPlacaVehiculo());
            textoModelo.setText(conductor.getModeloVehiculo());
            textoColor.setText("Color: " + conductor.getColorVehiculo());
            textoAnio.setText("Año: " + conductor.getAnioVehiculo());

            botonEditar.setOnClickListener(v -> {
                if (eventosConductor != null) {
                    eventosConductor.alEditarConductor(conductor);
                }
            });

            botonEliminar.setOnClickListener(v -> {
                if (eventosConductor != null) {
                    eventosConductor.alEliminarConductor(conductor);
                }
            });
        }
    }
}

