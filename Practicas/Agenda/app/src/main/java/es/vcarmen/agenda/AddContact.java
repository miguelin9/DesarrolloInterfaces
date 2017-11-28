package es.vcarmen.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {

    // creo el array de contactos
    ArrayList<Contacto> contactos = new ArrayList<Contacto>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        //añado la barra toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //getSupportActionBar().setIcon(R.drawable.icono);
        getSupportActionBar().setTitle(R.string.tituloAdd);


    }

    public void addContacto(View view) {
        if (((EditText) findViewById(R.id.editNombre)).getText().toString().isEmpty() || ((EditText) findViewById(R.id.editApellidos)).getText().toString().isEmpty() || ((EditText) findViewById(R.id.editTelefono)).getText().toString().isEmpty()) {
            Toast.makeText(this, "Los campos están vacíos", Toast.LENGTH_SHORT).show();
        } else {
            Contacto contacto = new Contacto(((EditText) findViewById(R.id.editNombre)).getText().toString(), ((EditText) findViewById(R.id.editApellidos)).getText().toString(), ((EditText) findViewById(R.id.editTelefono)).getText().toString(), ((RadioButton) findViewById(R.id.radioButtonH)).isChecked(), ((RadioButton) findViewById(R.id.radioButtonM)).isChecked());
            contactos.add(contacto);
            Toast.makeText(this, "Contacto añadido correctamente", Toast.LENGTH_SHORT).show();
        }
    }
}
