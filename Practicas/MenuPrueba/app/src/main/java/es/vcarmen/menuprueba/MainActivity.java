package es.vcarmen.menuprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Hay que sobreescribir este metodo y inflar el menu, en este caso desde recurso
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);

        return true;
    }
    */

    // en este caso creamos el menu desde codigo sin usar recurso (hay que usar las constantes de clase)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "Opcion A desde Java").setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(Menu.NONE, 2, Menu.NONE, "Opcion B desde Java").setIcon(android.R.drawable.ic_menu_compass);
        menu.add(Menu.NONE, 3, Menu.NONE, "Opcion C desde Java").setIcon(android.R.drawable.ic_menu_agenda);

        return true;
    }

    // ---------- menu_opciones ----------------
    // Y para manejar los eventos de click sobreescribimos este con recurso se pone el id en el case y sin recurso el mismo numero que ponemos al crearlos.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "Pulsada opcion 1", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(this, "Pulsada opcion 2", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "Pulsada opcion 3", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
