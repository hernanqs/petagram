package android.fundamentos.mascotas;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    java.util.ArrayList<Mascota> mascotas;
    android.app.Activity activity;

    public MascotaAdaptador(java.util.ArrayList<Mascota> mascotas, android.app.Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingCV.setText(Integer.toString(mascota.getLikes()));
        mascotaViewHolder.tvFotoCV.setImageResource(mascota.getImgFoto());

        mascotaViewHolder.btnLike.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                android.widget.Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        android.widget.Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvRatingCV.setText(Integer.toString(constructorMascotas.obtenerLikesmascota(mascota)));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private android.widget.TextView tvNombreCV;
        private android.widget.TextView tvRatingCV;
        private android.widget.ImageView tvFotoCV;
        private android.widget.ImageView btnLike;

        public MascotaViewHolder(android.view.View itemView) {
            super(itemView);
            tvNombreCV = (android.widget.TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRatingCV = (android.widget.TextView) itemView.findViewById(R.id.tvRatingCV);
            tvFotoCV = (android.widget.ImageView) itemView.findViewById(R.id.tvFotoCV);
            btnLike = (android.widget.ImageView) itemView.findViewById(R.id.hueso_amarillo);

        }
    }

}
