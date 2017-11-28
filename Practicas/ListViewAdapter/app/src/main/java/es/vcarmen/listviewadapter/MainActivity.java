package es.vcarmen.listviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Persona> lista = mockLista();
        ListView listaView = (ListView) findViewById(R.id.lvLista);
        PersonaAdapter adaptador = new PersonaAdapter(this, lista);
        listaView.setAdapter(adaptador);
    }

    // metodo para generar datos y realizar pruebas (no sirve para la aplicación en si)
    private ArrayList<Persona> mockLista(){
        ArrayList<Persona> lista = new ArrayList<Persona>();
        Persona p1 = new Persona("Miguel","Castillo");
        lista.add(p1);
        p1 = new Persona("Juan","Tractor");
        lista.add(p1);
        p1 = new Persona("Tomas","Garcia");
        lista.add(p1);
        p1 = new Persona("Maria","Flores");
        lista.add(p1);
        p1 = new Persona("Juan","Tractor");
        lista.add(p1);
        p1 = new Persona("Tomas","Garcia");
        lista.add(p1);
        p1 = new Persona("Maria","Flores");
        lista.add(p1);
        p1 = new Persona("Juan","Tractor");
        lista.add(p1);
        p1 = new Persona("Tomas","Garcia");
        lista.add(p1);
        p1 = new Persona("Maria","Flores");
        lista.add(p1);
        p1 = new Persona("Maria","Flores");
        lista.add(p1);
        p1 = new Persona("Juan","Tractor");
        lista.add(p1);
        p1 = new Persona("Tomas","Garcia");
        lista.add(p1);
        p1 = new Persona("Maria","Flores");
        lista.add(p1);
        p1 = new Persona("Juan","Tractor");
        lista.add(p1);
        p1 = new Persona("Tomas","Garcia");
        lista.add(p1);
        p1 = new Persona("Maria","Flores");
        lista.add(p1);

        return lista;
    }
}


