package com.vcarmen.socialtech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // creo la constante para saveInstance
    private final static String AUX = "";
    TextView total;
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = (TextView) findViewById(R.id.total);

        // Comprobamos si existe savedInstanceState y si existe asignamos el array
        if (savedInstanceState != null){
            contactos = (ArrayList<Contacto>) savedInstanceState.getSerializable(AUX);// recuerda que serializable devuelve un generico de ahí el casting
            total.setText("El n° total de contactos es: " + contactos.size());
        }

        // Multiautocompletetextview formación
        String[] formacion = {"SMR", "DAM", "DAW", "ASIR", "Ingeniería técnica informática", "Ingeniería Informática", "Grado", "Otros"};
        MultiAutoCompleteTextView auto = (MultiAutoCompleteTextView) findViewById(R.id.mactFormacion);
        auto.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, formacion));
        auto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        // Spinner Provincia
        String[] ciudades = {"JAÉN", "CÓRDOBA", "SEVILLA", "HUELVA", "CÁDIZ", "MÁLAGA", "GRANADA", "ALMERÍA"};
        Spinner spinner = (Spinner) findViewById(R.id.spProvincia);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ciudades));

        // Seekbar Edad
        final SeekBar sb = (SeekBar) findViewById(R.id.sbEdad);
        sb.setMax(125);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView aux = (TextView) findViewById(R.id.tvEdad);
                aux.setText("Edad: " + sb.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // ListView de contactos
        final ListView lista = (ListView) findViewById(R.id.lvContactos);
        final ContactoAdapter adaptador = new ContactoAdapter(this, contactos);
        lista.setAdapter(adaptador);
        // metodo para detectar elemento pulsado, rellenar los datos y lanzar otra activity
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Contacto c = (Contacto) adapterView.getItemAtPosition(posicion);

                Intent intent = new Intent(getApplicationContext(), ActivityContacto.class);
                intent.putExtra("aux", c);
                startActivity(intent);
            }
        });

        // Boton Añadir
        Button boton = (Button) findViewById(R.id.btAnadir);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (
                        ((EditText) findViewById(R.id.etNombre)).getText().toString().isEmpty() ||
                                ((EditText) findViewById(R.id.etApellidos)).getText().toString().isEmpty() ||
                                ((EditText) findViewById(R.id.etTelefono)).getText().toString().isEmpty() ||
                                ((EditText) findViewById(R.id.etEmail)).getText().toString().isEmpty() ||
                                ((MultiAutoCompleteTextView) findViewById(R.id.mactFormacion)).getText().toString().isEmpty() ||
                                ((Spinner) findViewById(R.id.spProvincia)).getSelectedItem().toString().isEmpty()
                        ) {
                    Toast.makeText(getApplication(), R.string.errorCampos, Toast.LENGTH_SHORT).show();
                } else {
                    Contacto nuevoContacto = new Contacto(
                            ((EditText) findViewById(R.id.etNombre)).getText().toString(),
                            ((EditText) findViewById(R.id.etApellidos)).getText().toString(),
                            ((EditText) findViewById(R.id.etTelefono)).getText().toString(),
                            ((EditText) findViewById(R.id.etEmail)).getText().toString(),
                            ((MultiAutoCompleteTextView) findViewById(R.id.mactFormacion)).getText().toString(),
                            ((Spinner) findViewById(R.id.spProvincia)).getSelectedItem().toString(),
                            ((SeekBar) findViewById(R.id.sbEdad)).getProgress(),
                            ((RadioButton) findViewById(R.id.rbHombre)).isChecked(),
                            ((RadioButton) findViewById(R.id.rbMujer)).isChecked()
                    );

                    contactos.add(nuevoContacto);

                    // TextView total de contactos
                    total.setText("El n° total de contactos es: " + contactos.size());

                    Toast.makeText(getApplication(), R.string.camposCorrectos, Toast.LENGTH_SHORT).show();

                    //ponemos el adaptador al ListView al pulsar para que se actualice
                    lista.setAdapter(adaptador);
                }
            }
        });

    }// fin onCreate

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(AUX,contactos);
    }
}
