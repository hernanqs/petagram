package android.fundamentos.mascotas;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MascotasRVFragment extends androidx.fragment.app.Fragment {
    java.util.ArrayList<Mascota> mascotas;
    private androidx.recyclerview.widget.RecyclerView listaMascotas;

    private android.content.Context context;
    private ConstructorMascotas constructorMascotas;

    public MascotasRVFragment(Context context) {
        this.context = context;
    }

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
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
    }

}
