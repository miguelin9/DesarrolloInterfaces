//Miguel Castillo Palomo
package es.vcarmen.exameniu2017;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Date;

public class FormProductoActivity extends AppCompatActivity {

    Button anadir;
    Toolbar toolbar;

    static String[] categorias = {"Motor", "Electrónica", "Deporte", "Libros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_producto_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setBackgroundColor(Color.CYAN);
        setSupportActionBar(toolbar);

        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.fCategoria);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categorias);
        spinner.setAdapter(adapter);

        anadir = (Button) findViewById(R.id.anadir);
        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((EditText) findViewById(R.id.fTitulo)).getText().toString().isEmpty()
                        ||
                        ((EditText) findViewById(R.id.fPrecio)).getText().toString().isEmpty()){
                    Toast.makeText(getApplication(),"Faltan campos", Toast.LENGTH_SHORT).show();
                }else {
                    Producto producto = new Producto(
                            ((EditText) findViewById(R.id.fTitulo)).getText().toString(),
                            ((EditText) findViewById(R.id.fDescripcion)).getText().toString(),
                            ((EditText) findViewById(R.id.fPrecio)).getText().toString(),
                            ((Spinner) findViewById(R.id.fCategoria)).getSelectedItem().toString(),
                            ((ToggleButton) findViewById(R.id.fFoto)).isChecked(),
                            new Date()
                    );
                    Catalogo.addProducto(producto);
                    Intent intent = new Intent(getApplicationContext(), ListaProductoActivity.class);
                    startActivity(intent);
                }
            }
        });

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
