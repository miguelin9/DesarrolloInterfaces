package com.example.matinal.textview;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityTextView extends AppCompatActivity {

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        //manejando el controlador de eventos para el boton de añadir (btnAdd)
        ll = (LinearLayout) findViewById(R.id.miLinearLayout);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTextView(ll, "Texto añadido por boton con manejador de eventos",14f);
            }
        });

        //usando el boton3 y boton 4 con una clase manejador de eventos
        Button btnChangeTitle = (Button) findViewById(R.id.btnChangeTitle);
        btnChangeTitle.setOnClickListener(new ManejadorEventos());

        Button btnChangeButton = (Button) findViewById(R.id.btnChangeButton);
        btnChangeButton.setOnClickListener(new ManejadorEventos());



        TextView text = (TextView) findViewById(R.id.miTextView);
        text.setText(R.string.miTextView);
        text.append("\n Segunda linea");


        addTextView(ll, "Añado un textView desde un método", 18);

        //tenemos un array de cadenas y los mostraremos con el método creado
        String[] animales = {"Perro", "Gato", "Pájaro", "León"};
        addTextView(ll, "Lista de animales:", 18);
        for (int i = 0; i < animales.length; i++) {
            addTextView(ll, animales[i], 18 + i * 2);
        }

        //despues de crear la animacion en res/anim la añadimos a un elemento en este caso un textview
        // ya tenemos recogido el textview en la variable text linea 18
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.conjunto); //recogemos la animación
        //anim.setRepeatMode(Animation.RESTART); //hacemos que se repita la animacion
        //anim.setRepeatCount(3);//numero de veces que se repite la animacion
        //anim.setRepeatMode(Animation.INFINITE); //se repite indefinidamente //en algunas API solo funciona en el xml
        text.startAnimation(anim); //asignamos la animación al textview
        //ll.startAnimation(anim); //esto asignaria la animación al layout
        //con eso podemos ver que todo lo que herede de view se le puede poner animaciones.


        //ahora crearemos animaciones desde aquí en código lo llevaremos a un metodo para tenerlo más ordenado
        addAnimation(ll.getChildAt(1));//getChildAt() obtiene los view que contenga el layout en dicha posicion

        //cambiaremos la letra y la añadiremos el tipo de archivo tiene que ser .ttf en app/new/folder/assest folder eso nos crea la carpeta y creamos una carpeta fonts y metemos el .ttf lo añadimos
        // las fuentes no las consideramos como la carpeta res de los recursos
        //la carpeta assets se copila junto con la aplicacion para que incluya la app lo que haya dentro
        // para los recursos de assets no se accede desde "R."

        //creamos la fuente y la asignamos a un textview
        Typeface fuenteTitulo = Typeface.createFromAsset(getAssets(), "fonts/Christmas.ttf");
        text.setTypeface(fuenteTitulo);
    }

    //crearemos un método para crear animaciones
    public void addAnimation(View widget) {
        AnimationSet anim = new AnimationSet(true); //creamos el paquete de la animacion

        AlphaAnimation aparition = new AlphaAnimation(0, 1); //crea una animacion alpha
        aparition.setDuration(3000);

        int rp = TranslateAnimation.RELATIVE_TO_PARENT;
        TranslateAnimation desplazamiento = new TranslateAnimation(rp, 0f, rp, 100f, rp, 0f, rp, 0f); //crea una animacion de desplazamiento
        desplazamiento.setDuration(3000);
        desplazamiento.setStartOffset(3000);//despues de ese tiempo empieza la animacion

        anim.addAnimation(aparition); //añade al conjunto la animacion aparition
        anim.addAnimation(desplazamiento);// añade al conjunto la animacion desplazamiento
        widget.startAnimation(anim);//arranca la animacion
    }

    //creamos un método que añade textview y lo añade al layout
    public void addTextView(LinearLayout ll, String text, float size) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        ll.addView(tv);
    }

    //creamos un método que borra los textview del layout menos el primero que se ejecuta al pulsar el boton
    public void deleteAnimals(View view) {
        //el parametro view recoge el propio boton
        Log.d("metodo","Se ha ejecutado el metodo deleteAnimals"); //esta linea la creamos para ver el mensaje y comprobar que se ejcuta el metodo viendo el mensaje en android monitor
          LinearLayout ll = (LinearLayout) findViewById(R.id.miLinearLayout);
        int n = ll.getChildCount();
        for (int i = n-1; i>4; i--){
            Log.d("borrado",i+" "+n);
            ll.removeViewAt(i);
        }
    }
}
