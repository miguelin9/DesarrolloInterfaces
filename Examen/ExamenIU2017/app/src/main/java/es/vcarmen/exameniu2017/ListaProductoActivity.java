//Miguel Castillo Palomo
package es.vcarmen.exameniu2017;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class ListaProductoActivity extends AppCompatActivity {

    static Toolbar toolbar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_producto_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.CYAN);
        setSupportActionBar(toolbar);

        //Catalogo.rellenar();

        listView = (ListView) findViewById(R.id.listView);
        Adaptador adaptador = new Adaptador(this,Catalogo.productos);
        listView.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_lista:
                Intent intent = new Intent(this, ListaProductoActivity.class);
                startActivity(intent);

                return true;
            case R.id.menu_form:
                Intent intent2 = new Intent(this, FormProductoActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
