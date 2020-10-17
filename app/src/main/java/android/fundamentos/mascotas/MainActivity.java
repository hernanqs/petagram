package android.fundamentos.mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private com.google.android.material.tabs.TabLayout tabLayout;
    private androidx.viewpager.widget.ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (com.google.android.material.tabs.TabLayout) findViewById(R.id.tabLayout);
        viewPager = (androidx.viewpager.widget.ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        android.widget.TextView mTitle = (android.widget.TextView) miActionBar.findViewById(R.id.titulo_toolbar);

        setSupportActionBar(miActionBar);
        mTitle.setText(miActionBar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private ArrayList<androidx.fragment.app.Fragment> agregarFragments() {
        ArrayList<androidx.fragment.app.Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotasRVFragment(this));
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.perfil);
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