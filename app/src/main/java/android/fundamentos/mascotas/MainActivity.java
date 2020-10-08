package android.fundamentos.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    java.util.ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        android.widget.TextView mTitle = (android.widget.TextView) miActionBar.findViewById(R.id.titulo_toolbar);

        setSupportActionBar(miActionBar);
        mTitle.setText(miActionBar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }
    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
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

    public void irAMascotasFavoritas(android.view.View v) {
        android.content.Intent intent = new android.content.Intent(this, MascotasFavoritas.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

}