package com.vcarmen.socialtech;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miguel on 22/10/17.
 */

public class ContactoAdapter extends ArrayAdapter<Contacto> {

    public ContactoAdapter(@NonNull Context context, @NonNull ArrayList<Contacto> lista) {
        super(context, 0, lista);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // obtenemos el contacto del array
        Contacto c = getItem(position);

        // comprobamos si la vista ya existe, si no existe asignamos el layout creado en el xml
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contacto_item, parent, false); // false ancla al padre
        }

        // Ahora rellenamos los datos y ojo se pone el findView desde la vista layout
        TextView nombreCompleto = (TextView) convertView.findViewById(R.id.tvNombreApellidos);
        TextView email = (TextView) convertView.findViewById(R.id.tvEmail);
        nombreCompleto.setText(c.getNombre() + " " + c.getApellidos());
        email.setText(c.getEmail());

        // por ultimo devolvemos la vista con los datos
        return convertView;
    }
}
