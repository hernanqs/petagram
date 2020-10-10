package android.fundamentos.mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class Contacto extends AppCompatActivity {
    com.google.android.material.textfield.TextInputEditText inputNombre;
    com.google.android.material.textfield.TextInputEditText inputEmail;
    com.google.android.material.textfield.TextInputEditText inputMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        android.widget.TextView mTitle = (android.widget.TextView) miActionBar.findViewById(R.id.titulo_toolbar);

        setSupportActionBar(miActionBar);
        mTitle.setText(miActionBar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        agregarClickListenerABotonEnviar();
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

    public void agregarClickListenerABotonEnviar() {
        Button botonSiguiente = (Button) findViewById(R.id.boton_enviar);
        botonSiguiente.setOnClickListener(
            new android.view.View.OnClickListener() {
                public void onClick(android.view.View boton) {
                    inputNombre = findViewById(R.id.input_nombre);
                    String nombre = inputNombre.getText().toString();
                    inputEmail = findViewById(R.id.input_email);
                    String email = inputEmail.getText().toString();
                    inputMensaje = findViewById(R.id.input_mensaje);
                    String mensaje = inputMensaje.getText().toString();

                    android.content.Intent intentEnviar = new android.content.Intent(Intent.ACTION_SEND, Uri.fromParts("mailto", "contacto@petagram.com", null));

                    intentEnviar.putExtra(getResources().getString(R.string.extra_nombre), nombre);
                    intentEnviar.putExtra(getResources().getString(R.string.extra_email), email);
                    intentEnviar.putExtra(getResources().getString(R.string.extra_mensaje), mensaje);

                    intentEnviar.setType("text/plain");

                    startActivity(android.content.Intent.createChooser(intentEnviar, "Elije un cliente de Correo:"));
                }
            }
        );

    }

}