package android.fundamentos.mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        android.widget.TextView mTitle = (android.widget.TextView) miActionBar.findViewById(R.id.titulo_toolbar);

        setSupportActionBar(miActionBar);
        mTitle.setText(miActionBar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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