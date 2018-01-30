package es.vcarmen.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> agenda;
    private ContactoAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agenda = new ArrayList<Contacto>();
        mockAgenda();

        GridView mGridView = (GridView) findViewById(R.id.agenda);
        adaptador = new ContactoAdapter(this, agenda);
        mGridView.setAdapter(adaptador);

    }

    // Método para probar datos, añade contactos al arraylist
    public void mockAgenda(){
        Contacto c;
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);
        c = new Contacto("Luis", "Molina Garzón", R.drawable.cara);
        agenda.add(c);
        c = new Contacto("Miguel", "Castillo Palomo", R.drawable.cuadro);
        agenda.add(c);

    }
}
