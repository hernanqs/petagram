package android.fundamentos.mascotas;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    java.util.ArrayList<Mascota> mascotas;

    public MascotaAdaptador(java.util.ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    //Inflar el layout y lo pasará al viewholder para que él obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingCV.setText(Integer.toString(mascota.getRating()));
        mascotaViewHolder.tvFotoCV.setImageResource(mascota.getImgFoto());
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private android.widget.TextView tvNombreCV;
        private android.widget.TextView tvRatingCV;
        private android.widget.ImageView tvFotoCV;
        public MascotaViewHolder(android.view.View itemView) {
            super(itemView);
            tvNombreCV = (android.widget.TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRatingCV = (android.widget.TextView) itemView.findViewById(R.id.tvRatingCV);
            tvFotoCV = (android.widget.ImageView) itemView.findViewById(R.id.tvFotoCV);

        }
    }
}
