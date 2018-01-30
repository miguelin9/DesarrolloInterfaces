package es.vcarmen.exameniu2017;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by matinal on 12/12/17.
 */

public class Adaptador extends BaseAdapter {

    List<Producto> list;
    Context context;

    public Adaptador(Context context, List<Producto> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Producto aux = (Producto) getItem(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        view = inflater.inflate(R.layout.vista_lista, parent, false);
        //meter datos al layout
        if (aux.getFoto()) {
            ((ImageView) view.findViewById(R.id.pFoto)).setImageResource(android.R.drawable.ic_input_add);
        }else{
            ((ImageView) view.findViewById(R.id.pFoto)).setImageResource(android.R.drawable.ic_dialog_alert);
        }
        ((TextView) view.findViewById(R.id.pTitulo)).setText(aux.getTitulo());
        ((TextView) view.findViewById(R.id.pPrecio)).setText(String.valueOf(aux.getPrecio()));
        ((TextView) view.findViewById(R.id.pCategoria)).setText(aux.getCategoria());
        ((TextView) view.findViewById(R.id.pFecha)).setText(aux.getFecha());
        return view;
    }
}
