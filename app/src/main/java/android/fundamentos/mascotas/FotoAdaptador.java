package android.fundamentos.mascotas;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FotoAdaptador extends RecyclerView.Adapter<FotoAdaptador.FotoViewHolder> {
    java.util.ArrayList<Foto> fotos;
    android.app.Activity activity;

    public FotoAdaptador(java.util.ArrayList<Foto> fotos, android.app.Activity activity) {
        this.fotos = fotos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto, parent, false);
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FotoViewHolder mascotaViewHolder, int position) {
        Foto foto = fotos.get(position);
        mascotaViewHolder.tvRatingCV.setText(Integer.toString(foto.getRating()));
        mascotaViewHolder.tvFotoCV.setImageResource(foto.getImgFoto());
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder {
        private android.widget.TextView tvRatingCV;
        private android.widget.ImageView tvFotoCV;
        public FotoViewHolder(android.view.View itemView) {
            super(itemView);
            tvRatingCV = (android.widget.TextView) itemView.findViewById(R.id.tvRatingCV);
            tvFotoCV = (android.widget.ImageView) itemView.findViewById(R.id.tvFotoCV);

        }
    }
}
