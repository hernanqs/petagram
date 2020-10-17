package android.fundamentos.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    java.util.ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ConstructorMascotas constructorMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        android.widget.TextView mTitle = (android.widget.TextView) miActionBar.findViewById(R.id.titulo_toolbar);

        setSupportActionBar(miActionBar);
        mTitle.setText(miActionBar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        android.widget.ImageView mFavoritas = (android.widget.ImageView) miActionBar.findViewById(R.id.mFavoritas);
        mFavoritas.setVisibility(android.view.View.INVISIBLE);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    private ArrayList<androidx.fragment.app.Fragment> agregarFragments() {
        ArrayList<androidx.fragment.app.Fragment> fragments = new ArrayList<>();
        fragments.add(new PerfilFragment());
        return fragments;
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {
        constructorMascotas = new ConstructorMascotas(getApplicationContext());
        mascotas = constructorMascotas.obtenerDatosMascotasFavoritas();
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mContacto:
                android.content.Intent intent = new android.content.Intent(this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                android.content.Intent intent2 = new android.content.Intent(this, About.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}