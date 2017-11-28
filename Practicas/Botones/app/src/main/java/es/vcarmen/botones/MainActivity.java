package es.vcarmen.botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private int numero = 0;
    TextView tn;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pondremos en el viewtext el valor de la variable numero (linea 9)
        tn = (TextView) findViewById(R.id.numero); //recogemos el textview
        tn.setText(numero + ""); //le asignamos el valor de la variable numero

        /*
        * ********************************************
        * */

        //ahora controlaremos los botones con un manejador de eventos para cada uno usando una clase(*objeto*) anonima
        /*Button btnInc = (Button) findViewById(R.id.inc); //recogemos el boton de incrementar
        Button btnDec = (Button) findViewById(R.id.dec); //recogemos el boton de decrementar

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero++;
                tn.setText(numero+"");
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero>0) {
                    numero--;
                    tn.setText(numero + "");
                }
            }
        });
        */

        /*
        * ********************************************
        * */

        //ahora lo haremos con un manejador de eventos implementado en la misma clase (MainActivity)
        //en la clase MainActivity implement la clase Onclick y @override el metodo onClick
        Button btnInc = (Button) findViewById(R.id.inc); //recogemos el boton de incrementar
        Button btnDec = (Button) findViewById(R.id.dec); //recogemos el boton de decrementar

        btnDec.setOnClickListener(this);
        btnInc.setOnClickListener(this);

        //ahora añadimos OnLongClick y añadimos el implement en la clase
        btnDec.setOnLongClickListener(this);
        btnInc.setOnLongClickListener(this);

        //ahora el boton toggle, este lo implementamos en una clase anonima o objeto anonimo
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        ToggleButton tBtn = (ToggleButton) findViewById(R.id.tBtn);
        tBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.colorON));
                }else{
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.colorOFF));
                }
            }
        });

        //ahora el boton Switch, lo implementamos en clase anonima aunque se repita
        Switch tSwitch = (Switch) findViewById(R.id.tSwitch);
        tSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.colorON));
                }else{
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.colorOFF));
                }
            }
        });

        // Autocompletar: creamos el array. creamos el adaptador y lo asignamos
        String[] artistas = {"MIGUEL ANGEL", "LEONARDO","BOTICELLI","DONATELLO","RAFAEL", "PERUGINO","MANOLO","MANUEL","MARIA","MIGUEL"};
        ArrayAdapter<String>adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,artistas);
        AutoCompleteTextView texto = (AutoCompleteTextView) findViewById(R.id.textAuto);
        texto.setAdapter(adaptador);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.inc:
                numero++;
                tn.setText(numero+"");
                break;
            case R.id.dec:
                if (numero>0) {
                    numero--;
                    tn.setText(numero + "");
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.inc:
                numero=numero+10;
                tn.setText(numero+"");
                break;
            case R.id.dec:
                if (numero>=10) {
                    numero=numero-10;
                    tn.setText(numero + "");
                }
                break;
            default:
                break;
        }
        return true;
    }
}
