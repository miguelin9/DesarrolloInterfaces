package com.vcarmen.socialtech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Contacto c = (Contacto) getIntent().getExtras().get("aux");

        ((TextView) findViewById(R.id.detallesNombre)).setText(c.getNombre());
        ((TextView) findViewById(R.id.detallesApellidos)).setText(c.getApellidos());
        ((TextView) findViewById(R.id.detallesTelefono)).setText(c.getTelefono());
        ((TextView) findViewById(R.id.detallesEmail)).setText(c.getEmail());
        ((TextView) findViewById(R.id.detallesFormacion)).setText(c.getFormacion());
        ((TextView) findViewById(R.id.detallesProvincia)).setText(c.getProvincia());
        ((TextView) findViewById(R.id.detallesEdad)).setText(Integer.toString(c.getEdad()));
        ((TextView) findViewById(R.id.detallesSexo)).setText(c.getSexo());

    }
}
