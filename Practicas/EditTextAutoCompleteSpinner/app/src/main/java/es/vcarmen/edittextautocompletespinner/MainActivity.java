package es.vcarmen.edittextautocompletespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Autocompletar: creamos el array. creamos el adaptador y lo asignamos
        String[] artistas = {"MIGUEL ANGEL", "LEONARDO","BOTICELLI","DONATELLO","RAFAEL", "PERUGINO","MANOLO","MANUEL","MARIA","MIGUEL"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,artistas);
        AutoCompleteTextView texto = (AutoCompleteTextView) findViewById(R.id.textAuto);
        texto.setAdapter(adaptador);

        //para el multicomplete usare el mismo adaptador
        MultiAutoCompleteTextView textoMulti = (MultiAutoCompleteTextView) findViewById(R.id.textAutoMulti);
        textoMulti.setAdapter(adaptador);
        textoMulti.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        //Spinner
        String[] ciudades = {"JAÉN","CÓRDOBA","SEVILLA","HUELVA","CÁDIZ","MÁLAGA","GRANADA","ALMERÍA"};
        Spinner spinner = (Spinner) findViewById(R.id.Spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ciudades));

        //Boton
        Button boton = (Button) findViewById(R.id.leer);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String[] arrayLista = {
                ((EditText)findViewById(R.id.editNombre)).getText().toString(),
                ((EditText)findViewById(R.id.editEdad)).getText().toString(),
                ((EditText)findViewById(R.id.editEmail)).getText().toString(),
                ((AutoCompleteTextView)findViewById(R.id.textAuto)).getText().toString(),
                ((MultiAutoCompleteTextView)findViewById(R.id.textAutoMulti)).getText().toString(),
                ((Spinner)findViewById(R.id.Spinner)).getSelectedItem().toString(),
        };
        ListView lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrayLista));
    }
}
