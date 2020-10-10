package android.fundamentos.mascotas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    java.util.ArrayList<Foto> fotos;
    private androidx.recyclerview.widget.RecyclerView listaFotos;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaFotos = (androidx.recyclerview.widget.RecyclerView) v.findViewById(R.id.rvFotos);

        androidx.recyclerview.widget.GridLayoutManager glm = new androidx.recyclerview.widget.GridLayoutManager(getActivity(), 3);
        listaFotos.setLayoutManager(glm);

        inicializarListaFotos();
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador() {
        FotoAdaptador adaptador = new FotoAdaptador(fotos, getActivity());
        listaFotos.setAdapter(adaptador);
    }
    public void inicializarListaFotos () {
        fotos = new ArrayList<Foto>();

        //Crear fotos
        fotos.add(new Foto(R.drawable.default2_mini, 5));
        fotos.add(new Foto(R.drawable.default2_mini, 0));
        fotos.add(new Foto(R.drawable.default2_mini, 3));
        fotos.add(new Foto(R.drawable.default2_mini, 10));
        fotos.add(new Foto(R.drawable.default2_mini, 2));
        fotos.add(new Foto(R.drawable.default2_mini, 3));
        fotos.add(new Foto(R.drawable.default2_mini, 5));
        fotos.add(new Foto(R.drawable.default2_mini, 7));
        fotos.add(new Foto(R.drawable.default2_mini, 4));
    }

}