package es.vcarmen.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by matinal on 30/10/17.
 */

public class ContactoAdapter extends BaseAdapter {

    private List<Contacto> lista;
    private Context mContext;

    public ContactoAdapter(Context mContext, List<Contacto> lista) {
        this.lista = lista;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lista.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Contacto c = (Contacto) getItem(i);

        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.gridview_layout, viewGroup, false);
        }

        ((ImageView)view.findViewById(R.id.foto)).setImageResource(c.getFoto());
        ((TextView)view.findViewById(R.id.nombre)).setText(c.getNombre());
        ((TextView)view.findViewById(R.id.apellidos)).setText(c.getApellidos());

        return view;
    }
}
