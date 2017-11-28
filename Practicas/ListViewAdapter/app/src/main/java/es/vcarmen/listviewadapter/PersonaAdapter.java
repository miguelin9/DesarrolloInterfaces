package es.vcarmen.listviewadapter;

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
 * Clase que hereda de un ArrayAdapter y lo modificamos para nuestro gusto
 * Es obligatorio el constructor en nuestro caso solo ponemos el contexto y los datos
 * dentro del constructor llamamos al del padre y de vista le ponemos 0 por defecto.
 *
 * Created by matinal on 16/10/17.
 */

public class PersonaAdapter extends ArrayAdapter<Persona> {

    public PersonaAdapter(@NonNull Context context, @NonNull ArrayList<Persona> lista) {
        super(context, 0, lista);
    }

    /**
     * este metodo lo sobreescribimos
     * Recogemos la persona
     * comprobamos si existe una vista y si no la creamos con un layout xml creado
     * rellenamos la vista con los datos de la persona
     *
     * @param position
     * @param convertView
     * @param parent
     * @return devuelve la vista con los campos rellenos
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Lo primero es obtener la persona
        Persona p = getItem(position);

        // Comprobamos si la vista ya existe o no existe, si no existe asignamos el layout creado en xml
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.persona_item, parent, false);// el false ancla al padre
        }

        // Ahora rellenamos los datos y ojo se pone el findView desde la vista layout
        TextView nombre = (TextView) convertView.findViewById(R.id.nombre);
        TextView apellidos = (TextView) convertView.findViewById(R.id.apellidos);
        nombre.setText(p.getNombre());
        apellidos.setText(p.getApellidos());
        // Ejemplo de como seria en una linea: ((TextView)convertView.findViewById(R.id.nombre)).setText(p.getNombre());

        // y ahora devolvemos la vista ya con los datos
        return convertView;
    }
}
