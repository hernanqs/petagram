package android.fundamentos.mascotas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MascotasRVFragment extends androidx.fragment.app.Fragment {
    java.util.ArrayList<Mascota> mascotas;
    private androidx.recyclerview.widget.RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rv_mascotas, container, false);

        listaMascotas = (androidx.recyclerview.widget.RecyclerView) v.findViewById(R.id.rvMascotas);

        androidx.recyclerview.widget.LinearLayoutManager llm = new androidx.recyclerview.widget.LinearLayoutManager(getActivity());
        llm.setOrientation(androidx.recyclerview.widget.LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas () {
        mascotas = new ArrayList<Mascota>();

        //Crear mascotas
        mascotas.add(new Mascota(R.drawable.default1, "Roxy", 3));
        mascotas.add(new Mascota(R.drawable.default2, "Catty", 5));
        mascotas.add(new Mascota(R.drawable.default1, "Rob", 2));
        mascotas.add(new Mascota(R.drawable.default2, "Teddy", 4));
        mascotas.add(new Mascota(R.drawable.default1, "Toby", 4));
        mascotas.add(new Mascota(R.drawable.default2, "Rex", 3));
    }

}
