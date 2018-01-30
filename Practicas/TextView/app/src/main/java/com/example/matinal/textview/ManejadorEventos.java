package com.example.matinal.textview;

import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by matinal on 2/10/17.
 */

//Hay que imprementar la clase onclicklistener
public class ManejadorEventos implements View.OnClickListener{
    @Override
    public void onClick(View view) {
        Log.d("Pulsacion",((Button)view).getText().toString());//indicara en el android monitor que boton se ha pulsado
        Button btn = (Button) view;
        btn.setText("Botón pulsado");
    }
}
