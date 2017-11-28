package es.vcarmen.tabhostprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recogemos el tabhost
        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        // creamos la pestaña 1 y la añadimos a tabs
        TabHost.TabSpec spec;
        spec = tabs.newTabSpec("tab1");
        spec.setIndicator("Pestaña 1");// asignamos un nombre
        spec.setContent(R.id.tabs1); // es un linearlayout
        tabs.addTab(spec); // añadimos al conjunto de pestañas

        // creamos la pestaña 2 y la añadimos a tabs
        //TabHost.TabSpec spec;
        spec = tabs.newTabSpec("tab2");
        spec.setIndicator("Pestaña 2");// asignamos un nombre
        spec.setContent(R.id.tabs2); // es un linearlayout
        tabs.addTab(spec); // añadimos al conjunto de pestañas

        tabs.setCurrentTab(0); // indica la pestaña por defecto, en este caso la 1\

        // Método escuchador para ejecutar código al cambiar de pestaña

       tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
           @Override
           public void onTabChanged(String tabId) {
               Log.i("DEMOSTRACION","Pulsada pestaña: " + tabId);
           }
       });


    }
}
