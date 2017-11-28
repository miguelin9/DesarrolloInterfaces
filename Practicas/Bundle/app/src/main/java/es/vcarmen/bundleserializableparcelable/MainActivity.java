package es.vcarmen.bundleserializableparcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Crearemos un boton que incrementa un contador para hacer la prueba
 * Se sobreescribe el método
 * lo guarda en una variable
 * se comprueba si existe salvado de instancia
 * ahora crearemos una clase persona para probar salvar otros objetos
 */
public class MainActivity extends AppCompatActivity {

    private int cont = 0;
    private TextView numero;
    private Button boton;
    // creamos una costante que guarda la informacion a salvar del contador
    private final static String  CONTADOR = "CONTADOR";
    // creamos una costante que guarda la informacion a salvar de persona
    private final static String PER = "PER";
    // creamos Persona
    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = (TextView) findViewById(R.id.contador);
        // si no hay salvado de instancia que pinte 0
        //numero.setText(""+cont);

        // comprobamos si existe el bundle
        if (savedInstanceState != null){
            cont = savedInstanceState.getInt(CONTADOR);
            p = (Persona) savedInstanceState.getSerializable(PER); // necesita casting ya que serializable manda generico
            numero.setText(""+p.toString());
        }


        boton = (Button) findViewById(R.id.incrementar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont++;
                numero.setText(""+cont);
                // sustituimos para probar con persona
                p = new Persona("Miguel","Castillo");
                numero.setText(""+p.toString());
            }
        });




    }

    // Para guardar datos tenemos que sobreescribir el siguiente método
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // indicamos que guarde un entero en la varible CONTADOR con el valor de cont
        outState.putInt(CONTADOR, cont);

        // para guardar objetos tenemos dos opciones serializable y parcelable en android es mejor parcelable
        outState.putSerializable(PER, p);
    }

}
