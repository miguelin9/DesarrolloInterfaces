package com.example.matinal.paraborrar;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //establecer la interfaz grafica desde un xml, normalmente coge el del xml en recursos layout
        // la clase R es una clase que se genera al guardar o copilar (a veces falla) donde se crean automaticamente
        // los objetos de referencias como los colores, cadenas...
        // se localiza en app/build/generated/source/r/debug/y la dns nuestra
        TextView mitexto= (TextView) findViewById(R.id.mitexto);
        //este método esta el la clase que heredamos y nos ayuda a encontrar por id lo usamos para cambiar el texto
        mitexto.setText("Texto cambiado desde codigo"); //Esta forma no se recomienda es mejor usar recursos
        mitexto.setText(R.string.mitexto); //esta forma es la recomendada accedemos al recurso desde codigo

        //vamos a cambiar el color en este caso el metodo setTextColor no se traga un recurso hay que crear una clase intermedia que capture el color
        mitexto.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorTitle, null));

        TextView subtitle = new TextView(this);//con el this indicamos que pertenece a este activity
        subtitle.setText(R.string.subtitle);
        ConstraintLayout ll = (ConstraintLayout) findViewById(R.id.milayout);
        ll.addView(subtitle);


    }
}
