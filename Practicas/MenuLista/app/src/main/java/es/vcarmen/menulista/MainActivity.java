package es.vcarmen.menulista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView etiqueta;
    private TextView respuesta;
    private ListView lista;
    private Object tocado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] datos = new String[]{"OPCIÓN DE MENÚ A", "OPCIÓN DE MENÚ B", "OPCIÓN DE MENÚ C", "OPCIÓN DE MENÚ D", "OPCIÓN DE MENÚ E"};
        etiqueta = (TextView) findViewById(R.id.mensaje);
        respuesta = (TextView) findViewById(R.id.respuesta);
        lista = (ListView) findViewById(R.id.listado);
        registerForContextMenu(etiqueta);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        lista.setAdapter(adaptador);
        registerForContextMenu(etiqueta);
        registerForContextMenu(lista);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        if (v.getId() == R.id.mensaje) {
            inflater.inflate(R.menu.menu06, menu);
        } else if (v.getId() == R.id.listado) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle(lista.getAdapter().getItem(info.position).toString());

            switch (info.position){
                case 0:
                    inflater.inflate(R.menu.menu06_lista1, menu);
                    return;
                case 1:
                    inflater.inflate(R.menu.menu06_lista2, menu);
                    return;
                case 2:
                    inflater.inflate(R.menu.menu06_lista3, menu);
                    return;
                case 3:
                    inflater.inflate(R.menu.menu06_lista4, menu);
                    return;
                case 4:
                    inflater.inflate(R.menu.menu06_lista5, menu);
                    return;
            }

        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.Opc1:
                respuesta.setText("Etiqueta: OPCIÓN A PULSADA");
                return true;
            case R.id.Opc2:
                respuesta.setText("Etiqueta: OPCIÓN B PULSADA");
                return true;
            case R.id.Opc3:
                respuesta.setText("Etiqueta: OPCIÓN C PULSADA");
                return true;
            case R.id.LstOpcA1:
                respuesta.setText("OPCIÓN A1 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcA2:
                respuesta.setText("OPCIÓN A2 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcB1:
                respuesta.setText("OPCIÓN B1 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcB2:
                respuesta.setText("OPCIÓN B2 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcC1:
                respuesta.setText("OPCIÓN C1 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcC2:
                respuesta.setText("OPCIÓN C2 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcD1:
                respuesta.setText("OPCIÓN D1 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcD2:
                respuesta.setText("OPCIÓN D2 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcE1:
                respuesta.setText("OPCIÓN E1 DE LISTA PULSADA");
                return true;
            case R.id.LstOpcE2:
                respuesta.setText("OPCIÓN E2 DE LISTA PULSADA");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
